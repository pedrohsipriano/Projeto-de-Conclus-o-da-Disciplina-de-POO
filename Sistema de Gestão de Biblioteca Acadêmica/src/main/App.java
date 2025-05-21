package main;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Classes.Livro;
import Classes.Usuario;
import Classes.UsuarioLivro;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("\033[H\033[J");

        Scanner scanner = new Scanner(System.in);

        List<Livro> ListaLivros = new LinkedList<>();
        List<Usuario> ListaUsuarios = new LinkedList<>();
        List<UsuarioLivro> ListaUsuarioLivro = new LinkedList<>();

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


        int opcao = 0;

        while (opcao != 7) {
            System.out.println("==================================");
            System.out.println("Gestão de Biblioteca Acadêmica");
            System.out.println("==================================\n");

            System.out.println("==================================");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Emprestar Livro");
            System.out.println("4 - Devolver Livro");
            System.out.println("5 - Listar Livros");
            System.out.println("6 - Devolver Livro");
            System.out.println("7 - Sair");
            System.out.println("==================================");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
            System.out.println("==================================\n");

            switch (opcao) {
                case 1:
                    System.out.println("==================================");
                    System.out.println("1 - Cadastrar Usuario");
                    Usuario.adicionarUsuario(ListaUsuarios);
                    System.out.println("==================================\n");
                    break;
                case 2:
                    System.out.println("==================================");
                    System.out.println("2 - Cadastrar Livro");
                    Livro.adicionarLivro(ListaLivros);
                    System.out.println("==================================\n");
                    break;
                case 3:
                    System.out.println("==================================");
                    System.out.println("3 - Emprestar Livro");
                    UsuarioLivro.emprestarLivro(ListaUsuarios, ListaLivros, ListaUsuarioLivro);
                    System.out.println("==================================\n");
                    break;
                case 4:
                    System.out.println("==================================");
                    System.out.println("4 - Devolver Livro");
                    System.out.println("==================================\n");
                    break;
                case 5:
                    System.out.println("==================================");
                    System.out.println("5 - Listar Livros");
                    System.out.println("==================================\n");
                    break;
                case 6:
                    System.out.println("==================================");
                    System.out.println("6 - Consultar Disponibilidade do Livro");
                    System.out.println("==================================\n");
                    break;
                case 7:
                    System.out.println("==================================");
                    System.out.println("Obrigado por usar o programa!");
                    System.out.println("==================================\n");
                    break;
            
                default:
                    System.out.println("==================================");
                    System.out.println("Escolha uma opção valida!");
                    System.out.println("==================================\n");
                    break;
            }
            if (opcao == 7) {
                break;
            }
            
        }
        scanner.close();

    }
}
