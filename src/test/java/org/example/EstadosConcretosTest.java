package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EstadosConcretosTest {
    @Test
    void vidaCompletaPossuiDescricaoEForcaMaxima() {
        EstadoPokemon estado = new VidaCompleta();
        assertEquals("Vida completa", estado.descricao());
        assertEquals(30, estado.forcaDoAtaque());
    }

    @Test
    void saudavelPossuiDescricaoEForcaCorrespondentes() {
        EstadoPokemon estado = new Saudavel();
        assertEquals("Saudável", estado.descricao());
        assertEquals(25, estado.forcaDoAtaque());
    }

    @Test
    void feridoPossuiDescricaoEForcaCorrespondentes() {
        EstadoPokemon estado = new Ferido();
        assertEquals("Ferido", estado.descricao());
        assertEquals(15, estado.forcaDoAtaque());
    }

    @Test
    void criticoPossuiDescricaoEForcaCorrespondentes() {
        EstadoPokemon estado = new Critico();
        assertEquals("Crítico", estado.descricao());
        assertEquals(5, estado.forcaDoAtaque());
    }

    @Test
    void desmaiadoNaoConsegueAtacar() {
        EstadoPokemon estado = new Desmaiado();
        assertEquals("Desmaiado", estado.descricao());
        assertEquals(0, estado.forcaDoAtaque());
    }
}
