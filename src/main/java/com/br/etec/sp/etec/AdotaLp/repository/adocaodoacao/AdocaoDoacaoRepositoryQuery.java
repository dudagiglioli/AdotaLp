package com.br.etec.sp.etec.AdotaLp.repository.adocaodoacao;

import com.br.etec.sp.etec.AdotaLp.model.AdocaoDoacao;
import com.br.etec.sp.etec.AdotaLp.repository.filter.AdocaoDoacaoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdocaoDoacaoRepositoryQuery {

    public Page<AdocaoDoacao> filtrar(AdocaoDoacaoFilter adocaodoacaofilter, Pageable pageable);
}
