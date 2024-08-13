package com.ewtm.ubots.controller;

import com.ewtm.ubots.entity.Solicitacao;
import com.ewtm.ubots.service.UbotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ubots")
public class UbotsController {

    @Autowired
    private UbotsService ubotsService ;

    @PostMapping
    public Solicitacao criarSolicitacao(@RequestBody Solicitacao solicitacao) {
        return ubotsService.criarSolicitacao(solicitacao);
    }


}
