package challenge;

import java.util.ArrayList;
import java.util.List;

import java.lang.NullPointerException;
import java.lang.IllegalArgumentException;

public class Estacionamento {

    List<Carro> carrosEstacionados = new ArrayList<>();

    public void estacionar(Carro carro) {
        if (carro.getMotorista() == null) {
            throw new EstacionamentoException("Carro autonomo");
        }
        if (carro.getMotorista().getPontos() > 20 || carro.getMotorista().getIdade() < 18) {
          throw new EstacionamentoException("menor de idade ou carteira suspensa");
        }
        List<Integer> allAges = new ArrayList();
        carrosEstacionados.forEach(c -> {
          allAges.add(c.getMotorista().getIdade());
        });
        int minAge = 56;
        for (int idade: allAges) {
          if (idade < minAge) {
              minAge = idade;
          }
        }
        if (minAge > 55 && carrosEstacionados.size() == 10) {
          throw new EstacionamentoException("todos estacionados sao idosos");
        }
        if (carrosEstacionados.size() == 10) {
          for (int i = 0; i < 10; i++) {
              if (allAges.get(i) <= 55) {
                  carrosEstacionados.remove(i);
                  break;
              }
          }
        }
        carrosEstacionados.add(carro);
    }

    public int carrosEstacionados() {
        return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return true;
    }
}
