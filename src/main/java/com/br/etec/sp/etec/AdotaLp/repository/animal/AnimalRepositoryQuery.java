package com.br.etec.sp.etec.AdotaLp.repository.animal;

import com.br.etec.sp.etec.AdotaLp.model.Animal;
import com.br.etec.sp.etec.AdotaLp.repository.filter.AnimalFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.AnimalDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnimalRepositoryQuery {

    public Page<AnimalDTO> Filtrar(AnimalFilter animalfilter, Pageable pageable);

}
