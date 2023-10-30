package com.br.etec.sp.etec.AdotaLp.service;

import com.br.etec.sp.etec.AdotaLp.model.Animal;
import com.br.etec.sp.etec.AdotaLp.repository.AnimalRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    private AnimalRepository animalrepositoy;

    public Animal saveAnimal(Animal animal){
        return animalrepositoy.save(animal);
    }
}
