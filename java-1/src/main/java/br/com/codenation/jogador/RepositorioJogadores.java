package br.com.codenation.jogador;

import br.com.codenation.exceptions.JogadorNaoEncontradoException;

import java.math.BigDecimal;
import java.util.*;

public class RepositorioJogadores {

    public List<Jogador> jogadores = new ArrayList<>();

    public List<Long> jogadoresIds = new ArrayList<>();

    public void incluirJogador(Jogador jogador) {
        this.jogadores.add(jogador);
        this.jogadoresIds.add(jogador.getId());
    }

    public List<Jogador> getAllJogadores() {
        return jogadores;
    }

    public List<Long> getJogadoresIds() {
        return jogadoresIds;
    }

    public String buscarNomeJogador(Long idJogador) {
        if (!jogadoresIds.contains(idJogador)) {
            throw new JogadorNaoEncontradoException();
        }
        String nome = null;
        for (Jogador jogador: jogadores) {
            if (jogador.getId() == idJogador) {
                nome = jogador.getNome();
            }
        }
        return nome;
    }

    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        if (!jogadoresIds.contains(idJogador)) {
            throw new JogadorNaoEncontradoException();
        }
        BigDecimal salarioDoJogador = new BigDecimal(0);
        for (Jogador j: jogadores) {
            if (j.getId() == idJogador) {
                salarioDoJogador = j.getSalario();
            }
        }
        return salarioDoJogador;
    }

    public List<Long> buscarTopJogadores(Integer top) {
        List<Long> topJogadores = new ArrayList<>();
        if (jogadores.isEmpty()) {
        }else{
            Collections.sort(jogadores, new Comparator<Jogador>() {
                @Override
                public int compare(Jogador o1, Jogador o2) {
                    return o2.getNivelHabilidade().compareTo(o1.getNivelHabilidade());
                }
            });
            for (Jogador j: jogadores) {
                if (topJogadores.size() < top) {
                    topJogadores.add(j.getId());
                }
            }
        }
        return topJogadores;
    }
}
