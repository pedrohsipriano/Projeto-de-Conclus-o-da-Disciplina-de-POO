package Classes;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private long matricula;
    private boolean tipo;
    private String email;
    private long cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
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
            System.out.print("Nome: ");
            usuario.setNome(scanner.nextLine());

            try{
            System.out.print("CPF: ");
            usuario.setCpf(scanner.nextLong());
            scanner.nextLine();
            }catch(Exception e){
                System.out.println("CPF inválido. Digite apenas numeros.");
                scanner.nextLine();
                continue;
            }

            System.out.print("Email: ");
            usuario.setEmail(scanner.nextLine());
            String procurarPor = "@";
            if (usuario.getEmail().toLowerCase().contains(procurarPor.toLowerCase()) == false) {
                System.out.println("Email inválido. Digite um email válido.");
                continue;
            }

            try{System.out.print("Matricula: ");
            usuario.setMatricula(scanner.nextLong());
            scanner.nextLine();
            }catch(Exception e){
                System.out.println("Matricula inválida. Digite apenas numeros.");
                scanner.nextLine();
                continue;
            }
            

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
            }else{
                System.out.println("Opcao inválida.");
                continue;
            }

            ListaUsuarios.add(usuario);

            System.out.print("Deseja adicionar outro usuario? (s/n): ");
            opcao = scanner.nextLine();
            if (!opcao.equalsIgnoreCase("s")) {
                break;
            }
        }
        for (int i = 0; i < ListaUsuarios.size(); i++) {
            Usuario ul = ListaUsuarios.get(i);
            System.out.println(i + " - " + ul.getNome());
        }
    }
}
