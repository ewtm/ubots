package com.ewtm.ubots.service;

import com.ewtm.ubots.entity.Atendente;
import com.ewtm.ubots.entity.TimeAtendimento;
import com.ewtm.ubots.repository.AtendenteRepository;
import com.ewtm.ubots.repository.TimeAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBService {

    @Autowired
    private TimeAtendimentoRepository timeAtendimentoRepository;
    @Autowired
    private AtendenteRepository atendenteRepository;

    public void createDB(){
        TimeAtendimento timeAtendimentoCartao = TimeAtendimento
                .builder()
                .nome("Cartões")
                .capacidadeMaxima(3)
                .build();
        TimeAtendimento timeAtendimentoEmpre = TimeAtendimento
                .builder()
                .nome("Empréstimos")
                .capacidadeMaxima(3)
                .build();
        TimeAtendimento timeAtendimentoOutroAssunto = TimeAtendimento
                .builder()
                .nome("Outros Assuntos")
                .capacidadeMaxima(3)
                .build();
        List<TimeAtendimento> timeAtendimentoList = new ArrayList<>();
        timeAtendimentoList.add(timeAtendimentoCartao);
        timeAtendimentoList.add(timeAtendimentoEmpre);
        timeAtendimentoList.add(timeAtendimentoOutroAssunto);
        timeAtendimentoRepository.saveAll(timeAtendimentoList);

        Atendente atendente = Atendente
                .builder()
                .nome("Ubots")
                .atendimentosAtuais(0)
                .build();
        atendenteRepository.save(atendente);

    }

}
