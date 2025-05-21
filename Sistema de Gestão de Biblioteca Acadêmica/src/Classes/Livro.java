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

            System.out.print("Ano de publicação: ");
            livro.setAnoDePublicacao(scanner.nextLine());

            System.out.print("Editora: ");
            livro.setEditora(scanner.nextLine());

            System.out.print("ISBN: ");
            livro.setIsbn(scanner.nextInt());
            scanner.nextLine();

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
            }

            ListaLivros.add(livro);

            System.out.print("Deseja adicionar outro contato? (s/n): ");
            opcao = scanner.nextLine();
            System.out.println("==================================");
            if (!opcao.equalsIgnoreCase("s")) {
                break;
            }
        }
        for (Livro livro : ListaLivros) {
            System.out.println(livro);
        }
    }

}
