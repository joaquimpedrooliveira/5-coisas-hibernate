package br.ufc.quixada.escolaferias.banco.exemplos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.quixada.escolaferias.banco.negocio.Conta;

public class Exemplo1e2 {
    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        Conta conta1 = new Conta(1, "primeira conta");
        Conta conta2 = new Conta(2, "segunda conta");
        
        entityManager.getTransaction().begin();
        entityManager.persist(conta1);
        entityManager.persist(conta2);
        entityManager.getTransaction().commit();
        
        entityManager.getTransaction().begin();
        //E se apagarmos uma conta antes?
        //entityManager.remove(conta2);
        conta1.setDescricao("alterei a conta 1");
        entityManager.getTransaction().commit();
        
        entityManager.close();
    }

}
