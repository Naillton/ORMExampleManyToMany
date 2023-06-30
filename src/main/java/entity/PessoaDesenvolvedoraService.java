package entity;

import jakarta.persistence.*;

import java.util.List;

public class PessoaDesenvolvedoraService {
  EntityManagerFactory emf =
          Persistence.createEntityManagerFactory("hibernate.ORMManyToMany");

  public void save(PessoaDesenvolvedora p) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(p);
    em.getTransaction().commit();
    em.close();
  }

  public void update(PessoaDesenvolvedora p) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(p);
    em.getTransaction().commit();
    em.close();
  }

  public void delete(PessoaDesenvolvedora p) {
    EntityManager em = emf.createEntityManager();
    // recuperando pessoa pelo id para conseguir deletala
    PessoaDesenvolvedora toBeDeleted = em.find(PessoaDesenvolvedora.class, p.getId());
    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();
    em.close();
  }

  /*public List<PessoaDesenvolvedora> listaUsandoEntity() {
    EntityManager em = emf.createEntityManager();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<PessoaDesenvolvedora> cq = cb.createQuery(PessoaDesenvolvedora.class);
    Root<PessoaDesenvolvedora> rootEntry = cq.from(PessoaDesenvolvedora.class);
    CriteriaQuery<PessoaDesenvolvedora> all = cq.select(rootEntry);
    TypedQuery<PessoaDesenvolvedora> allQuery = em.createQuery(all);
    return allQuery.getResultList();

  }*/


  public List<PessoaDesenvolvedora> listaUsandoHQL() {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("from PessoaDesenvolvedora");
    return query.getResultList();
  }


  public void updateUsandoHQL(Long id, String nome) {
    EntityManager em = emf.createEntityManager();
    // criando query para atualizar banco de dados
    Query query = em.createQuery("UPDATE PessoaDesenvolvedora set nome=:n WHERE id=:id");
    query.setParameter("n", nome);
    query.setParameter("id", id);
    em.getTransaction().begin();
    query.executeUpdate();
    em.getTransaction().commit();
  }
}
