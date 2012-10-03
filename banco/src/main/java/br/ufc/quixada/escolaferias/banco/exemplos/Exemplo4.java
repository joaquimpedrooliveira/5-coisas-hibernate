package br.ufc.quixada.escolaferias.banco.exemplos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.quixada.escolaferias.banco.negocio.Cliente;
import br.ufc.quixada.escolaferias.banco.negocio.Conta;

public class Exemplo4 {
    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        Cliente clienteZe = new Cliente("Zé");
        Conta conta1 = new Conta(1, "primeira conta cliente zé");
        Conta conta2 = new Conta(2, "segunda conta cliente zé");
        
        clienteZe.adicionaConta(conta1);
        clienteZe.adicionaConta(conta2);
        
        Cliente clienteSa = new Cliente("Sá");
        Conta conta3 = new Conta(3, "conta 1 cliente sá");
        Conta conta4 = new Conta(4, "conta 2 cliente sá");
        clienteSa.adicionaConta(conta3);
        clienteSa.adicionaConta(conta4);
        
        entityManager.getTransaction().begin();
        entityManager.persist(clienteZe);
        entityManager.persist(clienteSa);
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        List<Conta> contas = entityManager.createQuery("from Conta", Conta.class).getResultList();
    	for (Conta c: contas) {
    		System.out.println("Dono da conta " + c.getNumero() + " é o " + c.getDono().getNome());
    	}
    	entityManager.close();

    }


	
}
