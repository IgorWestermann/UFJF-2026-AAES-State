package org.example;

public class Pokemon {
    public static final int VIDA_MAXIMA = 100;

    private int vida;
    private EstadoPokemon estado;

    public Pokemon() {
        vida = VIDA_MAXIMA;
        estado = new VidaCompleta();
    }

    public int getVida() {
        return vida;
    }

    public String getDescricaoDoEstado() {
        return estado.descricao();
    }

    public int atacar() {
        return estado.forcaDoAtaque();
    }

    public void receberDano(int pontos) {
        estado.receberDano(this, pontos);
    }

    public void curar(int pontos) {
        estado.curar(this, pontos);
    }

    void alterarVida(int pontos) {
        vida = Math.max(0, Math.min(VIDA_MAXIMA, vida + pontos));
    }

    void mudarEstado(EstadoPokemon novoEstado) {
        estado = novoEstado;
    }
}
