package com.ewtm.ubots.config;

import com.ewtm.ubots.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public boolean instanciaDB() {
        this.dbService.createDB();
        return true;
    }


}
