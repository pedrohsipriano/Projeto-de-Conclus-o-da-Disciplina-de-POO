package Classes;
import java.util.List;
import java.util.Scanner;

public class UsuarioLivro {
    private Usuario usuario;
    private Livro livro;

    public UsuarioLivro(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    @Override
    public String toString() {
        return String.format(
                "{\n" +
                        "  \"usuario\": %s,\n" +
                        "  \"livro\": %s\n" +
                        "}",
                usuario.toString().replaceAll("(?m)^", "  "),
                livro.toString().replaceAll("(?m)^", "  ") 
        );
    }

    public static void emprestarLivro(List<Usuario> listaUsuarios, List<Livro> listaLivros,
            List<UsuarioLivro> listaUsuarioLivro) {
        System.out.print("\033[H\033[J");
        Scanner scanner = new Scanner(System.in);

        if (listaUsuarios.isEmpty() || listaLivros.isEmpty()) {
            System.out.println("Não há usuários ou livros cadastrados para realizar o empréstimo.");
            return;
        }

        int idxUsuario = -1;
        while (true) {
            System.out.println("==================================");
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
            System.out.println("==================================\n");
        }

        int idxLivro = -1;
        while (true) {
            System.out.println("==================================");
            System.out.println("Livros disponíveis:");
            for (int i = 0; i < listaLivros.size(); i++) {
                Livro livro = listaLivros.get(i);
                String status = livro.isEmprestimo() ? "Disponível" : "Emprestado";
                System.out.println(i + " - " + livro.getTitulo() + " [" + status + "]");
            }

            System.out.print("Escolha o número do livro: ");
            idxLivro = scanner.nextInt();

            if (idxLivro >= 0 && idxLivro < listaLivros.size()) {
                Livro livroSelecionado = listaLivros.get(idxLivro);
                if (livroSelecionado.isEmprestimo()) {
                    break;
                } else {
                    System.out.println("==================================");
                    System.out.println("Livro já está emprestado. Escolha outro livro.");
                    System.out.println("==================================\n");
                }
            } else {
                System.out.println("==================================");
                System.out.println("Número de livro inválido. Tente novamente.");
                System.out.println("==================================\n");
            }
            System.out.println("==================================");
        }

        Usuario usuarioSelecionado = listaUsuarios.get(idxUsuario);
        Livro livroSelecionado = listaLivros.get(idxLivro);
        livroSelecionado.setEmprestimo(false);

        UsuarioLivro novoEmprestimo = new UsuarioLivro(usuarioSelecionado, livroSelecionado);
        listaUsuarioLivro.add(novoEmprestimo);

        System.out.println("==================================");
        System.out.println("Livro emprestado com sucesso!");
        System.out.println("==================================\n");

        for (UsuarioLivro usuarioLivro : listaUsuarioLivro) {
            System.out.println(usuarioLivro);
        }
        System.out.println("==================================");
    }
}
