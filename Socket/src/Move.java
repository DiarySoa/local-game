import java.awt.event.*;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Move implements MouseMotionListener{
    Joueur p;
    Inside in;
    public Move(Joueur p,Inside in){
        this.p=p;
        this.in=in;
    }
    public void mouseMoved(MouseEvent e){
        DataOutputStream dataOut = null;
        try {
            dataOut = new DataOutputStream(in.getFenetre().getSocket().getOutputStream());
        } catch (Exception E) {
            System.out.println(E);
        }
        int xPos = e.getX(); 
        int yPos = e.getY();
        p.setXM(xPos);
       p.setYM(xPos);
       p.setLocation(xPos, yPos);

       try {
        dataOut.writeUTF(xPos+","+yPos);
//        p.repaint();

       } catch (Exception e1) {
        System.out.println(e1);
       }

    }
    public void mouseDragged(MouseEvent e){
    }
}