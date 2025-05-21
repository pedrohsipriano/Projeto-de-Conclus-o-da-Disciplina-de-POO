package Ateste;

import javax.swing.*;
import java.awt.event.*;

public class UsuarioSwing extends JFrame {
    public UsuarioSwing() {
        setTitle("Cadastro de Usuário");
        setSize(350, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 25);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(120, 20, 180, 25);
        add(txtNome);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 60, 100, 25);
        add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(120, 60, 180, 25);
        add(txtEmail);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(120, 110, 100, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String email = txtEmail.getText();

                JOptionPane.showMessageDialog(null, "Usuário cadastrado:\nNome: " + nome + "\nEmail: " + email);
                dispose();
            }
        });

        setVisible(true);
    }
}
