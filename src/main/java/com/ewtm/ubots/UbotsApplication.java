package com.ewtm.ubots;

import com.ewtm.ubots.entity.TimeAtendimento;
import com.ewtm.ubots.repository.TimeAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UbotsApplication {


    public static void main(String[] args) {
        SpringApplication.run(UbotsApplication.class, args);
    }

}
