package com.br.etec.sp.etec.AdotaLp.repository.situacaoanimal;

import com.br.etec.sp.etec.AdotaLp.repository.filter.SituacaoAnimalFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.SituacaoAnimalDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SituacaoAnimalRepositoryQuery {

    public Page<SituacaoAnimalDTO> Filtrar(SituacaoAnimalFilter situacaoanimalfilter, Pageable pageable);
}
