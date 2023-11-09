package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.SituacaoAnimal;
import com.br.etec.sp.etec.AdotaLp.service.SituacaoAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/situacaoanimal")
public class SituacaoAnimalResource {

    @Autowired
    private SituacaoAnimalService situacaoAnimalService;

    @GetMapping("/getSituacaoAnimal")
    public List<SituacaoAnimal> getAllAnimal() {
        return situacaoAnimalService.fetchAllSituacaoAnimal();
    }

    @GetMapping("/getSituacaoAnimalById/{id}")
    public Optional<SituacaoAnimal> getSituacaoAnimalDtails(@PathVariable int id){
        return situacaoAnimalService.fetchSituacaoAnimalById(id);
    }

    @PutMapping("updateSituacaoAnimal/{id}")
    public SituacaoAnimal updateSituacaoAnimalDetails(@RequestBody SituacaoAnimal situacaoAnimal){
        return situacaoAnimalService.updateSituacaoAnimalDetails(situacaoAnimal);
    }
}
