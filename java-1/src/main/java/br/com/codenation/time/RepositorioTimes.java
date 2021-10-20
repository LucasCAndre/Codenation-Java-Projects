package br.com.codenation.time;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class RepositorioTimes {

    public List<Time> times = new ArrayList<>();

    public List<Long> timesIds = new ArrayList<>();

    public void incluirTime(Time time) {
        for (Time t: times) {
            if (t.getId() == time.getId()) {
                throw new IdentificadorUtilizadoException();
            }
        }
        this.times.add(time);
        this.timesIds.add(time.getId());
    }

    public List<Long> buscarTimes() {
        return timesIds;
    }

    public List<Time> getAllTimes() {
        return times;
    }

    public Long buscarCapitaoDoTime(Long idTime) {
        if (!timesIds.contains(idTime)) {
            throw new TimeNaoEncontradoException();
        }
        Long ans = null;
        for (Time t: times) {
            if (t.getId() == idTime) {
                ans = t.getCapitaoDoTime();
            }
        }
        if (ans == null) {
            throw new CapitaoNaoInformadoException();
        }
        return ans;
    }

    public String buscarNomeTime(Long idTime) {
        if (!timesIds.contains(idTime)) {
            throw new TimeNaoEncontradoException();
        }
        String nome = null;
        for (Time t: times) {
            if (t.getId() == idTime) {
                nome = t.getNome();
            }
        }
        return nome;
    }
}
