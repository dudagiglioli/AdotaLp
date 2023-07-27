package com.br.etec.sp.etec.AdotaLp.repository.cidade;

import com.br.etec.sp.etec.AdotaLp.model.Cidade;
import com.br.etec.sp.etec.AdotaLp.repository.filter.CidadeFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.CidadeDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CidadeRepositoryImpl implements  CidadeRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;


    @Override
    public Page<CidadeDTO> Filtrar(CidadeFilter cidadefilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<CidadeDTO> criteria = builder.createQuery(CidadeDTO.class);
        Root<Cidade> root = criteria.from(Cidade.class);

        criteria.select(builder.construct(CidadeDTO.class,
                root.get("id"),
                root.get("nomecidade"),
                root.get("estado").get("nomeestado"),
                root.get("estado").get("sigla")
        ));

        Predicate[] predicates = criarRestricoes(cidadefilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomecidade")));

        TypedQuery<CidadeDTO> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);


        return new PageImpl<>(query.getResultList(), pageable, total(cidadefilter));
    }


    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroPágina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroPágina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Long total(CidadeFilter cidadefilter){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Cidade> root = criteria.from(Cidade.class);

        Predicate[] predicates = criarRestricoes(cidadefilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomecidade")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    private Predicate[] criarRestricoes(CidadeFilter cidadefilter, CriteriaBuilder builder, Root<Cidade> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(cidadefilter.getNomecidade())){
            predicates.add(builder.like(builder.lower(root.get("nomealuno")),
                    "%" + cidadefilter.getNomecidade().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(cidadefilter.getNomeestado())){
            predicates.add(builder.like(builder.lower(root.get("nomeestado")),
                    "%" + cidadefilter.getNomeestado().toLowerCase() + "%"));
        }
        if (!StringUtils.isEmpty(cidadefilter.getSigla())){
            predicates.add(builder.like(builder.lower(root.get("sigla")),
                    cidadefilter.getSigla().toLowerCase()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }




}
