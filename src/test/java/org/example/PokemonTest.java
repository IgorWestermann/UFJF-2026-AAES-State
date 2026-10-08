package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokemonTest {
    private Pokemon pokemon;

    @BeforeEach
    void criarPokemonComVidaCompleta() {
        pokemon = new Pokemon();
    }

    @Test
    void iniciaComVidaCompleta() {
        assertEquals(100, pokemon.getVida());
        assertEquals("Vida completa", pokemon.getDescricaoDoEstado());
        assertEquals(30, pokemon.atacar());
    }

    @Test
    void mudaParaSaudavelAoReceberDanoLeve() {
        pokemon.receberDano(10);
        assertEquals(90, pokemon.getVida());
        assertEquals("Saudável", pokemon.getDescricaoDoEstado());
        assertEquals(25, pokemon.atacar());
    }

    @Test
    void mudaParaFeridoAoReceberDanoModerado() {
        pokemon.receberDano(50);
        assertEquals(50, pokemon.getVida());
        assertEquals("Ferido", pokemon.getDescricaoDoEstado());
        assertEquals(15, pokemon.atacar());
    }

    @Test
    void mudaParaCriticoAoReceberDanoGrave() {
        pokemon.receberDano(80);
        assertEquals(20, pokemon.getVida());
        assertEquals("Crítico", pokemon.getDescricaoDoEstado());
        assertEquals(5, pokemon.atacar());
    }

    @Test
    void mudaParaDesmaiadoQuandoAvidaChegaAZero() {
        pokemon.receberDano(100);
        assertEquals(0, pokemon.getVida());
        assertEquals("Desmaiado", pokemon.getDescricaoDoEstado());
        assertEquals(0, pokemon.atacar());
    }

    @Test
    void limitaAvidaMinimaEmZero() {
        pokemon.receberDano(150);
        assertEquals(0, pokemon.getVida());
        assertEquals("Desmaiado", pokemon.getDescricaoDoEstado());
    }

    @Test
    void limitaAvidaMaximaEmCem() {
        pokemon.receberDano(20);
        pokemon.curar(50);
        assertEquals(100, pokemon.getVida());
        assertEquals("Vida completa", pokemon.getDescricaoDoEstado());
    }

    @Test
    void voltaPorVariosEstadosAoSerCurado() {
        pokemon.receberDano(95);
        assertEquals("Crítico", pokemon.getDescricaoDoEstado());

        pokemon.curar(45);
        assertEquals("Ferido", pokemon.getDescricaoDoEstado());

        pokemon.curar(40);
        assertEquals("Saudável", pokemon.getDescricaoDoEstado());

        pokemon.curar(10);
        assertEquals("Vida completa", pokemon.getDescricaoDoEstado());
    }

    @Test
    void podeSerCuradoDepoisDeDesmaiar() {
        pokemon.receberDano(100);
        pokemon.curar(20);
        assertEquals(20, pokemon.getVida());
        assertEquals("Crítico", pokemon.getDescricaoDoEstado());
    }

    @Test
    void rejeitaQuantidadeNegativaDeDano() {
        assertThrows(IllegalArgumentException.class, () -> pokemon.receberDano(-1));
    }

    @Test
    void rejeitaQuantidadeNegativaDeCura() {
        assertThrows(IllegalArgumentException.class, () -> pokemon.curar(-1));
    }
}
