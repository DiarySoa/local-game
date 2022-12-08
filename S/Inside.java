import java.awt.*;
import java.util.Vector;

import javax.swing.*;

public class Inside extends JPanel {
    Fenetre fenetre;
    Joueur p;
    Vector<Joueur>other = new Vector<Joueur>();

    public Joueur getP() {
        return p;
    }

    public void setP(Joueur p) {
        this.p = p;
    }

    public Fenetre getFenetre() {
        return fenetre;
    }

    public void setFenetre(Fenetre fenetre) {
        this.fenetre = fenetre;
    }

    public Inside(Fenetre fenetre){
        this.fenetre = fenetre;
        this.setSize(100,100);
        this.p = new Joueur(0, 0);
        this.add(this.p);
    //    addPlayer(p);
        if(this.fenetre.isServer())
        {
            System.out.println("Server");
            Move m = new Move(this.p,this);
            this.addMouseMotionListener(m);
        }
        else
        {
            System.out.println("Client");
            Thread th = new Thread( new Run(this));
            th.start();
        }
        this.setVisible(true);
    }   
    
    public void addPlayer(Joueur plr){
        System.out.println("other added");
        this.other.add(plr);
        this.add(plr);
        System.out.println("player added");
        Graphics2D g2 = (Graphics2D) this.getGraphics();
        g2.setColor(Color.RED);
        plr.paint(g2);;
        g2.dispose();
    }
}
