package com.br.etec.sp.etec.AdotaLp.repository.raca;

import com.br.etec.sp.etec.AdotaLp.model.Raca;
import com.br.etec.sp.etec.AdotaLp.repository.filter.RacaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RacaRepositoryQuery {

    public Page<Raca> Filtrar(RacaFilter racafilter, Pageable pageable);
}