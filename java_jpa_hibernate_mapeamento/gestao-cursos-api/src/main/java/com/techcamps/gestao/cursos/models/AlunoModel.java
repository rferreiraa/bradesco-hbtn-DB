package com.techcamps.gestao.cursos.models;

import com.techcamps.gestao.cursos.entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AlunoModel {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao criar aluno: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Aluno findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Aluno aluno = null;
        try {
            aluno = em.find(Aluno.class, id);
        } finally {
            em.close();
        }
        return aluno;
    }

    public List<Aluno> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Aluno> alunos = null;
        try {
            alunos = em.createQuery("FROM Aluno", Aluno.class).getResultList();
        } finally {
            em.close();
        }
        return alunos;
    }

    public void update(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno atualizado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar aluno: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void delete(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Aluno a = em.find(Aluno.class, aluno.getId());
            if (a != null) {
                em.remove(a);
                System.out.println("Aluno removido com sucesso!");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro ao remover aluno: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
