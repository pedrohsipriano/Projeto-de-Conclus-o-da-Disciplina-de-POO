// Declaração do pacote onde a classe está localizada
package Classes;

// Importações necessárias para utilizar listas e entrada de dados
import java.util.List;
import java.util.Scanner;

// Definição da classe Usuario
public class Usuario {
    // Atributos privados da classe
    private String nome;
    private long matricula;
    private boolean tipo; // true = aluno, false = professor
    private String email;
    private long cpf;

    // Métodos getter e setter para cada atributo
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

    // Método toString que formata a saída dos dados do usuário
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

    // Método estático para adicionar usuários a uma lista
    public static void adicionarUsuario(List<Usuario> ListaUsuarios) {
        // Limpa a tela (funciona em alguns terminais)
        System.out.print("\033[H\033[J");
        Scanner scanner = new Scanner(System.in);

        String opcao = "s"; // Controle de repetição
        while (!opcao.equalsIgnoreCase("n")) {
            Usuario usuario = new Usuario(); // Cria novo usuário

            // Solicita nome
            System.out.print("Nome: ");
            usuario.setNome(scanner.nextLine());

            // Solicita CPF com tratamento de exceção
            try {
                System.out.print("CPF: ");
                usuario.setCpf(scanner.nextLong());
                scanner.nextLine(); // Limpa o buffer
            } catch (Exception e) {
                System.out.println("CPF inválido. Digite apenas números.");
                scanner.nextLine(); // Limpa entrada inválida
                continue; // Volta ao início do loop
            }

            // Solicita email e faz validação simples
            System.out.print("Email: ");
            usuario.setEmail(scanner.nextLine());
            String procurarPor = "@";
            if (usuario.getEmail().toLowerCase().contains(procurarPor.toLowerCase()) == false) {
                System.out.println("Email inválido. Digite um email válido.");
                continue;
            }

            // Solicita matrícula com tratamento de exceção
            try {
                System.out.print("Matricula: ");
                usuario.setMatricula(scanner.nextLong());
                scanner.nextLine(); // Limpa o buffer
            } catch (Exception e) {
                System.out.println("Matrícula inválida. Digite apenas números.");
                scanner.nextLine(); // Limpa entrada inválida
                continue;
            }

            // Solicita tipo de usuário: aluno ou professor
            System.out.println("Tipo");
            System.out.println("1 - Aluno");
            System.out.println("2 - Professor");
            System.out.print("Opcao: ");
            int opcaoTipo = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            // Define tipo com base na escolha
            if (opcaoTipo == 1) {
                usuario.setTipo(true); // Aluno
            } else if (opcaoTipo == 2) {
                usuario.setTipo(false); // Professor
            } else {
                System.out.println("Opção inválida.");
                continue;
            }

            // Adiciona o usuário à lista
            ListaUsuarios.add(usuario);

            // Pergunta se deseja continuar cadastrando
            System.out.print("Deseja adicionar outro usuário? (s/n): ");
            opcao = scanner.nextLine();
            if (!opcao.equalsIgnoreCase("s")) {
                break; // Sai do loop se a resposta for "n"
            }
        }

        // Mostra os usuários cadastrados
        for (int i = 0; i < ListaUsuarios.size(); i++) {
            Usuario ul = ListaUsuarios.get(i);
            System.out.println(i + " - " + ul.getNome());
        }
    }
}
