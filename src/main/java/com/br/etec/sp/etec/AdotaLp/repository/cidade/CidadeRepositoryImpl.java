package com.br.etec.sp.etec.AdotaLp.repository.cidade;

import com.br.etec.sp.etec.AdotaLp.model.Cidade;
import com.br.etec.sp.etec.AdotaLp.repository.filter.CidadeFilter;
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
    public Page<Cidade> Filtrar(CidadeFilter cidadefilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Cidade> criteria = builder.createQuery(Cidade.class);
        Root<Cidade> root = criteria.from((Cidade.class));

        Predicate[] predicates = criarrestricoes(cidadefilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy((builder.asc(root.get("nome"))));

        TypedQuery<Cidade> query= manager.createQuery(criteria);

        return new PageImpl<>(query.getResultList(), pageable, total(cidadefilter));
    }

    private Long total(CidadeFilter cidadefilter) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Cidade> root = criteria.from((Cidade.class));

        Predicate[] predicates = criarrestricoes(cidadefilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy((builder.asc(root.get("nome"))));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();

    }

    private void addrestricoesdepaginacao(TypedQuery<Cidade> query, Pageable pageable){
        int paginaatual = pageable.getPageNumber();
        int totalderesgistro = pageable.getPageSize();
        int primeiroregistro = paginaatual * totalderesgistro;

        query.setFirstResult(primeiroregistro);
        query.setMaxResults(totalderesgistro);
    }

    private Predicate[] criarrestricoes(CidadeFilter cidadefilter, CriteriaBuilder builder, Root<Cidade> root) {

        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(cidadefilter.getNome())) {
            predicates.add(builder.like(builder.lower(root.get("nome")),
                    "%" + cidadefilter.getNome().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);

    }
}
