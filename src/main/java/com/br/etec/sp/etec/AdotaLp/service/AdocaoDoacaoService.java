package com.br.etec.sp.etec.AdotaLp.service;

import com.br.etec.sp.etec.AdotaLp.model.AdocaoDoacao;
import com.br.etec.sp.etec.AdotaLp.repository.AdocaoDoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdocaoDoacaoService {
    @Autowired
    private AdocaoDoacaoRepository adocaoDoacaoRepository;

    public AdocaoDoacao saveAdocaoDoacao(AdocaoDoacao adocaoDoacao){
        return adocaoDoacaoRepository.save(adocaoDoacao);
    }

    public List<AdocaoDoacao> saveAllAdocaoDoacao(List<AdocaoDoacao> adocaoDoacaoList){
        return  adocaoDoacaoRepository.saveAll(adocaoDoacaoList);
    }

    public List<AdocaoDoacao> fetchAllAdocaoDoacao(){
        return adocaoDoacaoRepository.findAll();
    }

    public Optional<AdocaoDoacao> fetchAllAdocaoDoacaoById(int id){
        return adocaoDoacaoRepository.findById(id);
    }

    public void deleteAdocaoDoacaoById(int id){
        adocaoDoacaoRepository.deleteById(id);
    }

   public AdocaoDoacao updateAdocaoDoacaoDetails(AdocaoDoacao adocaoDoacao){
        return adocaoDoacaoRepository.save(adocaoDoacao);
   }
}
