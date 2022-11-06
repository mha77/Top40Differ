package com.haege.main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    Files files = Files.getInstance();

    public void actionPerformed(ActionEvent ev) {

        IdButton button = (IdButton) ev.getSource();
        String fileName = null;

        int id = button.getId();

        JFileChooser chooser = new JFileChooser();
        //panel.add(chooser);

        int rueckgabeWert = chooser.showOpenDialog(null);

        /* Abfrage, ob auf "Öffnen" geklickt wurde */
        if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
        {
            // Ausgabe der ausgewaehlten Datei
            System.out.println("Die zu öffnende Datei ist: " +
                    chooser.getSelectedFile().getName());
            fileName = chooser.getSelectedFile().getAbsolutePath();

        }

        if (id == 0) {
            files.setOldfile(fileName);

        }else if(id == 1){
            files.setNewFile(fileName);
        }
    }
}
