package br.com.alura.jpa.dao;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MovimentacaoDao {

    private EntityManager em;

    public MovimentacaoDao(EntityManager em) {
        this.em = em;
    }

    public List<Movimentacao> getMovimentacoesFiltradasPorData (Integer dia, Integer mes, Integer ano) {
        String jpql = "select m from Movimentacao m ";

        if (dia != null) {
            jpql = jpql + " day(m.data) = :pDia";
        }
        if (mes != null) {
            jpql = jpql + " and month(m.data) = :pMes";
        }
        if (ano != null) {
            jpql = jpql + " and year(m.data) = :pAno";
        }

        return null;
    }

    public List<MediaComData> getDiariaDasMovimentacoes() {

        TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);

        return query.getResultList();
    }

    public Double getSomaDasMovimentacoes() {

        String jpql = "select avg(m.valor) from Movimentacao m";

        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        Double somaDasMovimentacoes = query.getSingleResult();

        return somaDasMovimentacoes;
    }
}
