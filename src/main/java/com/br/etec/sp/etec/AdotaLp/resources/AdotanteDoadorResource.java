package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.AdotanteDoador;
import com.br.etec.sp.etec.AdotaLp.repository.AdotanteDoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adotantedoador")
public class AdotanteDoadorResource {

    @Autowired
    private AdotanteDoadorRepository adotantedoadorrepository;

    @GetMapping("/todos")
    public List<AdotanteDoador> listaradotantedoador(){
        return adotantedoadorrepository.findAll();
    }
}
