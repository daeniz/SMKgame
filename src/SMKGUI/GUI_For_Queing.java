package Control;

import Engine.Engine;
import Engine.Question;
import SMKGUI.Smartphone;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;


public class GUI_For_Queing {

    private static Timer timer;
    private static int countIntro = 200;
    private static int countUser = 200;
    private static int countAnswer = 200;
    private static int countScore = 200;
    private static int countRanking = 200;
    private static int numberQ = 2;
    private static int countUp;
    private static boolean gameBool = true;
    private static Smartphone smartphone;
    private static ArrayList<Question> questions;
    private Engine engine = new Engine();

    public static void main(String[] args) {
        // Smartphone GUI
        countUp = 0;
        smartphone = new Smartphone();
        smartphone.setVisible(true);

        theTimer();

    }

    public static void theTimer() {

        ActionListener actListner = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                countUp++;
                System.out.println(countIntro);
                System.out.println(countUp);
                if (countUp <= countIntro) {
                    smartphone.jProgressBar1.setMaximum(countIntro);
                    smartphone.jProgressBar1.setValue(countIntro - countUp);

                } else if (countUp <= countUser + countIntro) {
                    smartphone.userPanel();
                    smartphone.jProgressBar2.setMaximum(countUser);
                    smartphone.jProgressBar2.setValue(countUser - (countUp - countIntro));

                } else if (countUp <= countUser + countIntro + countAnswer) {
                    smartphone.answerPanel();
                    smartphone.jProgressBar3.setMaximum(countUser);
                    smartphone.jProgressBar3.setValue(countUser - (countUp - countIntro - countAnswer));

                } else if (countUp <= countUser + countIntro + countAnswer*numberQ) {
                    smartphone.answerPanel();
                    smartphone.jProgressBar3.setMaximum(countUser);
                    smartphone.jProgressBar3.setValue(countUser - (countUp - countIntro - countAnswer*numberQ));

                } else if (countUp <= countUser + countIntro + countAnswer*numberQ+ countScore) {

                    smartphone.scorePanel();
                    smartphone.jProgressBar4.setMaximum(countUser);
                    smartphone.jProgressBar4.setValue(countUser - (countUp - countIntro - countAnswer*numberQ- countScore));

                } else if (countUp <= countUser + countIntro + countAnswer*numberQ+ countScore + countRanking) {
                    smartphone.rankingPanel();
                    smartphone.jProgressBar5.setMaximum(countUser);
                    smartphone.jProgressBar5.setValue(countUser - (countUp - countIntro - countAnswer*numberQ- countScore - countRanking));

                } else if (countUp > countUser + countIntro + countAnswer*numberQ+ countScore + countRanking) {
                    timer.stop();
                    try {
                        String[] args = {""};

                        GUI_For_Queing.main(args);
                    } catch (Exception ex) {
                    }
                }

            }

        };

        timer = new Timer(10, actListner);
        timer.start();
    }

}
