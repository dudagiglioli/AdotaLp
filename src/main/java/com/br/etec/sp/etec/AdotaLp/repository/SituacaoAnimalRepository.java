package com.br.etec.sp.etec.AdotaLp.repository;

import com.br.etec.sp.etec.AdotaLp.model.SituacaoAnimal;
import com.br.etec.sp.etec.AdotaLp.repository.situacaoanimal.SituacaoAnimalRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoAnimalRepository extends JpaRepository<SituacaoAnimal, Integer>, SituacaoAnimalRepositoryQuery {
}
