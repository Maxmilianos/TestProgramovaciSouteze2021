package uloha2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* Started:  14.03.2022 ~ 2:22
* End:      14.03.2022 ~ 2:50
*
*
* */
public class Uloha2 {

    /*
    1 = zelene svetlo - 5s
    2 = oranzove svetlo - 3s
    3 = cervene svetlo - 5s
    4 = cervene, oranzove svetlo - 1s
     */
    private static Semafor semafor;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Semafor");
        frame.add(semafor = new Semafor());
        frame.setSize(500, 500);
        frame.setResizable(false);;
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new Thread(() -> {
            while (true) {
                startGreen();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopGreen();
                startOrange();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopOrange();
                startRed();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startOrange();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopOrange();
                stopRed();
            }
        }).start();

    }

    private static void stopRed() {
        Semafor.red = false;
        semafor.repaint();
        System.out.println("Vypina se cervena");
    }

    private static void startRed() {
        Semafor.red = true;
        semafor.repaint();
        System.out.println("Zapina se cervena");
    }

    private static void stopOrange() {
        Semafor.orange = false;
        semafor.repaint();
        System.out.println("Vypina se oranzova");
    }

    private static void startOrange() {
        Semafor.orange = true;
        semafor.repaint();
        System.out.println("Zapina se oranzova");
    }

    private static void startGreen() {
        Semafor.green = true;
        semafor.repaint();
        System.out.println("Zapina se zelena");
    }

    private static void stopGreen() {
        Semafor.green = false;
        semafor.repaint();
        System.out.println("Vypina se zelena");
    }


    static class Semafor extends JPanel {

        private JPanel panel1;

        public static boolean red = false,
                orange = false,
                green = false;

        public Semafor() {
            setLayout(new BorderLayout());
            panel1 = new JPanel();
            add(panel1, BorderLayout.CENTER);
        }

        public void init() {
        }

        public void paint(Graphics g) {
            setBackground(Color.cyan);
            g.setColor(Color.black);
            g.fillRect(260, 50, 80, 160);

            if (red)
                g.setColor(new Color(255, 0, 0));
            else
                g.setColor(new Color(196, 162, 162));
            g.fillOval(280, 60, 40, 40);

            if (orange)
                g.setColor(new Color(255, 181, 0));
            else
                g.setColor(new Color(238, 238, 224));
            g.fillOval(280, 110, 40, 40);

            if (green == true)
                g.setColor(new Color(28, 255, 0));
            else
                g.setColor(new Color(160, 234, 150));
            g.fillOval(280, 160, 40, 40);
        }
    }
}
