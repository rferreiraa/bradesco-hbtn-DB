package model;

import entities.Pessoa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");

    public void create(Pessoa p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar pessoa: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void update(Pessoa p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Pessoa atualizada com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao atualizar pessoa: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(Pessoa p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Pessoa pessoa = em.find(Pessoa.class, p.getId());
            if (pessoa != null) {
                em.remove(pessoa);
                System.out.println("Pessoa removida com sucesso!");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao deletar pessoa: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Pessoa findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Pessoa pessoa = null;
        try {
            pessoa = em.find(Pessoa.class, id);
        } catch (Exception e) {
            System.err.println("Erro ao buscar pessoa: " + e.getMessage());
        } finally {
            em.close();
        }
        return pessoa;
    }

    public List<Pessoa> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            pessoas = em.createQuery("FROM Pessoa", Pessoa.class).getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar pessoas: " + e.getMessage());
        } finally {
            em.close();
        }
        return pessoas;
    }
}
