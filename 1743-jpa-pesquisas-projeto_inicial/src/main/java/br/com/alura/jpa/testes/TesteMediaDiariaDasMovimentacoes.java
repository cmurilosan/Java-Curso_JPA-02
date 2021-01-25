package br.com.alura.jpa.testes;

import br.com.alura.jpa.dao.ConnectionPersistence;
import br.com.alura.jpa.dao.MovimentacaoDao;
import br.com.alura.jpa.modelo.MediaComData;

import javax.persistence.EntityManager;
import java.util.List;

public class TesteMediaDiariaDasMovimentacoes {

    public static void main(String[] args) {

        EntityManager em = new ConnectionPersistence().getEntityManager();

        List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDao(em).getDiariaDasMovimentacoes();

        for (MediaComData resultado :
                mediaDasMovimentacoes) {
            System.out.println("A média das movimentações do dia " +
                    resultado.getDia() + "/" +
                    resultado.getMes() + " é: " +
                    resultado.getValor());
        }
    }
}
