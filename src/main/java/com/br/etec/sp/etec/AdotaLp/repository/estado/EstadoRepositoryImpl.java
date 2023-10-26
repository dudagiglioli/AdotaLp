package com.br.etec.sp.etec.AdotaLp.repository.estado;

import com.br.etec.sp.etec.AdotaLp.model.Estado;
import com.br.etec.sp.etec.AdotaLp.repository.filter.EstadoFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Predicates;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class EstadoRepositoryImpl implements EstadoRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Estado> Filtrar(EstadoFilter estadofilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Estado> criteria = builder.createQuery(Estado.class);
        Root<Estado> root = criteria.from(Estado.class);

        Predicate[] predicates = criarrestricoes(estadofilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomeestado")));

        TypedQuery<Estado> query = manager.createQuery(criteria);
        addrestricoespaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(estadofilter));
    }

    private  Long total(EstadoFilter estadofilter){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Estado> root = criteria.from(Estado.class);

        Predicate[] predicates = criarrestricoes(estadofilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomeestado")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();

    }

    private void addrestricoespaginacao(TypedQuery<Estado> query, Pageable pageable){
        int paginaatual = pageable.getPageNumber();
        int totaldresgistrospagina = pageable.getPageSize();
        int primeiroresgistropagina = paginaatual * totaldresgistrospagina;

        query.setFirstResult(primeiroresgistropagina);
        query.setMaxResults(totaldresgistrospagina);
    }

    private Predicate[] criarrestricoes(EstadoFilter estadofilter, CriteriaBuilder builder, Root<Estado> root) {

        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(estadofilter.getNomeestado())){
            predicates.add(builder.like(builder.lower(root.get("nomeestado")),
                    "%" + estadofilter.getNomeestado().toLowerCase() + "%"));

        }
        if (!StringUtils.isEmpty(estadofilter.getSigla())){
            predicates.add(builder.equal(builder.lower(root.get("sigla")),
                    estadofilter.getSigla().toLowerCase()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);

    }
    


}
