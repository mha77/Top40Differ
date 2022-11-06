package com.haege.main;

import javax.swing.*;

public class IdButton extends JButton {
    private int id;

    public IdButton(String label, int id) {
        super(label);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}