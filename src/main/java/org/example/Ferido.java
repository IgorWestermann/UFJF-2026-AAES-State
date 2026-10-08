package org.example;

public class Ferido extends EstadoPokemonBase {
    @Override
    public String descricao() {
        return "Ferido";
    }

    @Override
    public int forcaDoAtaque() {
        return 15;
    }
}
