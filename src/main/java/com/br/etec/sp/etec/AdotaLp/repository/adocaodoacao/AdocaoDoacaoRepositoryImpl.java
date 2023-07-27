package com.br.etec.sp.etec.AdotaLp.repository.adocaodoacao;

import com.br.etec.sp.etec.AdotaLp.model.AdocaoDoacao;
import com.br.etec.sp.etec.AdotaLp.repository.filter.AdocaoDoacaoFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.AdocaoDoacaoDTO;
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

public class AdocaoDoacaoRepositoryImpl implements AdocaoDoacaoRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<AdocaoDoacaoDTO> filtrar(AdocaoDoacaoFilter adocaodoacaofilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<AdocaoDoacaoDTO> criteria = builder.createQuery(AdocaoDoacaoDTO.class);
        Root<AdocaoDoacao> root = criteria.from(AdocaoDoacao.class);

        criteria.select(builder.construct(AdocaoDoacaoDTO.class,
                root.get("id"),
                root.get("dataadocao"),
                root.get("animal").get("nomeanimal"),
                root.get("adotante").get("nome"),
                root.get("doador").get("nome")
        ));

        Predicate[] predicates = criarrestricoes(adocaodoacaofilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.desc(root.get("dataadocao")));

        TypedQuery<AdocaoDoacaoDTO> query = manager.createQuery(criteria);

        return  new PageImpl<>(query.getResultList(), pageable, total(adocaodoacaofilter));
    }

    private Long total(AdocaoDoacaoFilter adocaodoacaofilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<AdocaoDoacao> root = criteria.from(AdocaoDoacao.class);

        Predicate[] predicates = criarrestricoes(adocaodoacaofilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.desc(root.get("dataadocao")));

        criteria.select(builder.count(root));

        return  manager.createQuery(criteria).getSingleResult();
    }

    private void addrestricoesdepaginacao(TypedQuery<?> query, Pageable pageable){
        int paginaatual = pageable.getPageNumber();
        int totalresgistros = pageable.getPageSize();
        int primeiroregistrodepagina = paginaatual * totalresgistros;

        query.setFirstResult(primeiroregistrodepagina);
        query.setMaxResults(totalresgistros);
    }

    private Predicate[] criarrestricoes(AdocaoDoacaoFilter adocaodoacaofilter, CriteriaBuilder builder, Root root){

        List<Predicate> predicates = new ArrayList<>();

        // Mesmo erro da tabela de Animal
      
        if (adocaodoacaofilter.getDataadocao() != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("dataadocao"), adocaodoacaofilter.getDataadocao()));
        }
        if (!StringUtils.isEmpty(adocaodoacaofilter.getNomeanimal())){
            predicates.add(builder.like(builder.lower(root.get("animal").get("nomeanimal")),
                    "%" + adocaodoacaofilter.getNomeanimal() + "%"));
        }
        if (!StringUtils.isEmpty(adocaodoacaofilter.getNomeadotante())){
            predicates.add(builder.like(builder.lower(root.get("adotante").get("nome")),
                    "%" + adocaodoacaofilter.getNomeadotante() + "%"));
        }
        if (!StringUtils.isEmpty(adocaodoacaofilter.getNomedoador())){
            predicates.add(builder.like(builder.lower(root.get("doador").get("nome")),
                    "%" + adocaodoacaofilter.getNomedoador() + "%"));
        }


        return predicates.toArray(new Predicate[predicates.size()]);
    }

}
