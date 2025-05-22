package Classes;

import java.util.List;
import java.util.Scanner;

public class Livro {
    private String titulo;
    private String autor;
    private int isbn;
    private String editora;
    private String anoDePublicacao;
    private boolean emprestimo;

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

    public String getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(String anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public boolean isEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(boolean emprestimo) {
        this.emprestimo = emprestimo;
    }

    @Override
    public String toString() {
        return String.format(
                "{\n" +
                        "  \"titulo\": \"%s\",\n" +
                        "  \"autor\": \"%s\",\n" +
                        "  \"editora\": \"%s\",\n" +
                        "  \"anoDePublicacao\": \"%s\",\n" +
                        "  \"isbn\": \"%d\",\n" +
                        "  \"status\": \"%s\"\n" +
                        "}",
                titulo, autor, editora, anoDePublicacao, isbn, emprestimo ? "Disponivel" : "Emprestado");
    }

    public static void adicionarLivro(List<Livro> ListaLivros) {
        System.out.print("\033[H\033[J");
        Scanner scanner = new Scanner(System.in);

        String opcao = "s";
        while (!opcao.equalsIgnoreCase("n")) {
            Livro livro = new Livro();
            System.out.println("==================================");
            System.out.print("Titulo: ");
            livro.setTitulo(scanner.nextLine());

            System.out.print("Autor: ");
            livro.setAutor(scanner.nextLine());

            try{
            System.out.print("Ano de publicação: ");
            livro.setAnoDePublicacao(scanner.nextLine());
            }catch (Exception e) {
                System.out.println("Ano inválido. Digite apenas numeros.");
                continue;
            }

            System.out.print("Editora: ");
            livro.setEditora(scanner.nextLine());

            try{
            System.out.print("ISBN: ");
            livro.setIsbn(scanner.nextInt());
            scanner.nextLine();
            }catch (Exception e) {
                System.out.println("ISBN inválido. Digite apenas numeros.");
                continue;
            }
            

            System.out.println("Status:");
            System.out.println("1 - Disponivel");
            System.out.println("2 - Emprestado");
            System.out.print("Opcao: ");
            int opcaoEmprestimo = scanner.nextInt();

            scanner.nextLine();
            if (opcaoEmprestimo == 1) {
                livro.setEmprestimo(true);
            } else if (opcaoEmprestimo == 2) {
                livro.setEmprestimo(false);
            }else{
                System.out.println("Opcao inválida.");
                continue;
            }

            ListaLivros.add(livro);

            System.out.print("Deseja adicionar outro livro? (s/n): ");
            opcao = scanner.nextLine();
            System.out.println("==================================");
            if (!opcao.equalsIgnoreCase("s")) {
                break;
            }
        }
        for (int i = 0; i < ListaLivros.size(); i++) {
            Livro ul = ListaLivros.get(i);
            System.out.println(i + " - " + ul.getTitulo());
        }
    }

    public static void listarLivros(List<Livro> ListaLivros) {
        System.out.print("\033[H\033[J");
        if (ListaLivros.isEmpty()) {
            System.out.println("==================================");
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for (Livro livro : ListaLivros) {
            System.out.println(livro);
        }
    }

    public static void buscarLivro(List<Livro> listaLivros) {
        Scanner scanner = new Scanner(System.in);
        String termoBusca;

        if (listaLivros.isEmpty()) {
            System.out.println("==================================");
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        System.out.print("Digite o título ou parte do título do livro: ");
        termoBusca = scanner.nextLine().toLowerCase();

        boolean livroEncontrado = false;
        System.out.println("==================================");
        System.out.println("Livros encontrados:");

        for (Livro livro : listaLivros) {
            if (livro.getTitulo().toLowerCase().contains(termoBusca)) {
                String status = livro.isEmprestimo() ? "Disponível" : "Emprestado";
                System.out.println("- " + livro.getTitulo() + " | Status: " + status);
                livroEncontrado = true;
            }
        }
        if (!livroEncontrado) {
            System.out.println("Nenhum livro encontrado com esse termo.");
        }

        System.out.println("==================================");
    }
}
