package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.Cidade;
import com.br.etec.sp.etec.AdotaLp.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

    @Autowired
    private CidadeRepository cidaderepository;

    @GetMapping("/todos")
    public List<Cidade> listarcidade(){
        return  cidaderepository.findAll();
    }
}
