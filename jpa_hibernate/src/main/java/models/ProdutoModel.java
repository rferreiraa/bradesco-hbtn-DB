package models;

import entities.Produto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");

    public void create(Produto p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar o produto: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void update(Produto p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Produto atualizado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao atualizar o produto: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(Produto p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Produto prod = em.find(Produto.class, p.getId());
            if (prod != null) {
                em.remove(prod);
                System.out.println("Produto removido com sucesso!");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao deletar o produto: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Produto findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Produto produto = null;
        try {
            produto = em.find(Produto.class, id);
        } catch (Exception e) {
            System.err.println("Erro ao buscar produto: " + e.getMessage());
        } finally {
            em.close();
        }
        return produto;
    }

    public List<Produto> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Produto> produtos = new ArrayList<>();
        try {
            produtos = em.createQuery("FROM Produto", Produto.class).getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar produtos: " + e.getMessage());
        } finally {
            em.close();
        }
        return produtos;
    }
}
