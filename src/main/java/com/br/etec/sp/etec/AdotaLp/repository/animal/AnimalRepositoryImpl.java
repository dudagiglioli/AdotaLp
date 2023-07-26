package com.br.etec.sp.etec.AdotaLp.repository.animal;

import com.br.etec.sp.etec.AdotaLp.model.Animal;
import com.br.etec.sp.etec.AdotaLp.repository.filter.AnimalFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.AnimalDTO;
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

public class AnimalRepositoryImpl implements  AnimalRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<AnimalDTO> Filtrar(AnimalFilter animalfilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<AnimalDTO> criteria = builder.createQuery(AnimalDTO.class);
        Root<Animal> root = criteria.from(Animal.class);

        criteria.select(builder.construct(AnimalDTO.class,
                root.get("id"),
                root.get("nome"),
                root.get("sexo"),
                root.get("idade"),
                root.get("porte"),
                root.get("raca").get("descricao"),
                root.get("situacaoanimal").get("situcao"),
                root.get("cidade").get("nomecidade"),
                root.get("estado").get("nomeestado")
                ));

        Predicate[] predicates = criarrestricoes(animalfilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nome")));

        TypedQuery<AnimalDTO> query = manager.createQuery(criteria);
        adicionasrestricoesdepaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(animalfilter));
    }

    private Long total(AnimalFilter animalfilter){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Animal> root = criteria.from(Animal.class);

        Predicate[] predicates = criarrestricoes(animalfilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nome")));

        criteria.select(builder.count(root));


        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionasrestricoesdepaginacao(TypedQuery<?> query, Pageable pageable){
        int paginaatual = pageable.getPageNumber();
        int totalregistrospagina = pageable.getPageSize();
        int primeiroregistropagina = paginaatual * totalregistrospagina;

        query.setFirstResult(primeiroregistropagina);
        query.setMaxResults(totalregistrospagina);
    }

    private Predicate[] criarrestricoes(AnimalFilter animalfilter, CriteriaBuilder builder, Root<Animal> root){

        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(animalfilter.getNome())){
            predicates.add(builder.like(builder.lower(root.get("nome")),
                    "%" + animalfilter.getNome().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(animalfilter.getSexo())){
            predicates.add(builder.like(builder.lower(root.get("sexo")),
                    "%" + animalfilter.getSexo().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(animalfilter.getNomecidade())){
            predicates.add(builder.like(builder.lower(root.get("nomecidade").get("nomecidade")),
                    "%" + animalfilter.getNomecidade().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(animalfilter.getNomeestado())){
            predicates.add(builder.like(builder.lower(root.get("nomeestado")),
                    "%" + animalfilter.getSexo().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(animalfilter.getDescricaoraca())){
            predicates.add(builder.like(builder.lower(root.get("descricaoraca")),
                    "%" + animalfilter.getSexo().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(animalfilter.getSituacaoanimal())){
            predicates.add(builder.like(builder.lower(root.get("situacaoanimal")),
                    "%" + animalfilter.getSexo().toLowerCase() + "%"));
        }

        if(animalfilter.getIdade() != null){
            predicates.add(builder.equal(root.get("idade"), animalfilter.getIdade()));
        }

        if(animalfilter.getPorte() != null){
            predicates.add(builder.equal(root.get("porte"),animalfilter.getPorte()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
