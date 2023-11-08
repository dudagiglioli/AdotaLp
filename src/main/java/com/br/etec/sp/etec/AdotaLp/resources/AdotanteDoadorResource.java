package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.AdotanteDoador;
import com.br.etec.sp.etec.AdotaLp.repository.AdotanteDoadorRepository;
import com.br.etec.sp.etec.AdotaLp.repository.filter.AdotanteDoadorFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.AdotanteDoadorDTO;
import com.br.etec.sp.etec.AdotaLp.service.AdotanteDoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/adotantedoador")
public class AdotanteDoadorResource {

    @Autowired
    private AdotanteDoadorService adotanteDoadorService;

    @PostMapping("/saveAdotanteDoador")
    public AdotanteDoador saveAdotanteDoador(@RequestBody AdotanteDoador adotanteDoador){
        return adotanteDoadorService.saveAdotanteDoador(adotanteDoador);
    }

    @PostMapping("/saveAllAdotanteDoador")
    public List<AdotanteDoador> saveAllAdotanteDoador(@RequestBody List<AdotanteDoador> adotanteDoadorList){
        return adotanteDoadorService.saveAllAdotanteDoador(adotanteDoadorList);
    }

    @GetMapping("/getAdotanteDoador")
    public List<AdotanteDoador> getAllAdotanteDoador(){
        return adotanteDoadorService.fetchAllAdotanteDoador();
    }


    @GetMapping("/todos")
    public List<AdotanteDoador> listaradotantedoador(){
        return adotantedoadorrepository.findAll();
    }
}
