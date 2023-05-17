package com.br.etec.sp.etec.AdotaLp.repository;

import com.br.etec.sp.etec.AdotaLp.model.Estado;
import com.br.etec.sp.etec.AdotaLp.repository.estado.EstadoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>, EstadoRepositoryQuery {
}
