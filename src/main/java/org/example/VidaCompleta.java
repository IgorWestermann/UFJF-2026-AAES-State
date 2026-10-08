package org.example;

public class VidaCompleta extends EstadoPokemonBase {
    @Override
    public String descricao() {
        return "Vida completa";
    }

    @Override
    public int forcaDoAtaque() {
        return 30;
    }
}
