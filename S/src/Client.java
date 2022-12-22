import java.net.Socket;


public class Client 
{
    static Socket socketC;
    public Client(String IP, int port){
        connect(IP, port);
    }
    public void connect(String IP,int port){
        try {
            this.socketC = new Socket(IP,port);
            new Fenetre(this.socketC,false);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        new Client("localhost",5555);
    }
}