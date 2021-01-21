package br.com.alura.jpa.testes;

import javax.persistence.*;
import java.util.List;

public class TesteMediaDiariaDasMovimentacoes {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        String jpql = "select avg(m.valor), day(m.data), month(m.data) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

        Query query = em.createQuery(jpql);
        List<Object[]> mediaDasMovimentacoes = query.getResultList();

        for (Object[] resultado :
                mediaDasMovimentacoes) {
            System.out.println("A média das movimentações do dia " +
                    resultado[1] + "/" +
                    resultado[2] + " é: " +
                    resultado[0]);
        }
    }
}
