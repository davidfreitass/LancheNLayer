package br.com.lanche.controllers;

import br.com.lanche.applications.LancheApplication;
import br.com.lanche.facades.LancheFacade;
import br.com.lanche.interfaces.LancheRepository;
import br.com.lanche.models.Lanche;
import br.com.lanche.repositories.LancheRepositoryFirebase;
import br.com.lanche.repositories.LancheRepositoryImpl;
import br.com.lanche.services.LancheService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/api/lanches")
public class LancheController {

    private LancheRepository lancheRepositoryImpl;
    private LancheService lancheService;
    private LancheApplication lancheApplication;
    private LancheFacade lancheFacade;
    private Scanner scanner;

    public void injetarDependencias() {
        lancheRepositoryImpl = new LancheRepositoryImpl();
        lancheService = new LancheService();
        lancheApplication = new LancheApplication(lancheRepositoryImpl, lancheService);
        lancheFacade = new LancheFacade(lancheApplication);
        scanner = new Scanner(System.in);
    }

    public LancheController() throws IOException {
        injetarDependencias();

        Lanche lanche1 = new Lanche(1, "X-Burguer", 22, "C:\\Users\\aluno.fsa\\ImagensLanche\\x-burguer.jpg");
        Lanche lanche2 = new Lanche(2, "X-Hamburguer", 12, "C:\\Users\\aluno.fsa\\ImagensLanche\\x-burguer.jpg");
        Lanche lanche3 = new Lanche(3, "X-Bacon", 13, "C:\\Users\\aluno.fsa\\ImagensLanche\\x-burguer.jpg");

        this.lancheFacade.adicionar(lanche1);
        this.lancheFacade.adicionar(lanche2);
        this.lancheFacade.adicionar(lanche3);
    }

    @GetMapping("/")
    public List<Lanche> getLanches() throws IOException {
        return this.lancheFacade.buscarTodos();
    }

    @PostMapping("/produto/{idProduto}/quantidade/{quantidade}")
    public String vender(@PathVariable int idProduto,
                         @PathVariable int quantidade) throws IOException {
        Lanche lanche = this.lancheFacade.buscarPorId(idProduto);

        return String.valueOf(this.lancheFacade.calcularTotal(lanche, quantidade));
    }
}
