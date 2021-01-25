package br.com.alura.jpa.testes;

import br.com.alura.jpa.dao.ConnectionPersistence;
import br.com.alura.jpa.dao.MovimentacaoDao;
import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

public class TestaSomaDasMovimentacoes {

    public static void main(String[] args) {

        EntityManager em = new ConnectionPersistence().getEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);

        Root<Movimentacao> root = query.from(Movimentacao.class);

        Expression<BigDecimal> sum = builder.sum(root.get("valor"));
        query.select(sum);

        TypedQuery<BigDecimal> typedQuery = em.createQuery(query);

        System.out.println("A soma das movimentações é: " + typedQuery.getSingleResult());
    }

}
