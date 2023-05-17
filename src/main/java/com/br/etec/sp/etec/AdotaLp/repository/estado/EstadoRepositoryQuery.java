package com.br.etec.sp.etec.AdotaLp.repository.estado;

import com.br.etec.sp.etec.AdotaLp.model.Estado;
import com.br.etec.sp.etec.AdotaLp.repository.filter.EstadoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EstadoRepositoryQuery {

    public Page<Estado> Filtrar(EstadoFilter estadofilter, Pageable pageable);
}
