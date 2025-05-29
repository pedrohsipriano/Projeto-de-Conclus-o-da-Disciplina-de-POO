package main;

// Importações necessárias
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Classes.Livro;
import Classes.Usuario;
import Classes.UsuarioLivro;

public class App {
    public static void main(String[] args) throws Exception {
        // Limpa o terminal (pode não funcionar em todos os terminais)
        System.out.print("\033[H\033[J");

        // Cria um objeto Scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Criação das listas principais para armazenar os dados
        List<Livro> ListaLivros = new LinkedList<>();
        List<Usuario> ListaUsuarios = new LinkedList<>();
        List<UsuarioLivro> ListaUsuarioLivro = new LinkedList<>();

        /*
        // Bloco opcional comentado que poderia ser usado para gerar dados de teste
        for (int i = 1; i <= 5; i++) {
            Usuario u = new Usuario();
            u.setNome("Usuario " + i);
            u.setCpf("000.000.000-0" + i);
            u.setEmail("usuario" + i + "@teste.com");
            u.setMatricula("202500" + i);
            u.setTipo(i % 2 == 0); 
            ListaUsuarios.add(u);

            Livro l = new Livro();
            l.setTitulo("Livro Teste " + i);
            l.setAutor("Autor " + i);
            l.setAnoDePublicacao("202" + i);
            l.setEditora("Editora " + i);
            l.setIsbn(10000 + i);
            l.setEmprestimo(true);
            ListaLivros.add(l);
        }
        */

        // Variável de controle do menu principal
        int opcao = 0;

        // Menu principal com opções de 1 a 7
        while (opcao != 7) {
            // Exibe o menu
            System.out.println("==================================");
            System.out.println("Gestão de Biblioteca Acadêmica");
            System.out.println("==================================\n");

            System.out.println("==================================");
            System.out.println("Escolha uma opção:\n");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Emprestar Livro");
            System.out.println("4 - Devolver Livro");
            System.out.println("5 - Listar Livros");
            System.out.println("6 - Consultar Disponibilidade do Livro");
            System.out.println("7 - Sair\n");
            System.out.println("==================================");

            // Lê a opção digitada pelo usuário
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
            System.out.println("==================================\n");

            // Executa a ação correspondente à opção escolhida
            switch (opcao) {
                case 1:
                    // Cadastra um novo usuário
                    System.out.println("==================================");
                    System.out.println("1 - Cadastrar Usuario");
                    Usuario.adicionarUsuario(ListaUsuarios);
                    System.out.println("==================================\n");
                    break;

                case 2:
                    // Cadastra um novo livro
                    System.out.println("==================================");
                    System.out.println("2 - Cadastrar Livro");
                    Livro.adicionarLivro(ListaLivros);
                    System.out.println("==================================\n");
                    break;

                case 3:
                    // Realiza o empréstimo de um livro
                    System.out.println("==================================");
                    System.out.println("3 - Emprestar Livro");
                    UsuarioLivro.emprestarLivro(ListaUsuarios, ListaLivros, ListaUsuarioLivro);
                    System.out.println("==================================\n");
                    break;

                case 4:
                    // Realiza a devolução de um livro
                    System.out.println("==================================");
                    System.out.println("4 - Devolver Livro");
                    UsuarioLivro.devolverLivro(ListaUsuarios, ListaLivros, ListaUsuarioLivro);
                    System.out.println("==================================\n");
                    break;

                case 5:
                    // Lista todos os livros cadastrados
                    System.out.println("==================================");
                    System.out.println("5 - Listar Livros");
                    Livro.listarLivros(ListaLivros);
                    System.out.println("==================================\n");
                    break;

                case 6:
                    // Consulta a disponibilidade de um livro
                    System.out.println("==================================");
                    System.out.println("6 - Consultar Disponibilidade do Livro");
                    Livro.buscarLivro(ListaLivros);
                    System.out.println("==================================\n");
                    break;

                case 7:
                    // Finaliza o programa
                    System.out.println("==================================");
                    System.out.println("Obrigado por usar o programa!");
                    System.out.println("==================================\n");
                    break;

                default:
                    // Trata entradas inválidas
                    System.out.println("==================================");
                    System.out.println("Escolha uma opção valida!");
                    System.out.println("==================================\n");
                    break;
            }
        }

        // Fecha o Scanner (boa prática para liberar recursos)
        scanner.close();
    }
}
