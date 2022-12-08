import java.awt.*;
import javax.swing.*;

public class Inside extends JPanel {
    Fenetre fenetre;
    Joueur p;
    Joueur p1;
    Bloc j1;

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
        this.p1= new Joueur(50,50);
        this.j1= new Bloc(200,300);
        this.add(this.p1);
        this.add(this.p);
        this.add(this.j1);


        if(this.fenetre.isServer())
        {
            System.out.println("Server");
            Move m = new Move(this.p,this);
         //   Key k = new Key(this.p,this);
            this.addMouseMotionListener(m);
         //   this.addKeyListener(k);
        }
        else
        {
            System.out.println("Client");
            Thread th = new Thread( new Run(this));
            th.start();
        }

                    if(!this.fenetre.isServer())
            {
                System.out.println("Client");
                Move m1 = new Move(this.p1,this);
            //   Key k = new Key(this.p,this);
                this.addMouseMotionListener(m1);
            //   this.addKeyListener(k);
            }
            else
            {
                System.out.println("Server");
                Thread th1 = new Thread( new Run(this));
                th1.start();
            }
        this.setVisible(true);
    }    

    public void makapoint(){
        if(p.getXj() == j1.getXj() || p.getYj() == j1.getYj()){
            System.out.println("Naharesy " + p.getName());
        }
        if(p1.getXj() == j1.getXj() || p.getYj() == j1.getYj()){
            System.out.println("Naharesy " + p1.getName());
        }
    }
}
