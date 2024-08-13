package com.ewtm.ubots.repository;

import com.ewtm.ubots.entity.Solicitacao;
import com.ewtm.ubots.entity.TimeAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeAtendimentoRepository extends JpaRepository<TimeAtendimento, Long> {

    TimeAtendimento findByNome(String nome);

}
