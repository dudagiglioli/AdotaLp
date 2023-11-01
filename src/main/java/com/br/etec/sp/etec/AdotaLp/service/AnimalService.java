package com.br.etec.sp.etec.AdotaLp.service;

import com.br.etec.sp.etec.AdotaLp.model.Animal;
import com.br.etec.sp.etec.AdotaLp.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalrepositoy;

    public Animal saveAnimal(Animal animal){
        return animalrepositoy.save(animal);
    }

    public List<Animal> saveAllAnimal(List<Animal> animalList){
        return animalrepositoy.saveAll(animalList);  }

    public List<Animal> fetchAllAnimal(){
        return animalrepositoy.findAll();
    }

    public Optional<Animal> fetchAnimalById(int id){
        return animalrepositoy.findById(id);
    }

    public void deleteAnimalById(int id){
        animalrepositoy.deleteById(id);
    }

    public void deleteAllAnimal(){
        animalrepositoy.deleteAll();
    }

    public Animal updateAnimalDetails(Animal animal){
        return animalrepositoy.save(animal);
    }
}
