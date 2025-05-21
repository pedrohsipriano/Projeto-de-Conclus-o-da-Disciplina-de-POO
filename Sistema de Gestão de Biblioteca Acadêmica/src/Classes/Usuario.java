package Classes;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private String matricula;
    private boolean tipo;
    private String email;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return String.format(
                "{\n" +
                        "  \"nome\": \"%s\",\n" +
                        "  \"matricula\": \"%s\",\n" +
                        "  \"email\": \"%s\",\n" +
                        "  \"cpf\": \"%s\",\n" +
                        "  \"tipo\": \"%s\"\n" +
                        "}",
                nome, matricula, email, cpf, tipo ? "Aluno" : "Professor");
    }

    public static void adicionarUsuario(List<Usuario> ListaUsuarios) {
        System.out.print("\033[H\033[J");
        Scanner scanner = new Scanner(System.in);

        String opcao = "s";
        while (!opcao.equalsIgnoreCase("n")) {
            Usuario usuario = new Usuario();
            System.out.println("==================================");
            System.out.print("Nome: ");
            usuario.setNome(scanner.nextLine());

            System.out.print("CPF: ");
            usuario.setCpf(scanner.nextLine());

            System.out.print("Email: ");
            usuario.setEmail(scanner.nextLine());

            System.out.print("Matricula: ");
            usuario.setMatricula(scanner.nextLine());

            System.out.println("Tipo");
            System.out.println("1 - Aluno");
            System.out.println("2 - Professor");
            System.out.print("Opcao: ");

            int opcaoTipo = scanner.nextInt();
            scanner.nextLine();
            if (opcaoTipo == 1) {
                usuario.setTipo(true);
            } else if (opcaoTipo == 2) {
                usuario.setTipo(false);
            }

            ListaUsuarios.add(usuario);

            System.out.print("Deseja adicionar outro contato? (s/n): ");
            opcao = scanner.nextLine();
            System.out.println("==================================");
            if (!opcao.equalsIgnoreCase("s")) {
                break;
            }
        }
        for (Usuario usuario : ListaUsuarios) {
            System.out.println(usuario);
        }
    }
}
