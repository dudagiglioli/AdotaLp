package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.AdocaoDoacao;
import com.br.etec.sp.etec.AdotaLp.service.AdocaoDoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adocaodoacao")
public class AdocaoDoacaoResource {

    @Autowired
    private AdocaoDoacaoService adocaoDoacaoService;


    @PostMapping("/saveAdocaoDoacao")
    public AdocaoDoacao saveAdocaoDoacao(@RequestBody AdocaoDoacao adocaoDoacao){
        return adocaoDoacaoService.saveAdocaoDoacao(adocaoDoacao);
    }

    @PostMapping("/saveAllAdocaoDoacao")
    public List<AdocaoDoacao> saveAllAdocaoDoacao(@RequestBody List<AdocaoDoacao> adocaoDoacaoList){
        return adocaoDoacaoService.saveAllAdocaoDoacao(adocaoDoacaoList);
    }

    @GetMapping("/getAdocaoDoacao")
    public List<AdocaoDoacao> getAllAdocaoDoacao(){
        return adocaoDoacaoService.fetchAllAdocaoDoacao();
    }


    @GetMapping("/fetchAllAdocaoDoacaoById/{id}")
    public Optional<AdocaoDoacao> getAdocaoDoacaoDtails(@PathVariable int id){
        return adocaoDoacaoService.fetchAllAdocaoDoacaoById(id);
    }

    @DeleteMapping("/deleteAdocaoDoacaoById/{id}")
    public void deleteAdocaoDoacaoById(@PathVariable int id){
        adocaoDoacaoService.deleteAdocaoDoacaoById(id);
    }

    @PutMapping("updateAdocaoDoacao/{id}")
    public AdocaoDoacao updateAdocaoDoacaoDetails(@RequestBody AdocaoDoacao adocaoDoacao){
        return adocaoDoacaoService.updateAdocaoDoacaoDetails(adocaoDoacao);
    }
}
