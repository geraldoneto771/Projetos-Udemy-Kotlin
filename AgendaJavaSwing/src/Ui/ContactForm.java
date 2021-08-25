package Ui;

import business.ContactBusiness;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    private JPanel rootPanel;
    private JTextField textName;
    private JTextField textPhone;
    private JButton buttonCancel;
    private JButton buttonSave;

    private ContactBusiness mContactBusiness;
    //construtor da classe
    public ContactForm() {

        //chamando funções do JfRAME
        //chamando a o Painel rootPanel
        setContentPane(rootPanel);
        //definindo um tamanho para a tela
        setSize(500, 250);
        //definindo a visibilidade do painel como verdadeira
        setVisible(true);
        //pegando a dimensão da tela do monitor
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //posicionando Panel no centro do monitor
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        //Chamando a função que fecha o programa ao sair (apertar no x)
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mContactBusiness = new ContactBusiness();

        //chamando a função setListeners
        setListeners();

    }

    // atribuição dos eventos
    private void setListeners() {
        //atribuindo a funcionalidade ao botão save,
        buttonSave.addActionListener(new ActionListener() {
            //atribuindo ação ao clicar no botão
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String name = textName.getText();
                    String phone = textPhone.getText();

                    mContactBusiness.save(name, phone);

                    new MainForm();
                    dispose();

                } catch (Exception excep) {
                    JOptionPane.showMessageDialog(new JFrame(), excep.getMessage());
                }
            }
        });

        //atribuindo a funcionalidade ao botão Cancelar,
        buttonCancel.addActionListener(new ActionListener() {
            //atribuindo ação ao clicar no botão
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainForm();
                dispose();
            }
        });


    }
}