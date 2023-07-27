package com.br.etec.sp.etec.AdotaLp.repository.adocaodoacao;

import com.br.etec.sp.etec.AdotaLp.model.AdocaoDoacao;
import com.br.etec.sp.etec.AdotaLp.repository.filter.AdocaoDoacaoFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.AdocaoDoacaoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdocaoDoacaoRepositoryQuery {

    public Page<AdocaoDoacaoDTO> filtrar(AdocaoDoacaoFilter adocaodoacaofilter, Pageable pageable);
}
