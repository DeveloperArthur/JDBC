package br.com.crud.dao;

import br.com.crud.model.Cliente;
import br.com.crud.model.Dao;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Dao exemploDao = new Dao();
        DaoCliente exemploDaoCliente = new DaoCliente();
        //DaoCliente  = new DaoCliente();
        Cliente exemploCliente = new Cliente();
        Cliente DarValores = new Cliente();

        exemploCliente.setNome("r");
        exemploCliente.setCep("0482450");
        exemploCliente.setCidade("sao paulo");
        exemploCliente.setCpf("491503849/00");
        exemploCliente.setEndereco("grajau");
        exemploCliente.setEstado("sao paulo");
        exemploCliente.setGenero("macho");
        exemploCliente.setId(47);
        exemploCliente.setIdade(19);
        exemploCliente.setTelefone("966402850");

        DarValores.setCep("04824100");
        DarValores.setCidade("qualquer");
        DarValores.setCpf("123");
        DarValores.setEndereco("nada");
        DarValores.setEstado("ta");
        DarValores.setGenero("blz");
        DarValores.setId(3);
        DarValores.setIdade(20);
        DarValores.setNome("Menor");
        DarValores.setTelefone("15161");

        DaoCliente passarValores = new DaoCliente();

        //nome,cpf, genero,telefone,idade,endereco,cidade,estado,cep
        exemploDaoCliente.cadastrarCliente(exemploCliente);

        exemploDaoCliente.buscarCliente(2);

        exemploDaoCliente.cadastrarCliente(exemploCliente);
        exemploDaoCliente.cadastrarCliente(DarValores);
        exemploDaoCliente.excluirCliente(2);
        

        exemploDaoCliente.atualizarCliente(exemploCliente);

        Cliente x = new Cliente();
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        x = exemploDaoCliente.buscarCliente(i);
        System.out.println(x.getNome());

    }

}
