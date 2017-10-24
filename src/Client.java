import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {

    private ArrayList<Message> messages = new ArrayList<Message>();
    private ArrayList<User> users = new ArrayList<User>();

    public static void main(String[] args) {

        try {
            Socket client = new Socket("127.0.0.1", 5555);
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            out.writeObject(new Request(Request.Requests.ADDUSER, "user"));
            Request r = (Request)in.readObject();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
