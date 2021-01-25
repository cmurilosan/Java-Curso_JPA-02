package br.com.alura.jpa.testes;

import br.com.alura.jpa.dao.ConnectionPersistence;
import br.com.alura.jpa.dao.MovimentacaoDao;
import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.EntityManager;
import java.util.List;

public class TestaMovimentacoesFiltradasPorDataCriteria {

    public static void main(String[] args) {

        EntityManager em = new ConnectionPersistence().getEntityManager();

        MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);
        List<Movimentacao> movimentacoesFiltradasPorData = movimentacaoDao
                .getMovimentacoesFiltradasPorData(null, null, null);
        for (Movimentacao movimentacao :
                movimentacoesFiltradasPorData) {
            System.out.println("Descricao -> " + movimentacao.getDescricao());
            System.out.println("Valor -> " + movimentacao.getValor());
            System.out.println("-----------------------------------------");
        }
    }
}
