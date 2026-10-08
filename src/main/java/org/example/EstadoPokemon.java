package org.example;

public interface EstadoPokemon {
    String descricao();

    int forcaDoAtaque();

    void receberDano(Pokemon pokemon, int pontos);

    void curar(Pokemon pokemon, int pontos);
}
