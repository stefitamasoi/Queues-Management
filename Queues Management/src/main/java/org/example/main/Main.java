package org.example.main;

import org.example.businesslogic.Controller;
import org.example.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        new Controller(view);

    }
}