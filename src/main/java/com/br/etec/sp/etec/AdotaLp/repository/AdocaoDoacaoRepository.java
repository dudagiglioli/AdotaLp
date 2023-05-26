package com.br.etec.sp.etec.AdotaLp.repository;

import com.br.etec.sp.etec.AdotaLp.model.AdocaoDoacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdocaoDoacaoRepository extends JpaRepository<AdocaoDoacao, Integer>{
}
