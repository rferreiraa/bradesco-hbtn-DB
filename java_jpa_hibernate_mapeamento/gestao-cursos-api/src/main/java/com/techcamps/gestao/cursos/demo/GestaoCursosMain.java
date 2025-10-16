package com.techcamps.gestao.cursos.demo;

import com.techcamps.gestao.cursos.entities.*;
import com.techcamps.gestao.cursos.models.AlunoModel;
import com.techcamps.gestao.cursos.models.CursoModel;
import java.util.Date;

public class GestaoCursosMain {

    public static void main(String[] args) {

        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        // ---------------------------
        // Criar Professor
        Professor professor = new Professor();
        professor.setNomeCompleto("João Silva");
        professor.setMatricula("PROF123");
        professor.setEmail("joao.silva@email.com");

        // ---------------------------
        // Criar Aluno
        Aluno aluno = new Aluno();
        aluno.setNomeCompleto("Maria Souza");
        aluno.setMatricula("ALU456");
        aluno.setNascimento(new Date());
        aluno.setEmail("maria.souza@email.com");

        // Criar Telefone
        Telefone telefone = new Telefone();
        telefone.setDDD("11");
        telefone.setNumero("987654321");
        telefone.setAluno(aluno);
        aluno.getTelefones().add(telefone);

        // Criar Endereço
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Exemplo");
        endereco.setEndereco("123");
        endereco.setNumero("123");
        endereco.setBairro("Centro");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");
        endereco.setCep(12345678);
        endereco.setAluno(aluno);
        aluno.getEnderecos().add(endereco);

        // Salvar Aluno
        alunoModel.create(aluno);

        // ---------------------------
        // Criar Curso
        Curso curso = new Curso();
        curso.setNome("Java Avançado");
        curso.setSigla("JAVA");
        curso.setProfessor(professor);
        curso.getAlunos().add(aluno);
        cursoModel.create(curso);

        // ---------------------------
        // Criar Material do Curso
        MaterialCurso material = new MaterialCurso();
        material.setUrl("https://materialjava.com/apostila");
        material.setCurso(curso);

        System.out.println("Banco populado com sucesso com base no modelo de dados!");
    }
}
