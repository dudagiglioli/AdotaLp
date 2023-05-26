package com.br.etec.sp.etec.AdotaLp.repository.adotantedoador;

import com.br.etec.sp.etec.AdotaLp.model.AdotanteDoador;
import com.br.etec.sp.etec.AdotaLp.repository.filter.AdotanteDoadorFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdotanteDoadorRepositoryQuery {

    public Page<AdotanteDoador> Filtrar(AdotanteDoadorFilter adotantedoadorfilter, Pageable pageable);

}
