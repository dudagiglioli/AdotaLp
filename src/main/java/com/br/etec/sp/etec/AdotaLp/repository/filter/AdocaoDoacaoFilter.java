package com.br.etec.sp.etec.AdotaLp.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class AdocaoDoacaoFilter {

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dataadocao;

    public LocalDate getDataadocao() {
        return dataadocao;
    }

    public void setDataadocao(LocalDate dataadocao) {
        this.dataadocao = dataadocao;
    }


}
