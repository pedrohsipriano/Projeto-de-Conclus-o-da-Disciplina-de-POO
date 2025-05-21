package Ateste;

import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema da Biblioteca");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
        btnCadastrarUsuario.setBounds(100, 30, 200, 40);
        frame.add(btnCadastrarUsuario);

        JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
        btnCadastrarLivro.setBounds(100, 90, 200, 40);
        frame.add(btnCadastrarLivro);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(100, 150, 200, 40);
        frame.add(btnSair);

        // Ações dos botões
        btnCadastrarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new UsuarioSwing(); // Abre tela de cadastro de usuário
            }
        });

        btnCadastrarLivro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LivroSwing(); // Abre tela de cadastro de livro
            }
        });

        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
