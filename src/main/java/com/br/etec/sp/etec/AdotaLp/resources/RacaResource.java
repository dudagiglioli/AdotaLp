package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.Raca;
import com.br.etec.sp.etec.AdotaLp.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/raca")
public class RacaResource {

    @Autowired
    private RacaRepository racarepository;

    @GetMapping("/todos")
    public List<Raca> listarraca(){
        return racarepository.findAll();
    }
}
