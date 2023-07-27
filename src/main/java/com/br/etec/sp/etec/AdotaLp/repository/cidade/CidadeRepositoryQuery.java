package com.br.etec.sp.etec.AdotaLp.repository.cidade;

import com.br.etec.sp.etec.AdotaLp.model.Cidade;
import com.br.etec.sp.etec.AdotaLp.repository.filter.CidadeFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.CidadeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CidadeRepositoryQuery {

    public Page<CidadeDTO> Filtrar(CidadeFilter cidadefilter, Pageable pageable);
}
