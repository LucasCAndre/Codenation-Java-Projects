package br.com.codenation;

import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.time.Time;
import br.com.codenation.jogador.Jogador;
import br.com.codenation.jogador.RepositorioJogadores;
import br.com.codenation.time.RepositorioTimes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	RepositorioTimes times = new RepositorioTimes();
	RepositorioJogadores jogadores = new RepositorioJogadores();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		times.incluirTime(time);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		for (Jogador j: jogadores.getAllJogadores()) {
			if (j.getId() == id) {
				throw new IdentificadorUtilizadoException();
			}
		}
		if (!times.buscarTimes().contains(idTime)) {
			throw new TimeNaoEncontradoException();
		}
		jogadores.incluirJogador(jogador);
	}

	public void definirCapitao(Long idJogador) {
		if (!jogadores.getJogadoresIds().contains(idJogador)) {
			throw new JogadorNaoEncontradoException();
		}
		for (Jogador jogador: jogadores.getAllJogadores()) {
			if (jogador.getId() == idJogador) {
				for (Time t: times.getAllTimes()) {
					if (t.getId() == jogador.getIdTime()) {
						t.setCapitaoDoTime(idJogador);
					}
				}
			}
		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		return times.buscarCapitaoDoTime(idTime);
	}

	public String buscarNomeJogador(Long idJogador) {
		return jogadores.buscarNomeJogador(idJogador);
	}

	public String buscarNomeTime(Long idTime) {
		return times.buscarNomeTime(idTime);
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if (!times.buscarTimes().contains(idTime)) {
			throw new TimeNaoEncontradoException();
		}
		List<Long> jogadoresDoTime = new ArrayList<>();
		for (Jogador j: jogadores.getAllJogadores()) {
			if (j.getIdTime() == idTime) {
				jogadoresDoTime.add(j.getId());
			}
		}
		return jogadoresDoTime;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if (!times.buscarTimes().contains(idTime)) {
			throw new TimeNaoEncontradoException();
		}
		List<Jogador> jogadoresDoTime = new ArrayList<>();
		for (Jogador j: jogadores.getAllJogadores()) {
			if (j.getIdTime() == idTime) {
				jogadoresDoTime.add(j);
			}
		}
		Integer habilidade = 0;
		Long melhorJogador = null;
		for (Jogador j: jogadoresDoTime) {
			if (j.getNivelHabilidade() > habilidade) {
				habilidade = j.getNivelHabilidade();
				melhorJogador = j.getId();
			}
		}
		return melhorJogador;
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if (!times.buscarTimes().contains(idTime)) {
			throw new TimeNaoEncontradoException();
		}
		List<Jogador> jogadoresDoTime = new ArrayList<>();
		for (Jogador j: jogadores.getAllJogadores()) {
			if (j.getIdTime() == idTime) {
				jogadoresDoTime.add(j);
			}
		}
		LocalDate dataNascimento = LocalDate.now();
		Long jogadorMaisVelho = null;
		for (Jogador j: jogadoresDoTime) {
			if (j.getDataNascimento().isBefore(dataNascimento)) {
				dataNascimento = j.getDataNascimento();
				jogadorMaisVelho = j.getId();
			}
		}
		return jogadorMaisVelho;
	}

	public List<Long> buscarTimes() {
		return times.buscarTimes();
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if (!times.buscarTimes().contains(idTime)) {
			throw new TimeNaoEncontradoException();
		}
		List<Jogador> jogadoresDoTime = new ArrayList<>();
		for (Jogador j: jogadores.getAllJogadores()) {
			if (j.getIdTime() == idTime) {
				jogadoresDoTime.add(j);
			}
		}
		BigDecimal maiorSalario = new BigDecimal(0);
		Long jogadorMaiorSalario = null;
		for (Jogador j: jogadoresDoTime) {
			if (j.getSalario().compareTo(maiorSalario) == 1) {
				maiorSalario = j.getSalario();
				jogadorMaiorSalario = j.getId();
			}
		}
		return jogadorMaiorSalario;
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		return jogadores.buscarSalarioDoJogador(idJogador);
	}

	public List<Long> buscarTopJogadores(Integer top) {
		return jogadores.buscarTopJogadores(top);
	}

}
