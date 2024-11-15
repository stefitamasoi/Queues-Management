package org.example.businesslogic;

import org.example.view.View;

import javax.swing.*;
import java.io.IOException;

public class Controller {

    public Controller(View view) {

        view.getStartSimulare().addActionListener(e -> {
                SimulationManager sim = null;
                try {
                    sim = new SimulationManager(Integer.parseInt(view.getTimpDeSimulare()), Integer.parseInt(view.getTimpServireMaxim())
                            , Integer.parseInt(view.getTimpServireMinim()), Integer.parseInt(view.getTimpSosireMaxim()), Integer.parseInt(view.getTimpSosireMinim()),
                            Integer.parseInt(view.getNumarCozi()), Integer.parseInt(view.getNumarClienti()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                view.setVisible(false);
                Thread t = new Thread(sim);
                t.start();
        });
    }

}