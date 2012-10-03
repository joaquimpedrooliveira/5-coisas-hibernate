package br.ufc.quixada.escolaferias.banco.exemplos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.quixada.escolaferias.banco.negocio.Cliente;
import br.ufc.quixada.escolaferias.banco.negocio.Conta;

public class Exemplo3 {
    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banco-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        Cliente cliente1 = new Cliente("Zé");
        Conta conta1 = new Conta(1, "primeira conta cliente zé");
        Conta conta2 = new Conta(2, "segunda conta cliente zé");
        
        cliente1.adicionaConta(conta1);
        cliente1.adicionaConta(conta2);
                
        entityManager.getTransaction().begin();
        entityManager.persist(cliente1);
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        Cliente clienteDoBD = entityManager.find(Cliente.class, 1);
        //normalmente é o que acontece numa aplicação web, pois a sessão é aberta a cada request
        entityManager.close();

        //Quando, na página, você percorre a coleção para mostrar a tela...
        for (Conta conta : clienteDoBD.getContas()) {
			System.out.println("Conta número:" + conta.getNumero() + ", descrição: " + conta.getDescricao());
		}
    }

}
