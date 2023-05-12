package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.SituacaoAnimal;
import com.br.etec.sp.etec.AdotaLp.repository.SituacaoAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/situacaoanimal")
public class SituacaoAnimalResource {

    @Autowired
    private SituacaoAnimalRepository situacaoanimalrepository;

    @GetMapping("/todos")
    public List<SituacaoAnimal> listarsituacaoanimal(){
        return situacaoanimalrepository.findAll();
    }
}
