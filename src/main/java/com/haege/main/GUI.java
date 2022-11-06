package com.haege.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame {

    public GUI() {
        super("Compare Zips of the Top40");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ButtonListener buttonListener = new ButtonListener();

        JPanel panel = new JPanel(new GridLayout(0,1));

        IdButton oldFile = new IdButton("Old Zip", 0);
        oldFile.addActionListener(buttonListener);
        panel.add(oldFile);

        IdButton newFile = new IdButton("New Zip", 1);
        newFile.addActionListener(buttonListener);
        panel.add(newFile);


        JButton compare = new JButton("Compare");
        panel.add(compare);

        JTextArea tf = new JTextArea(10,1);
        panel.add(tf);

        compare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Files files = Files.getInstance();
                try {
                    if(files.getNewFile() == null){

                        JOptionPane.showMessageDialog(null, "New File is null");
                        throw new RuntimeException("New File is null");
                    }
                    if(files.getOldfile() == null){
                        JOptionPane.showMessageDialog(null, "Old File is null");
                        throw new RuntimeException("Old File is null");
                    }

                    Compare.compare(files.getOldfile(), files.getNewFile());
                } catch (RuntimeException | IOException ex) {
                    System.out.println("Error during Comparing");
                    throw new RuntimeException(ex);
                }

                tf.setText(files.getDiffResult());

            }
        });


        add(panel);
        setLocation(30, 30);
        setSize(300, 350);
        setVisible(true);
    }
}