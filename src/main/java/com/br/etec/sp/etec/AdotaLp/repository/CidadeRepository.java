package com.br.etec.sp.etec.AdotaLp.repository;

import com.br.etec.sp.etec.AdotaLp.model.Cidade;
import com.br.etec.sp.etec.AdotaLp.repository.cidade.CidadeRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer>, CidadeRepositoryQuery {
}
