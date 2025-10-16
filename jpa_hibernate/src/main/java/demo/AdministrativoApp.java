package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.util.Date;
import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {

        ProdutoModel produtoModel = new ProdutoModel();
        PessoaModel pessoaModel = new PessoaModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);
        produtoModel.create(p1);

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("João");
        pessoa1.setEmail("joao@email.com");
        pessoa1.setIdade(30);
        pessoa1.setCpf("12345678901");
        pessoa1.setDataNascimento(new Date());
        pessoaModel.create(pessoa1);

        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos: " + produtos.size());

        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas: " + pessoas.size());

        p1.setPreco(350.0);
        produtoModel.update(p1);

        pessoa1.setIdade(31);
        pessoaModel.update(pessoa1);

        Produto prodBuscado = produtoModel.findById(p1.getId());
        System.out.println("Produto encontrado: " + prodBuscado.getNome() + " - R$ " + prodBuscado.getPreco());

        Pessoa pessoaBuscada = pessoaModel.findById(pessoa1.getId());
        System.out.println("Pessoa encontrada: " + pessoaBuscada.getNome() + " - Idade " + pessoaBuscada.getIdade());

        produtoModel.delete(p1);
        pessoaModel.delete(pessoa1);
    }
}
