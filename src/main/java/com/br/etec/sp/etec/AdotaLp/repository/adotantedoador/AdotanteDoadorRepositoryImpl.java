package com.br.etec.sp.etec.AdotaLp.repository.adotantedoador;

import com.br.etec.sp.etec.AdotaLp.model.AdotanteDoador;
import com.br.etec.sp.etec.AdotaLp.repository.filter.AdotanteDoadorFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.AdotanteDoadorDTO;
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

public class AdotanteDoadorRepositoryImpl implements AdotanteDoadorRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public Page<AdotanteDoadorDTO> Filtrar(AdotanteDoadorFilter adotantedoadorfilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<AdotanteDoadorDTO> criteria = builder.createQuery(AdotanteDoadorDTO.class);
        Root<AdotanteDoador> root = criteria.from(AdotanteDoador.class);

        criteria.select(builder.construct(AdotanteDoadorDTO.class,
            root.get("id"),
            root.get("nome"),
        root.get("cpf"),
        root.get("telefone"),
        root.get("email"),
        root.get("dtnascimento"),
        root.get("endereco"),
                root.get("cidade").get("nomecidade")
                ));

        Predicate[] predicates = criarrestricoes(adotantedoadorfilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nome")));

        TypedQuery<AdotanteDoadorDTO> query = manager.createQuery(criteria);

        return new PageImpl<>(query.getResultList(), pageable, total(adotantedoadorfilter));
    }

    private Long total(AdotanteDoadorFilter adotantedoadorfilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<AdotanteDoador> root = criteria.from(AdotanteDoador.class);

        Predicate[] predicates = criarrestricoes(adotantedoadorfilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nome")));

        criteria.select(builder.count(root));


       return manager.createQuery(criteria).getSingleResult();
    }

    private void addrestricoesdepaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginaatual = pageable.getPageNumber();
        int totalresgistros = pageable.getPageSize();
        int primeiroregistrodepagina = paginaatual * totalresgistros;

        query.setFirstResult(primeiroregistrodepagina);
        query.setMaxResults(totalresgistros);
    }

    private Predicate[] criarrestricoes(AdotanteDoadorFilter adotantedoadorfilter, CriteriaBuilder builder, Root root) {

        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(adotantedoadorfilter.getNome())) {
            predicates.add(builder.like(builder.lower(root.get("nome")),
                    "%" + adotantedoadorfilter.getNome() + "%"));
        }
        if (!StringUtils.isEmpty(adotantedoadorfilter.getCpf())) {
            predicates.add(builder.like(builder.lower(root.get("cpf")),
                    "%" + adotantedoadorfilter.getCpf() + "%"));
        }
        if (!StringUtils.isEmpty(adotantedoadorfilter.getEndereco())) {
            predicates.add(builder.like(builder.lower(root.get("endereco")),
                    "%" + adotantedoadorfilter.getEndereco() + "%"));
        }
        if (!StringUtils.isEmpty(adotantedoadorfilter.getTelefone())) {
            predicates.add(builder.like(builder.lower(root.get("telefone")),
                    "%" + adotantedoadorfilter.getTelefone() + "%"));
        }
        if (!StringUtils.isEmpty(adotantedoadorfilter.getEmail())) {
            predicates.add(builder.like(builder.lower(root.get("email")),
                    "%" + adotantedoadorfilter.getEmail() + "%"));
        }
        if(adotantedoadorfilter.getDtnascimento() != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("dtnascimento"), adotantedoadorfilter.getDtnascimento()));
        }
        if (!StringUtils.isEmpty(adotantedoadorfilter.getEmail())) {
            predicates.add(builder.like(builder.lower(root.get("nomecidade")),
                    "%" + adotantedoadorfilter.getEmail() + "%"));
        }

        return  predicates.toArray(new Predicate[predicates.size()]);

    }
}