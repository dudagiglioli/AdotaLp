package com.br.etec.sp.etec.AdotaLp.repository.situacaoanimal;

import com.br.etec.sp.etec.AdotaLp.model.SituacaoAnimal;
import com.br.etec.sp.etec.AdotaLp.repository.filter.SituacaoAnimalFilter;
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

public class SituacaoAnimalRepositoryImpl implements SituacaoAnimalRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<SituacaoAnimal> Filtrar(SituacaoAnimalFilter situacaoanimalfilter, Pageable pageable){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<SituacaoAnimal> criteria = builder.createQuery(SituacaoAnimal.class);
        Root<SituacaoAnimal> root = criteria.from(SituacaoAnimal.class);

        Predicate[] predicates = criarrestricoes(situacaoanimalfilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("descricao")));

        TypedQuery<SituacaoAnimal> query = manager.createQuery(criteria);

        return null;
    }

    private Predicate[] criarrestricoes(SituacaoAnimalFilter situacaoanimalfilter, CriteriaBuilder builder, Root root){

        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(situacaoanimalfilter.getDescricao())){
            predicates.add(builder.like(builder.lower(root.get("descricao")),
                    "%" + situacaoanimalfilter.getDescricao() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);

    }
}
