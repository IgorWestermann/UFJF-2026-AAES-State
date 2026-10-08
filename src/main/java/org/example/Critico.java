package org.example;

public class Critico extends EstadoPokemonBase {
    @Override
    public String descricao() {
        return "Crítico";
    }

    @Override
    public int forcaDoAtaque() {
        return 5;
    }
}
