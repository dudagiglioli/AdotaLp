package com.br.etec.sp.etec.AdotaLp.service;

import com.br.etec.sp.etec.AdotaLp.model.SituacaoAnimal;
import com.br.etec.sp.etec.AdotaLp.repository.SituacaoAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SituacaoAnimalService {
    @Autowired

    private SituacaoAnimalRepository situacaoAnimalRepository;

    public List<SituacaoAnimal> fetchAllSituacaoAnimal(){
        return situacaoAnimalRepository.findAll();
    }

    public Optional<SituacaoAnimal> fetchSituacaoAnimalById(int id){
        return situacaoAnimalRepository.findById(id);
    }


    public SituacaoAnimal updateSituacaoAnimalDetails(SituacaoAnimal situacaoAnimal){
        return situacaoAnimalRepository.save(situacaoAnimal);
    }
}
