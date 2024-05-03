import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class Model {

    char[][] brett;
    Random r;

    Controller c;
    Model(Controller c){
        this.c = c;
        r = new Random();
        brett = new char[Controller.RADER][Controller.KOLONNER];
        for (int i = 0; i < Controller.RADER; i++){
            for (int j = 0; j < Controller.KOLONNER; j++){
                brett[i][j] = ' ';
            }
        }
    }

    char hentTegn(int r, int k){
        return brett[r][k];
    }

    boolean lovlig(int r, int k){
        return brett[r][k] == ' ';
    }

    void trekk(char s, int r, int k){
        if (lovlig(r, k)){ brett[r][k] = s;}
        if (harVunnet(s)) System.exit(1);
    }

    boolean harVunnet (char s) {
		return
	    // Sjekk radene
	    brett[0][0]==s && brett[0][1]==s && brett[0][2]==s ||
	    brett[1][0]==s && brett[1][1]==s && brett[1][2]==s ||
	    brett[2][0]==s && brett[2][1]==s && brett[2][2]==s ||
	    // Sjekk kolonnene
	    brett[0][0]==s && brett[1][0]==s && brett[2][0]==s ||
	    brett[0][1]==s && brett[1][1]==s && brett[2][1]==s ||
	    brett[0][2]==s && brett[1][2]==s && brett[2][2]==s ||
	    // Sjekk diagonalene
	    brett[0][0]==s && brett[1][1]==s && brett[2][2]==s ||
	    brett[0][2]==s && brett[1][1]==s && brett[2][0]==s;
    }


    void modellSpill(){
        int r, k;
        do{
            r = tilfeldig(0,2);
            k = tilfeldig(0,2);

            System.out.println(r + "," + k + " er " + hentTegn(r, k));
        }while(!lovlig(r,k));
        trekk('O', r, k);
    }

    private int tilfeldig (int a, int b) {
	    // Trekk et tilfeldig heltall x slik at a <= x <= b.
	    return (int)(Math.random()*(b-a+1)) + a;
    }

}

class View{

    JFrame frame;
    Controller c;
    
    JButton[][] knappene;
    View(Controller c){
        this.c = c;

        try{
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName()
            );
        }catch(Exception e){
            System.exit(1);
        }

        knappene = new JButton[Controller.RADER][Controller.KOLONNER];

        frame = new JFrame("Tic Tac Toe");

        JPanel panel = new JPanel();
        panel.setLayout(
            new GridLayout(Controller.RADER, Controller.KOLONNER)
        );

        for (int i = 0; i < Controller.RADER; i++){
            for (int j = 0; j < Controller.KOLONNER; j++){
                JButton b = new JButton();
                knappene[i][j] = b;
                b.addActionListener(
                    new KnappBehandler(i, j)
                );
                panel.add(b);
            }
        }

        frame.add(panel);

        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class KnappBehandler implements ActionListener{

        int r, k;
        KnappBehandler(int r, int k){
            this.r = r;
            this.k = k;
        }

        @Override
        public void actionPerformed(ActionEvent e){

            // Notere trekk
            c.trekk('X', r, k);

            //tegn
            tegnRutenett();

        }
    }

    void tegnRutenett(){
        for (int i = 0; i < Controller.RADER; i++){
            for (int j = 0; j < Controller.KOLONNER; j++){
                JButton b = knappene[i][j];
                b.setText(Character.toString(c.hentTegn(i,j)));
            }
        }
    }
    
}

class Controller{

    static final int RADER = 3, KOLONNER = 3;

    View v;
    Model m;
    Controller(){
        m = new Model(this);
        v = new View(this);
    }

    void trekk(char s, int r, int k){
        m.trekk(s, r, k);
    }

    boolean harVunnet(char s){
        return m.harVunnet(s);
    }

    char hentTegn(int r, int k){
        return m.hentTegn(r, k);
    }

    void modellTrekk(){
        m.modellSpill();
    }

}

class Hovedprogram{

    public static void main(String[] args){
        new Controller();
    }

}




