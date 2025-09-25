package br.com.lanche;

import br.com.lanche.applications.LancheApplication;
import br.com.lanche.facades.LancheFacade;
import br.com.lanche.interfaces.LancheRepository;
import br.com.lanche.models.Lanche;
import br.com.lanche.repositories.LancheRepositoryFirebase;
import br.com.lanche.services.LancheService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class MainSpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(MainSpringBoot.class, args);
    }
}
