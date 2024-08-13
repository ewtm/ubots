package com.ewtm.ubots.repository;

import com.ewtm.ubots.entity.Atendente;
import com.ewtm.ubots.entity.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtendenteRepository extends JpaRepository<Atendente, Long> {


    List<Atendente> findByAtendimentosAtuais(int atendimentosAtuais);

}
