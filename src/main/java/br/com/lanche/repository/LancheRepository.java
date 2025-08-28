package br.com.lanche.repository;

import br.com.lanche.models.Lanche;

import java.util.ArrayList;
import java.util.List;

public class LancheRepository {
    private List<Lanche> lanches = new ArrayList<>();

    public void adicionar(Lanche lanche) {
        this.lanches.add(lanche);
    }

    public List<Lanche> buscarTodos() {
        return this.lanches;
    }

    public Lanche buscarPorId(int id) {
        return this.lanches.stream().filter(l -> l.getId() == id).findFirst().get();
    }

    public void excluir (int id) {
        this.lanches.removeIf(l -> l.getId() == id);
    }
}
