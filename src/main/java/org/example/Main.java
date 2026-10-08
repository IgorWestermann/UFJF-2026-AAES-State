package org.example;

public class Main {
    public static void main(String[] args) {
        Pokemon pokemon = new Pokemon();

        exibir(pokemon);

        pokemon.receberDano(15);
        exibir(pokemon);

        pokemon.receberDano(45);
        exibir(pokemon);

        pokemon.receberDano(35);
        exibir(pokemon);

        pokemon.receberDano(20);
        exibir(pokemon);

        pokemon.curar(100);
        exibir(pokemon);
    }

    private static void exibir(Pokemon pokemon) {
        System.out.printf(
                "Vida: %d | Estado: %s | Ataque: %d%n",
                pokemon.getVida(),
                pokemon.getDescricaoDoEstado(),
                pokemon.atacar());
    }
}
