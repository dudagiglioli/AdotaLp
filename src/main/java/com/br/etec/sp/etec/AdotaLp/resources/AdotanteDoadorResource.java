package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.AdotanteDoador;
import com.br.etec.sp.etec.AdotaLp.model.Animal;
import com.br.etec.sp.etec.AdotaLp.repository.AdotanteDoadorRepository;
import com.br.etec.sp.etec.AdotaLp.repository.filter.AdotanteDoadorFilter;
import com.br.etec.sp.etec.AdotaLp.repository.projections.AdotanteDoadorDTO;
import com.br.etec.sp.etec.AdotaLp.service.AdotanteDoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/adotantedoador")
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


    @GetMapping("/getAdotanteDoadorById/{id}")
    public Optional<AdotanteDoador> getAdotanteDoadorDtails(@PathVariable int id){
        return adotanteDoadorService.fetchAdotanteDoadorById(id);
    }

    @DeleteMapping("/deleteAdotanteDoadorById/{id}")
    public void deleteAdotanteDoadorById(@PathVariable int id){
        adotanteDoadorService.deleteAdotanteDoadorById(id);
    }

    @PutMapping("updateAdotanteDoador/{id}")
    public AdotanteDoador updateAdotanteDoadorDetails(@RequestBody AdotanteDoador adotanteDoador){
        return adotanteDoadorService.updateAdotanteDoadorDetails(adotanteDoador);
    }
}


