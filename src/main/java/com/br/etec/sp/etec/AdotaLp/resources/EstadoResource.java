package com.br.etec.sp.etec.AdotaLp.resources;

import com.br.etec.sp.etec.AdotaLp.model.Estado;
import com.br.etec.sp.etec.AdotaLp.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoResource {

    @Autowired
    private EstadoRepository estadoreposiroty;

    @GetMapping("/todos")
    public List<Estado> listarestado(){
        return  estadoreposiroty.findAll();
    }
}
