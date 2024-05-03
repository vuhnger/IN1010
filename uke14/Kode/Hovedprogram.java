import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Model {

    Char[] 

    Controller c;
    Model(Controller c){
        this.c = c;
    }

}

class View{

    JFrame frame;
    Controller c;
    View(Controller c){
        this.c = c;

        try{
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName()
            );
        }catch(Exception e){
            System.exit(1);
        }

        frame = new JFrame("Tic Tac Toe");

        JPanel panel = new JPanel();

        frame.add(panel);

        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}

class Controller{

    View v;
    Model m;
    Controller(){
        m = new Model(this);
        v = new View(this);
    }

}

class Hovedprogram{

    public static void main(String[] args){
        new Controller();
    }

}




