import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static Socket socket;
    public Server(int port){
        connect(port);
    }
    public void connect(int port){
        
        
        try {
            ServerSocket SocketS = new ServerSocket(port);
            this.socket = SocketS.accept();
            new Fenetre(this.socket,true);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Server(5555);
    }
    
}