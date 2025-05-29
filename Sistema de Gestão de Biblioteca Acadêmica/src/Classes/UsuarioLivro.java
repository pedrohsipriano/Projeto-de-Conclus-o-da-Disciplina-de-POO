package Classes;

import java.util.List;
import java.util.Scanner;

public class UsuarioLivro {
    // Atributos privados: referência ao usuário e ao livro emprestado
    private Usuario usuario;
    private Livro livro;

    // Construtor que recebe um usuário e um livro
    public UsuarioLivro(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    // Getter do usuário
    public Usuario getUsuario() {
        return usuario;
    }

    // Getter do livro
    public Livro getLivro() {
        return livro;
    }

    // Representação em formato de string (estilo JSON) com identação
    @Override
    public String toString() {
        return String.format(
                "{\n" +
                        "  \"usuario\": %s,\n" +
                        "  \"livro\": %s\n" +
                        "}",
                usuario.toString().replaceAll("(?m)^", "  "), // Indenta saída do usuário
                livro.toString().replaceAll("(?m)^", "  ")     // Indenta saída do livro
        );
    }

    // Método estático para realizar um empréstimo de livro
    public static void emprestarLivro(List<Usuario> listaUsuarios, List<Livro> listaLivros,
            List<UsuarioLivro> listaUsuarioLivro) {

        System.out.print("\033[H\033[J"); // Limpa o console
        Scanner scanner = new Scanner(System.in);

        // Verifica se há usuários ou livros cadastrados
        if (listaUsuarios.isEmpty() || listaLivros.isEmpty()) {
            System.out.println("Não há usuários ou livros cadastrados para realizar o empréstimo.");
            return;
        }

        // Seleciona o usuário
        int idxUsuario = -1;
        while (true) {
            System.out.println("Usuários disponíveis:");
            for (int i = 0; i < listaUsuarios.size(); i++) {
                System.out.println(i + " - " + listaUsuarios.get(i).getNome());
            }
            System.out.print("Escolha o número do usuário: ");
            idxUsuario = scanner.nextInt();

            if (idxUsuario >= 0 && idxUsuario < listaUsuarios.size()) {
                break;
            } else {
                System.out.println("Número de usuário inválido. Tente novamente.");
            }
        }

        // Seleciona o livro
        int idxLivro = -1;
        while (true) {
            System.out.println("Livros disponíveis:");
            for (int i = 0; i < listaLivros.size(); i++) {
                Livro livro = listaLivros.get(i);
                String status = livro.isEmprestimo() ? "Disponível" : "Emprestado";
                System.out.println(i + " - " + livro.getTitulo() + " [" + status + "]");
            }

            System.out.print("Escolha o número do livro: \n");
            idxLivro = scanner.nextInt();

            if (idxLivro >= 0 && idxLivro < listaLivros.size()) {
                Livro livroSelecionado = listaLivros.get(idxLivro);
                if (livroSelecionado.isEmprestimo()) { // Verifica se está disponível
                    break;
                } else {
                    System.out.println("Livro já está emprestado. Escolha outro livro.\n");
                }
            } else {
                System.out.println("Número de livro inválido. Tente novamente.\n");
            }
        }

        // Registra o empréstimo
        Usuario usuarioSelecionado = listaUsuarios.get(idxUsuario);
        Livro livroSelecionado = listaLivros.get(idxLivro);
        livroSelecionado.setEmprestimo(false); // Marca livro como emprestado

        UsuarioLivro novoEmprestimo = new UsuarioLivro(usuarioSelecionado, livroSelecionado);
        listaUsuarioLivro.add(novoEmprestimo); // Adiciona à lista de empréstimos

        System.out.println("Livro emprestado com sucesso!\n");

        // Lista todos os empréstimos atuais
        for (int i = 0; i < listaUsuarioLivro.size(); i++) {
            UsuarioLivro ul = listaUsuarioLivro.get(i);
            System.out.println(i + " - " + ul.getUsuario().getNome() + " | " + ul.getLivro().getTitulo());
        }
    }

    // Método estático para devolver um livro
    public static void devolverLivro(List<Usuario> listaUsuarios, List<Livro> listaLivros,
            List<UsuarioLivro> listaUsuarioLivro) {

        System.out.print("\033[H\033[J"); // Limpa o console
        Scanner scanner = new Scanner(System.in);

        // Verifica se há empréstimos registrados
        if (listaUsuarioLivro.isEmpty()) {
            System.out.println("Não há livros emprestados para devolver.\n");
            return;
        }

        // Seleciona qual empréstimo será devolvido
        int idxEmprestimo = -1;
        while (true) {
            System.out.println("Livros emprestados:\n");
            for (int i = 0; i < listaUsuarioLivro.size(); i++) {
                UsuarioLivro ul = listaUsuarioLivro.get(i);
                System.out.println(i + " - " + ul.getUsuario().getNome() + " | " + ul.getLivro().getTitulo());
            }

            System.out.print("Escolha o número do empréstimo a ser devolvido: ");
            idxEmprestimo = scanner.nextInt();

            if (idxEmprestimo >= 0 && idxEmprestimo < listaUsuarioLivro.size()) {
                break;
            } else {
                System.out.println("Número inválido. Tente novamente.\n");
            }
        }

        // Remove o empréstimo da lista e atualiza o status do livro
        UsuarioLivro devolucao = listaUsuarioLivro.remove(idxEmprestimo);
        devolucao.getLivro().setEmprestimo(true); // Marca livro como disponível

        System.out.println("Livro devolvido com sucesso!\n");
    }
}
