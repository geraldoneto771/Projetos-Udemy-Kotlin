package Ui;

import business.ContactBusiness;
import entity.ContactEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// JFrame é o que da comportamento a janela
public class MainForm extends JFrame{
    private JPanel rootPanel;
    private JButton buttonNewContact;
    private JButton buttonRemove;
    private JTable tableContacts;
    private JLabel labelContactCount;

    private ContactBusiness mContactBusiness;
    private String mName = "";
    private String mPhone = "";


    //construtor da classe
    public MainForm() {

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

        loadContacts();
    }

    private void loadContacts() {
        List<ContactEntity> contactList = mContactBusiness.getList();

        String[] columnNames = {"Nome", "Telefone"};
        //instanciando um objeto vazio
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        for (ContactEntity i : contactList) {
            // criando novas linhas
            Object[] o = new Object[2];

            o[0] = i.getName();
            o[1] = i.getPhone();

            model.addRow(o);
        }
        //tirando a seleção automática dos items
        tableContacts.clearSelection();
        tableContacts.setModel(model);

        labelContactCount.setText(mContactBusiness.getContactCountDescription());
    }

    // atribuição dos eventos
    private void setListeners() {
        //atribuindo a funcionalidade ao botão new contact,
        buttonNewContact.addActionListener(new ActionListener() {
            //atribuindo ação ao clicar no botão
            @Override
            public void actionPerformed(ActionEvent e) {
                //chamando o panel contactForm
                new ContactForm();
                //fechando o formulário anterior (painel inicial, que chamou o concactForm)
                dispose();
                //
            }
        });

        //selecionando a linha da tabela no panel
        tableContacts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {

                    if (tableContacts.getSelectedRow() != -1) {
                         mName = tableContacts.getValueAt(tableContacts.getSelectedRow(), 0).toString();
                         mPhone = tableContacts.getValueAt(tableContacts.getSelectedRow(), 1).toString();

                    }
                }
            }
        });

        //atribuindo a funcionalidade ao botão remove,
        buttonRemove.addActionListener(new ActionListener() {
            //atribuindo ação ao clicar no botão
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    mContactBusiness.delete(mName, mPhone);
                    loadContacts();

                    mName = "";
                    mPhone = "";
                }
                catch (Exception excp) {
                    JOptionPane.showMessageDialog(new JFrame(), excp.getMessage());
                }

            }
        });
    }

}
