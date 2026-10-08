package org.example;

public class Saudavel extends EstadoPokemonBase {
    @Override
    public String descricao() {
        return "Saudável";
    }

    @Override
    public int forcaDoAtaque() {
        return 25;
    }
}
