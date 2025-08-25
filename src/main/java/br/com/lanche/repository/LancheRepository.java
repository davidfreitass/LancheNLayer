package br.com.lanche.repository;

import java.util.ArrayList;
import java.util.List;

public class LancheRepository {
    private List<Lanche> lanches = new ArrayList<>();

    public void adicionar(Lanche lanche) {
        this.lanches.add(lanche);
    }

    public List<lanche> buscarTodos() {
        return this.lanches;
    }

    public Lanche buscarPorId(int id) {
        return this.lanches.stream().filter(Lanche l -> l.getId() == id).findFirst().get();
    }

    public void excluir (int id) {
        this.lanches.removeIf(Lanche l -> l.getId() == id);
    }
}
