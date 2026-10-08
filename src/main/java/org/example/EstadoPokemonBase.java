package org.example;

public abstract class EstadoPokemonBase implements EstadoPokemon {
    @Override
    public final void receberDano(Pokemon pokemon, int pontos) {
        validarPontos(pontos);
        pokemon.alterarVida(-pontos);
        atualizarEstado(pokemon);
    }

    @Override
    public final void curar(Pokemon pokemon, int pontos) {
        validarPontos(pontos);
        pokemon.alterarVida(pontos);
        atualizarEstado(pokemon);
    }

    private void validarPontos(int pontos) {
        if (pontos < 0) {
            throw new IllegalArgumentException("A quantidade de pontos não pode ser negativa.");
        }
    }

    private void atualizarEstado(Pokemon pokemon) {
        int vida = pokemon.getVida();

        if (vida == Pokemon.VIDA_MAXIMA) {
            pokemon.mudarEstado(new VidaCompleta());
        } else if (vida >= 80) {
            pokemon.mudarEstado(new Saudavel());
        } else if (vida >= 30) {
            pokemon.mudarEstado(new Ferido());
        } else if (vida > 0) {
            pokemon.mudarEstado(new Critico());
        } else {
            pokemon.mudarEstado(new Desmaiado());
        }
    }
}
