package com.ewtm.ubots.service;

import com.ewtm.ubots.entity.Atendente;
import com.ewtm.ubots.entity.Solicitacao;
import com.ewtm.ubots.entity.TimeAtendimento;
import com.ewtm.ubots.entity.TipoSolicitacaoEnum;
import com.ewtm.ubots.repository.AtendenteRepository;
import com.ewtm.ubots.repository.SolicitacaoRepository;
import com.ewtm.ubots.repository.TimeAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
public class UbotsService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;
    @Autowired
    private TimeAtendimentoRepository timeAtendimentoRepository;
    @Autowired
    private AtendenteRepository atendenteRepository;

    private Queue<Solicitacao> filaSolicitacoes;

    public Solicitacao criarSolicitacao(Solicitacao solicitacao){
        TimeAtendimento atendimento = encontrarTime(solicitacao.getTipoSolicitacao());
        Atendente atendente = adicionarSolicitacao(atendimento, solicitacao);
        solicitacao.setAtendente(atendente);
        return solicitacaoRepository.save(solicitacao);
    }

    private TimeAtendimento encontrarTime(String tipoSolicitacao) {

        if (tipoSolicitacao.equals(TipoSolicitacaoEnum.CARTAO.getCode())) {
            return timeAtendimentoRepository.findByNome("Cartões");
        } else if (tipoSolicitacao.equals(TipoSolicitacaoEnum.EMPRESTIMO.getCode())) {
            return timeAtendimentoRepository.findByNome("Empréstimos");
        } else if (tipoSolicitacao.equals(TipoSolicitacaoEnum.OUTROS.getCode())) {
            return timeAtendimentoRepository.findByNome("Outros Assuntos");
        }
        return null;
    }


    public Atendente adicionarSolicitacao(TimeAtendimento time, Solicitacao solicitacao) {
        Atendente atendente = encontrarAtendenteDisponivel(time);
        if (atendente != null) {
            atendente.iniciarAtendimento();
            atendente.encerrarAtendimento();
        } else {
            filaSolicitacoes.add(solicitacao);
        }
        return atendente;
    }

    private Atendente encontrarAtendenteDisponivel(TimeAtendimento time) {
        List<Atendente> atendenteList = atendenteRepository.findAll();
        return atendenteList
                .stream()
                .filter( atendente -> atendente.getAtendimentosAtuais() < time.getCapacidadeMaxima())
                .findAny()
                .orElseThrow(() -> new RuntimeException("Não encontrado"));
    }

}
