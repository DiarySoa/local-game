import javax.swing.*;
import java.awt.*;

public class Bloc extends JPanel {
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

    public Bloc(int x,int y){
        this.xj = x;
        this.yj = y;
        this.setBackground(Color.gray);
        this.setBounds(x, y, 50, 100);
        this.setVisible(true);
    }
    public void paint(Graphics g){
        Color Dark_blue = new Color(0,0,200);
        g.setColor(Dark_blue);
        g.fillRect(0,0, 20, 30);
    //   g.fillOval(0,0,20,30);
  
    }


    


}
