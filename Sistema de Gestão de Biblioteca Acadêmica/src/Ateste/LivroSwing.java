package Ateste;

import javax.swing.*;
import java.awt.event.*;

public class LivroSwing extends JFrame {
    public LivroSwing() {
        setTitle("Cadastro de Livro");
        setSize(350, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(20, 20, 100, 25);
        add(lblTitulo);

        JTextField txtTitulo = new JTextField();
        txtTitulo.setBounds(120, 20, 180, 25);
        add(txtTitulo);

        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setBounds(20, 60, 100, 25);
        add(lblAutor);

        JTextField txtAutor = new JTextField();
        txtAutor.setBounds(120, 60, 180, 25);
        add(txtAutor);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(120, 110, 100, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();

                JOptionPane.showMessageDialog(null, "Livro cadastrado:\nTítulo: " + titulo + "\nAutor: " + autor);
                dispose();
            }
        });

        setVisible(true);
    }
}
