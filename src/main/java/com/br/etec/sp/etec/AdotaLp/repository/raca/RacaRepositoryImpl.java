package com.br.etec.sp.etec.AdotaLp.repository.raca;

import com.br.etec.sp.etec.AdotaLp.model.Raca;
import com.br.etec.sp.etec.AdotaLp.repository.filter.RacaFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
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

public class RacaRepositoryImpl implements RacaRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;


    @Override
    public Page<Raca> Filtrar(RacaFilter racafilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Raca> criteria = builder.createQuery(Raca.class);
        Root<Raca> root = criteria.from(Raca.class);

        Predicate[] predicates = criarrestricoes(racafilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nome")));

        TypedQuery<Raca> query = manager.createQuery(criteria);

        return null;
    }

    private Predicate[] criarrestricoes(RacaFilter racafilter, CriteriaBuilder builder, Root root){

        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(racafilter.getDescricao())){
            predicates.add(builder.like(builder.lower(root.get("descricao")),
                    "%" + racafilter.getDescricao().toLowerCase() + "%" ));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

}
