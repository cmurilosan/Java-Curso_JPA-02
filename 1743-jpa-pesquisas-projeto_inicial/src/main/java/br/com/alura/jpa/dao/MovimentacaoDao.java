package br.com.alura.jpa.dao;

import br.com.alura.jpa.modelo.MediaComData;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MovimentacaoDao {

    private EntityManager em;

    public MovimentacaoDao(EntityManager em) {
        this.em = em;
    }

    public List<MediaComData> getDiariaDasMovimentacoes() {

        String jpql = "select new br.com.alura.jpa.modelo.MediaComData " +
                "(avg(m.valor), day(m.data), month(m.data)) " +
                "from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

        TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);

        return query.getResultList();
    }

    public Double getSomaDasMovimentacoes() {

        String jpql = "select avg(m.valor) from Movimentacao m";

        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        Double somaDasMovimentacoes = query.getSingleResult();

        return somaDasMovimentacoes;
    }
}
