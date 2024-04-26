import javax.swing.*; import java.awt.*; import java.awt.event.*;
import java.util.Random;


public class Fargeendring {
    public static void main(String[] args) {
        Color[] farger = {Color.BLUE, Color.ORANGE, Color.YELLOW, Color.RED, Color.GREEN};
        Random tilfeldig = new Random();
        JFrame vindu = new JFrame("Endre farge paa JFrame med entertasten");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindu.setSize(500, 300);


        //Bruker addKeyListener og KeyAdapter-interfacet ved tastetrykk-hendelser
        vindu.addKeyListener(new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    vindu.getContentPane()
                        .setBackground(farger[tilfeldig.nextInt(farger.length)]);
                }
            }
        });
       
        vindu.setFocusable(true); //Anbefalt for aa la vinduet motta tastetrykk
        vindu.setLocationRelativeTo(null); 
        vindu.setVisible(true);
    }
}
