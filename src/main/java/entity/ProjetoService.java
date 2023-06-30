package entity;

import jakarta.persistence.*;

public class ProjetoService {
  EntityManagerFactory emf =
          Persistence.createEntityManagerFactory("hibernate.ORMManyToMany");

  public void save(Projeto p) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(p);
    em.getTransaction().commit();
    em.close();
  }

  public void update(Projeto p) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(p);
    em.getTransaction().commit();
    em.close();
  }
}
