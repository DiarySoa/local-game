import java.awt.*;
import java.net.Socket;

import javax.swing.*;
public class Fenetre extends JFrame {
    Socket socket;
    boolean isServer ;


    public Socket getSocket(){
    return this.socket;
    }
    public void setSocket(Socket so){
        this.socket = so;
    }
    public boolean isServer(){
        return this.isServer;
    }
    public Fenetre(Socket socket,boolean status){
        this.isServer = status; 
        this.socket = socket;
        this.setSize(400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Inside map = new Inside(this);
        this.add(map);
        this.setVisible(true);
    }


}