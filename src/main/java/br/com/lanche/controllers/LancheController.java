package br.com.lanche.controllers;

import br.com.lanche.facades.LancheFacade;
import br.com.lanche.models.Lanche;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/lanches")
public class LancheController {

    private final LancheFacade lancheFacade;

    public LancheController(LancheFacade lancheFacade) {
        this.lancheFacade = lancheFacade;
    }

    @GetMapping("/")
    public List<Lanche> getLanches() throws IOException {
        return lancheFacade.buscarTodos();
    }

    @GetMapping("/{id}")
    public Lanche getLanchePorId(@PathVariable int id) throws IOException {
        return lancheFacade.buscarPorId(id);
    }

    @PostMapping("/")
    public void adicionarLanche(@RequestBody Lanche lanche) throws IOException {
        lancheFacade.adicionar(lanche);
    }

    @PutMapping("/{id}")
    public void atualizarLanche(@PathVariable int id, @RequestBody Lanche lanche) throws IOException {
        lancheFacade.atualizar(id, lanche);
    }

    @DeleteMapping("/{id}")
    public void excluirLanche(@PathVariable int id) throws IOException {
        lancheFacade.excluir(id);
    }

    @PostMapping("/produto/{idProduto}/quantidade/{quantidade}")
    public String vender(@PathVariable int idProduto,
                         @PathVariable int quantidade) throws IOException {
        Lanche lanche = lancheFacade.buscarPorId(idProduto);
        return String.valueOf(lancheFacade.calcularTotal(lanche, quantidade));
    }
}
