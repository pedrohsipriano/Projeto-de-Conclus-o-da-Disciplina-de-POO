package Classes;

import java.util.List;
import java.util.Scanner;

// Classe que representa um Livro com seus atributos e métodos
public class Livro {
    // Atributos privados da classe Livro
    private String titulo;
    private String autor;
    private int isbn;
    private String editora;
    private int anoDePublicacao;
    private boolean emprestimo;

    // Métodos getters e setters para acessar e modificar os atributos

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public boolean isEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(boolean emprestimo) {
        this.emprestimo = emprestimo;
    }

    // Método que sobrescreve o toString para exibir as informações do livro em
    // formato JSON
    @Override
    public String toString() {
        return String.format(
                "{\n" +
                        "  \"titulo\": \"%s\",\n" +
                        "  \"autor\": \"%s\",\n" +
                        "  \"editora\": \"%s\",\n" +
                        "  \"anoDePublicacao\": \"%d\",\n" +
                        "  \"isbn\": \"%d\",\n" +
                        "  \"status\": \"%s\"\n" +
                        "}",
                titulo, autor, editora, anoDePublicacao, isbn, emprestimo ? "Disponivel" : "Emprestado");
    }

    // Método estático para adicionar livros à lista
    public static void adicionarLivro(List<Livro> ListaLivros) {
        System.out.print("\033[H\033[J"); // Limpa o terminal (ANSI escape code)
        Scanner scanner = new Scanner(System.in);

        String opcao = "s";
        // Loop para continuar cadastrando livros enquanto o usuário quiser
        while (!opcao.equalsIgnoreCase("n")) {
            Livro livro = new Livro();

            // Coleta de dados do livro
            System.out.print("Titulo: ");
            livro.setTitulo(scanner.nextLine());

            System.out.print("Autor: ");
            livro.setAutor(scanner.nextLine());

            try {
                System.out.print("Ano de publicação: ");
                livro.setAnoDePublicacao(scanner.nextInt());
                scanner.nextLine(); // <-- consome a quebra de linha
            } catch (Exception e) {
                System.out.println("Ano inválido. Digite apenas números.");
                scanner.nextLine(); // <-- consome a entrada inválida
                continue;
            }

            System.out.print("Editora: ");
            livro.setEditora(scanner.nextLine()); // Agora funciona corretamente

            try {
                System.out.print("ISBN: ");
                livro.setIsbn(scanner.nextInt());
                scanner.nextLine(); // <-- consome a quebra de linha
            } catch (Exception e) {
                System.out.println("ISBN inválido. Digite apenas números.");
                scanner.nextLine(); // <-- consome a entrada inválida
                continue;
            }

            // Seleção do status do livro
            System.out.println("Status:");
            System.out.println("1 - Disponivel");
            System.out.println("2 - Emprestado");
            System.out.print("Opcao: ");
            int opcaoEmprestimo = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer

            // Verifica e define o status de empréstimo
            if (opcaoEmprestimo == 1) {
                livro.setEmprestimo(true);
            } else if (opcaoEmprestimo == 2) {
                livro.setEmprestimo(false);
            } else {
                System.out.println("Opcao inválida.");
                continue;
            }

            // Adiciona o livro à lista
            ListaLivros.add(livro);

            // Pergunta se o usuário quer adicionar outro livro
            System.out.print("Deseja adicionar outro livro? (s/n): ");
            opcao = scanner.nextLine();

            // Se a resposta for diferente de "s", encerra o loop
            if (!opcao.equalsIgnoreCase("s")) {
                break;
            }
        }

        // Exibe os títulos dos livros cadastrados
        for (int i = 0; i < ListaLivros.size(); i++) {
            Livro ul = ListaLivros.get(i);
            System.out.println(i + " - " + ul.getTitulo());
        }
    }

    // Método para listar todos os livros cadastrados
    public static void listarLivros(List<Livro> ListaLivros) {
        System.out.print("\033[H\033[J"); // Limpa tela
        if (ListaLivros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        // Exibe informações detalhadas de cada livro
        for (Livro livro : ListaLivros) {
            System.out.println(livro);
        }
    }

    // Método para buscar livros pelo título (ou parte dele)
    public static void buscarLivro(List<Livro> listaLivros) {
        Scanner scanner = new Scanner(System.in);
        String termoBusca;

        if (listaLivros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        // Solicita termo de busca ao usuário
        System.out.print("Digite o título ou parte do título do livro: ");
        termoBusca = scanner.nextLine().toLowerCase();

        boolean livroEncontrado = false;
        System.out.println("Livros encontrados:");

        // Verifica se algum título contém o termo de busca
        for (Livro livro : listaLivros) {
            if (livro.getTitulo().toLowerCase().contains(termoBusca)) {
                String status = livro.isEmprestimo() ? "Disponível" : "Emprestado";
                System.out.println("- " + livro.getTitulo() + " | Status: " + status);
                livroEncontrado = true;
            }
        }

        // Se nenhum livro for encontrado
        if (!livroEncontrado) {
            System.out.println("Nenhum livro encontrado com esse termo.");
        }
    }
}
