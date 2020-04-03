package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		//Pessoa p1 = new Pessoa(null, "Meridiane1", "gonkaschessoff1@gmail.com");
		//Pessoa p2 = new Pessoa(null, "Meridiane2", "gonkaschessoff2@gmail.com");
		//Pessoa p3 = new Pessoa(null, "Meridiane3", "gonkaschessoff3@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();//
		
		Pessoa p = em.find(Pessoa.class, 2);//find busca pessoa no banco de dados pelo id
		//System.out.println(p);
		
		em.getTransaction().begin();//inicia transação para gravar dados
		em.remove(p);//remove
		//em.persist(p1);//grava dados no banco
		//em.persist(p2);//grava dados no banco
		//em.persist(p3);//grava dados no banco
		em.getTransaction().commit();//fecha a transação
		
		System.out.println("Pronto");
		em.close();//fecha recurso
		emf.close();//fecha recurso

	}

}
