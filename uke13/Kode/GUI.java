
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
    
    JFrame vindu;
    JPanel tegneflate;
    Knapp klikkeKnapp;
    int antallKlikk;
    GUI(){

        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName()
            );
        } catch (Exception e) {
            System.exit(1);
        }
        vindu = new JFrame();

        tegneflate = new JPanel();

        antallKlikk = 0;
        klikkeKnapp = new Knapp(Integer.toString(antallKlikk));

        vindu.add(tegneflate);
        tegneflate.add(klikkeKnapp);

        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindu.setLocationRelativeTo(null);
        vindu.setTitle("GUI Eksempel");
        vindu.pack();
        vindu.setVisible(true);
    }

    class Knapp extends JButton {


        Knapp(String tekst){
            super(tekst);
            super.addActionListener(new KnappBehandler());

        }

        class KnappBehandler implements ActionListener{


            @Override
            public void actionPerformed(ActionEvent e){ 
                antallKlikk++;
                oppdater();
            }
        }
    }

    void oppdater(){
        klikkeKnapp.setText(Integer.toString(antallKlikk));
    }

    public static void main(String[] args){
        new GUI();
    }
}
