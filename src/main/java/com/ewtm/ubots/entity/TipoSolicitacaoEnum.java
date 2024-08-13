package com.ewtm.ubots.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoSolicitacaoEnum {

    CARTAO("Problemas com o cartao"),
    EMPRESTIMO("Contrataçao de empréstimo"),
    OUTROS("Demais assuntos");

    private String code;

}
