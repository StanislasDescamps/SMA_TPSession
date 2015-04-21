import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class interfaceController implements Initializable {
    @FXML private Circle LIL_BOD_01, LIL_BOD_02, LIL_BOD_03, LIL_BOD_04, LIL_BOD_05, LIL_BOD_06, LIL_BOD_07,
            ORY_BOD_04, ORY_BOD_03, ORY_BOD_02, ORY_BOD_01,
            LIL_ORY_02, LIL_ORY_01,
            LIL_NCE_01, LIL_NCE_02, LIL_NCE_03, LIL_NCE_04, LIL_NCE_05, LIL_NCE_06, LIL_NCE_07,
            LIL_LYS_01, LIL_LYS_02, LIL_LYS_03, LIL_LYS_04, LIL_LYS_05,
            ORY_LYS_01, ORY_LYS_02, ORY_LYS_03,
            ORY_NCE_01, ORY_NCE_02, ORY_NCE_03, ORY_NCE_04, ORY_NCE_05,
            BOD_LYS_01, BOD_LYS_02, BOD_LYS_03, BOD_LYS_04, BOD_LYS_05, BOD_LYS_06, BOD_LYS_07,
            BOD_NCE_01, BOD_NCE_02, BOD_NCE_03, BOD_NCE_04, BOD_NCE_05,
            LYS_NCE_04, LYS_NCE_03, LYS_NCE_02, LYS_NCE_01;

    private Environnement env;
    private       boolean isRunning  = false;
    private final int     turnLength = 2;   // In seconds

    ArrayList<Circle> guiBalises;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        env = new Environnement();
        guiBalises = new ArrayList<>();
        initialiseTableauBalises();

        Thread logic = new Thread() {
            @Override
            public void run() {
                runSimulation();
            }
        };
        logic.start();
    }

    private void runSimulation() {
        long lastTime, currentTime;
        isRunning = true;

        while (isRunning) {
            lastTime = System.currentTimeMillis();
            // Logic //////////////////////////////////////////////////////////////

            env.run();
            rafraichirBalises();

            // Logic end //////////////////////////////////////////////////////////
            currentTime = System.currentTimeMillis();
            if (currentTime < lastTime + turnLength * 1000)
                try {
                    Thread.sleep(lastTime + turnLength * 1000 - currentTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    private void initialiseTableauBalises() {
        guiBalises.add(LIL_BOD_01);
        guiBalises.add(LIL_BOD_02);
        guiBalises.add(LIL_BOD_03);
        guiBalises.add(LIL_BOD_04);
        guiBalises.add(LIL_BOD_05);
        guiBalises.add(LIL_BOD_06);
        guiBalises.add(LIL_BOD_07);
        guiBalises.add(ORY_BOD_04);
        guiBalises.add(ORY_BOD_03);
        guiBalises.add(ORY_BOD_02);
        guiBalises.add(ORY_BOD_01);
        guiBalises.add(LIL_ORY_02);
        guiBalises.add(LIL_ORY_01);
        guiBalises.add(LIL_NCE_01);
        guiBalises.add(LIL_NCE_02);
        guiBalises.add(LIL_NCE_03);
        guiBalises.add(LIL_NCE_04);
        guiBalises.add(LIL_NCE_05);
        guiBalises.add(LIL_NCE_06);
        guiBalises.add(LIL_NCE_07);
        guiBalises.add(LIL_LYS_01);
        guiBalises.add(LIL_LYS_02);
        guiBalises.add(LIL_LYS_03);
        guiBalises.add(LIL_LYS_04);
        guiBalises.add(LIL_LYS_05);
        guiBalises.add(ORY_LYS_01);
        guiBalises.add(ORY_LYS_02);
        guiBalises.add(ORY_LYS_03);
        guiBalises.add(ORY_NCE_01);
        guiBalises.add(ORY_NCE_02);
        guiBalises.add(ORY_NCE_03);
        guiBalises.add(ORY_NCE_04);
        guiBalises.add(ORY_NCE_05);
        guiBalises.add(BOD_LYS_01);
        guiBalises.add(BOD_LYS_02);
        guiBalises.add(BOD_LYS_03);
        guiBalises.add(BOD_LYS_04);
        guiBalises.add(BOD_LYS_05);
        guiBalises.add(BOD_LYS_06);
        guiBalises.add(BOD_LYS_07);
        guiBalises.add(BOD_NCE_01);
        guiBalises.add(BOD_NCE_02);
        guiBalises.add(BOD_NCE_03);
        guiBalises.add(BOD_NCE_04);
        guiBalises.add(BOD_NCE_05);
        guiBalises.add(LYS_NCE_04);
        guiBalises.add(LYS_NCE_03);
        guiBalises.add(LYS_NCE_02);
        guiBalises.add(LYS_NCE_01);
    }

    private void rafraichirBalises() {
        for (Circle circle : guiBalises) {
            for (Balise balise : env.balises) {
                if (balise.getNom().replace('-', '_').equals(circle.getId())) {
                    switch (balise.getAlea()) {
                        case RAS:
                            circle.setStroke(Color.GOLD);
                            break;
                        case TURBULENCES:
                            circle.setStroke(Color.BLUE);
                            break;
                        case ORAGE:
                            circle.setStroke(Color.RED);
                            break;
                        case CRASH:
                            circle.setStroke(Color.PURPLE);
                            break;
                        case ATTERISSAGEFORCE:
                            circle.setStroke(Color.LIGHTGREY);
                            break;
                    }
                }
            }
        }
        for (Circle circle : guiBalises) {
            for (Avion avion : env.avions) {
                if (avion.getEtat() == Avion.Etat.NOMINAL &&
                    avion.getScenario().getBaliseActuelle().getNom().replace('-', '_').equals(circle.getId())) {
                    circle.setFill(Color.WHITE);
                    break;
                }
                else
                    circle.setFill(Color.BLACK);
            }
        }
    }
}
