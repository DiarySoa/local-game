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
    

    public Joueur getP1() {
		return p1;
	}

	public void setP1(Joueur p1) {
		this.p1 = p1;
	}

	public Inside(Fenetre fenetre){
        this.fenetre = fenetre;
        this.setSize(100,100);
//        this.setBounds(100, 100, 500, 500);
//        this.setLayout(new FlowLayout());

        this.p = new Joueur(50, 50);
        this.p1= new Joueur(0,0);
        p.setBackground(Color.yellow);
        this.j1= new Bloc(300,220);
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
//               Key k = new Key(this.p,this);
                this.addMouseMotionListener(m1);
//               this.addKeyListener(k);
            }
            else
            {
                System.out.println("Server");
                Thread th1 = new Thread( new Run2(this));
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