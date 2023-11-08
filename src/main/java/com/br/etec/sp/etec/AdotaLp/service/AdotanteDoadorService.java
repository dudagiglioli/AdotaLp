package com.br.etec.sp.etec.AdotaLp.service;

import com.br.etec.sp.etec.AdotaLp.repository.AdotanteDoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdotanteDoadorService {
    @Autowired
    private AdotanteDoadorRepository adotanteDoadorRepository;

}
