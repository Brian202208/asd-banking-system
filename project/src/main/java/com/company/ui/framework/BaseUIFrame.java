package com.company.ui.framework;

import com.company.framework.domain.AccountType;
import lombok.Getter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class BaseUIFrame extends JFrame {
    @Getter
    protected DefaultTableModel model;
    protected JTable table;
    protected JScrollPane scrollPane;
    protected Object[] rowData;
    protected boolean newAccount;

    public BaseUIFrame() {
        setTitle("Bank Application.");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setSize(575, 310);
        setVisible(false);

        JPanel panel = new JPanel(null);
        getContentPane().add(BorderLayout.CENTER, panel);
        panel.setBounds(0, 0, 575, 310);

        scrollPane = new JScrollPane();
        model = new DefaultTableModel();
        table = new JTable(model);
        addColumns(); // Customizable columns
        rowData = new Object[getColumnCount()];
        newAccount = false;

        panel.add(scrollPane);
        scrollPane.setBounds(12, 92, 444, 160);
        scrollPane.setViewportView(table);
        table.setBounds(0, 0, 420, 0);
    }

    protected abstract void addColumns();

    protected abstract int getColumnCount();

    protected void exitApplication() {
        try {
            setVisible(false);
            dispose();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void addWindowClosingListener() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                BaseUIFrame.this.windowClosing(event);
            }
        });
    }

    protected abstract void windowClosing(WindowEvent event);

    protected void addButtonListener(JButton button, ActionListener actionListener) {
        button.addActionListener(actionListener);
    }

    protected void addButtonToPanel(JPanel panel, JButton button, int x, int y, int width, int height) {
        panel.add(button);
        button.setBounds(x, y, width, height);
    }

    protected JPanel getPanel() {
        return (JPanel) getContentPane().getComponent(0);
    }

    protected void exitButtonAction(ActionEvent actionEvent) {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void createAccount(AccountType accountType) {}
}
