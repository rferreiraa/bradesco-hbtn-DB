package com.techcamps.gestao.cursos.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    private String matricula;
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    private String email;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private Set<Telefone> telefones = new HashSet<>();

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private Set<Endereco> enderecos = new HashSet<>();

    @ManyToMany(mappedBy = "alunos")
    private Set<Curso> cursos = new HashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public Date getNascimento() { return nascimento; }
    public void setNascimento(Date nascimento) { this.nascimento = nascimento; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Set<Telefone> getTelefones() { return telefones; }
    public void setTelefones(Set<Telefone> telefones) { this.telefones = telefones; }

    public Set<Endereco> getEnderecos() { return enderecos; }
    public void setEnderecos(Set<Endereco> enderecos) { this.enderecos = enderecos; }

    public Set<Curso> getCursos() { return cursos; }
    public void setCursos(Set<Curso> cursos) { this.cursos = cursos; }
}
