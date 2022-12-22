import java.awt.*;
import javax.swing.*;

public class Inside extends JPanel {
    Fenetre fenetre;
    Joueur p;
    Joueur p1;
    Bloc j1;
    Bloc [] j2 = new Bloc[10];

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
        this.setBackground(Color.green);
//        this.setSize(900,900);
        this.setVisible(true);
        this.setLayout(null);
        this.setBounds(0, 0, 900, 1600);
//        this.setLayout(new FlowLayout());

        this.p = new Joueur(900, 900);
        p.setSize(20,30);
        this.p1= new Joueur(0,0);
        p1.setSize(20,30);
        p.setBackground(Color.yellow);
        this.j1= new Bloc(300,220);
        j1.setSize(20,30);
        this.add(this.p1);
        this.add(this.p);
        this.add(this.j1);
        
      for (int j = 0; j < j2.length; j++) {
   
          j2[0]= new Bloc(100,100);
          j2[1]= new Bloc(200,200);
          j2[2]= new Bloc(500,300);
          j2[3]= new Bloc(800,700);
          j2[4]= new Bloc(800,800);
          j2[5]= new Bloc(700,400);
          j2[6]= new Bloc(500,80);
          j2[7]= new Bloc(300,750);
          j2[8]= new Bloc(50,100);
          j2[9]= new Bloc(400,300);
     	  j2[j].setSize(50,50);
          this.add(j2[j]);
	}  
      



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

    public int makapoint1(){
    	int point = 0;
    	for (int i = 0; i < j2.length; i++) {
            if(p.getXj() == j2[i].getXj() || p.getYj() == j2[i].getYj()){
            	point = p1.getScore()+1;
                System.out.println("Point de P1 = " + point);
            }
        
    	}
		return point;
    }
    public int makapoint2(){
    	int point = 0;
    	for (int i = 0; i < j2.length; i++) {
            if(p1.getXj() == j2[i].getXj() || p1.getYj() == j2[i].getYj()){
            	point = p.getScore()+1;
                System.out.println("Point de P = " + point);
            }
        
    	}
		return point;
    }
}
//////////////////////////////////////////////////////
