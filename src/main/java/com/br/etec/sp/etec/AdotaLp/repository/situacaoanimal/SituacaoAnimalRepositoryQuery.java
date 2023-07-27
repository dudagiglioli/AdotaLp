package com.br.etec.sp.etec.AdotaLp.repository.situacaoanimal;

import com.br.etec.sp.etec.AdotaLp.model.SituacaoAnimal;
import com.br.etec.sp.etec.AdotaLp.repository.filter.SituacaoAnimalFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SituacaoAnimalRepositoryQuery {

    public Page<SituacaoAnimal> Filtrar(SituacaoAnimalFilter situacaoanimalfilter, Pageable pageable);
}