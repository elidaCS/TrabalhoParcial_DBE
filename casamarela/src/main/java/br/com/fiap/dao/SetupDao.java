package br.com.fiap.dao;
import br.com.fiap.model.Setup;
import br.com.fiap.util.JPAUtil;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class SetupDao {
	
	private EntityManager manager =JPAUtil.getEntityManager();

	public void save(Setup setup) {
		manager.getTransaction().begin();
		manager.persist(setup);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public List<Setup> getAll(){
		String jpql = "SELECT s FROM Setup";
		TypedQuery<Setup> query = manager.createQuery(jpql, Setup.class);
		List<Setup> resultList = query.getResultList();
		return resultList;
	}
}