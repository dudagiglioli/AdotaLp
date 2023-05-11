package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.AdocaoDoacao;
import com.br.etec.sp.etec.AdotaLp.repository.AdocaoDoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adocaodoacao")
public class AdocaoDoacaoResource {

    @Autowired
    private AdocaoDoacaoRepository adocaodoacaorepository;

    @GetMapping("/todos")
    public List<AdocaoDoacao> listaradocaodoacao(){
        return adocaodoacaorepository.findAll();
    }
}
