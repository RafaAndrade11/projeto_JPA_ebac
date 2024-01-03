package br.com.randrade.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.randrade.domain.Marca;

public class MarcaDAO implements IMarcaDAO {

	@Override
	public Marca cadastrar(Marca marca) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ProjetoCarros");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();		
		entityManager.persist(marca);	
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		entityManagerFactory.close();
		
		return marca;
	}

	@Override
	public Marca excluir(Marca marca) {
		EntityManagerFactory entityManagerFactory = 
                Persistence.createEntityManagerFactory("ProjetoCarros");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        
        entityManager.createNativeQuery("DROP TABLE IF EXISTS Marca CASCADE").executeUpdate();
               
        entityManager.getTransaction().commit();

        entityManager.clear();
        entityManagerFactory.close();
        
		return marca;
	}
	

}
