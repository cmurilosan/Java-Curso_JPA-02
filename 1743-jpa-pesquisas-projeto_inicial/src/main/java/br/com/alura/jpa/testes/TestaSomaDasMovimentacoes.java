package br.com.alura.jpa.testes;

import br.com.alura.jpa.dao.ConnectionPersistence;
import br.com.alura.jpa.dao.MovimentacaoDao;

import javax.persistence.EntityManager;

public class TestaSomaDasMovimentacoes {

    public static void main(String[] args) {

        EntityManager em = new ConnectionPersistence().getEntityManager();

        MovimentacaoDao dao = new MovimentacaoDao(em);

        System.out.println("A soma das movimentações é: " + dao.getSomaDasMovimentacoes());
    }

}
