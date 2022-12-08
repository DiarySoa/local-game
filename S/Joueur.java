import javax.swing.*;
import java.awt.*;

public class Joueur extends JPanel {
    int xj;
    int yj;
    int xM;
    int yM;

    public int getXj() {
        return xj;
    }

    public void setXj(int x) {
        this.xj = x;
    }

    public int getYj() {
        return yj;
    }

    public void setYj(int y) {
        this.yj = y;
    }
    public int getXM() {
        return xM;
    }
    public void setXM(int mx) {
        this.xM = mx;
    }
    public int getYM() {
        return yM;
    }
    public void setYM(int my) {
        this.yM = my;
    }

    public Joueur(int x,int y){
        this.xj = x;
        this.yj = y;
        this.setBackground(Color.gray);
        this.setBounds(x, y, 50, 100);
        this.setVisible(true);
    }
    public void paint(Graphics g){
        Color red = new Color(204,0,0);
        g.setColor(red);
      g.fillRect(0,0, 20, 30);
    //  g.fillOval(0,0,100,100);
  
    }


    


}
