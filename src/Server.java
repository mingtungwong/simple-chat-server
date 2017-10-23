import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static Chat c = new Chat();

    public static void main(String[] args) {
        startServer(5555);
    }

    private static void startServer(int port) {
        try {
            ServerSocket welcome = new ServerSocket(port);

            while(true) {
                Socket client = welcome.accept();
                ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());


            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
