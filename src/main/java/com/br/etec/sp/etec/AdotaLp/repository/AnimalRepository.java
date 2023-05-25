package com.br.etec.sp.etec.AdotaLp.repository;

import com.br.etec.sp.etec.AdotaLp.model.Animal;
import com.br.etec.sp.etec.AdotaLp.repository.animal.AnimalRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>, AnimalRepositoryQuery {
}
