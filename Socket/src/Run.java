import java.io.DataInputStream;

public class Run implements Runnable{

    Inside in ;
    public Run(Inside in)
    {
        this.in = in ;
    }
    @Override
    public void run() {
        DataInputStream dataIn = null;
        try {
            dataIn = new DataInputStream(in.getFenetre().getSocket().getInputStream());
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        while(true){
            try {
                
                String pos = dataIn.readUTF();
                String[] position = pos.split(",");
                int Xpos = Integer.valueOf(position[0]);
                int Ypos = Integer.valueOf(position[1]);
                in.getP().setLocation(Xpos, Ypos);
            
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }

    }


    
}