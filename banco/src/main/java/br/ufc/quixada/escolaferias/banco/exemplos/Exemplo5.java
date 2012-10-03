package br.ufc.quixada.escolaferias.banco.exemplos;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.quixada.escolaferias.banco.negocio.ContaComVariasColunas;

public class Exemplo5 {
    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        ContaComVariasColunas conta1 = new ContaComVariasColunas(1, "conta com muita informacao",
        		null, //data de criacao 
        		100000.00, "conta super hiper mega power vip");
        
        entityManager.getTransaction().begin();
        entityManager.persist(conta1);
        entityManager.getTransaction().commit();
        
        entityManager.getTransaction().begin();
        conta1.setDescricao("alterei a conta 1");
        conta1.setSaldo(500.00);
        entityManager.getTransaction().commit();
        
        entityManager.close();
    }

}
