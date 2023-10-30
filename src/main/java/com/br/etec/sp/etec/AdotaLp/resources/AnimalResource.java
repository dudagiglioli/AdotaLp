package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.Animal;
import com.br.etec.sp.etec.AdotaLp.repository.AnimalRepository;
import com.br.etec.sp.etec.AdotaLp.repository.filter.AnimalFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.AnimalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/animal")
public class AnimalResource {

    @Autowired
    private AnimalRepository animalrepository;

    @PostMapping("/saveAnimal")
    public Animal saveAnimal(@RequestBody Animal animal){
        return animalrepository.saveAnimal(Animal);
    }

    @PostMapping("/saveAllAnimal")
    public List<Animal> saveAllAnimal(){
        return animalrepository.saveAllAnimal(@RequestBody List<Animal> listaranimal()){
            return animalrepository.fetchAllAnimal(listaranimal());
        }
    }

    @GetMapping()
    public Page<AnimalDTO> pesquisar(AnimalFilter animalfilter, Pageable pageable){
        return animalrepository.Filtrar(animalfilter, pageable);
    }

    @GetMapping("/todos")
    public List<Animal> listaranimal(){
        return animalrepository.findAll();
    }

    @DeleteMapping("deleteAnimalById/{id}")
    public  void deleteAnimalById(@PathVariable int id){
        animalrepository.deleteAnimalById(id);
    }
}
