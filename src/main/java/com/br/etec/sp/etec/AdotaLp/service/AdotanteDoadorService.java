package com.br.etec.sp.etec.AdotaLp.service;

import com.br.etec.sp.etec.AdotaLp.model.AdotanteDoador;
import com.br.etec.sp.etec.AdotaLp.model.Animal;
import com.br.etec.sp.etec.AdotaLp.repository.AdotanteDoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdotanteDoadorService {
    @Autowired
    private AdotanteDoadorRepository adotanteDoadorRepository;

    public AdotanteDoador saveAdotanteDoador(AdotanteDoador adotanteDoador){
        return adotanteDoadorRepository.save(adotanteDoador);
    }

    public List<AdotanteDoador> saveAllAdotanteDoador(List<AdotanteDoador> adotanteDoadorList){
        return adotanteDoadorRepository.saveAll(adotanteDoadorList);
    }

    public List<AdotanteDoador> fetchAllAdotanteDoador(){
        return adotanteDoadorRepository.findAll();
    }

    public Optional<AdotanteDoador> fetchAdotanteDoadorById(int id){
        return adotanteDoadorRepository.findById(id);
    }

    public void deleteAdotanteDoadorById(int id){
        adotanteDoadorRepository.deleteById(id);
    }

    public AdotanteDoador updateAdotanteDoadorDetails(AdotanteDoador adotanteDoador){
        return adotanteDoadorRepository.save(adotanteDoador);
    }

}
