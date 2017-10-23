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

                Request incomingRequest = (Request)in.readObject();
                Request response = createResponse(incomingRequest);

                out.writeObject(response);
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Request createResponse(Request request) {

        switch(request.getRequestType()) {
            case ADDUSER:
                return tryToAddUser(request.getData());
                break;
            case ADDMESSAGE:
                break;
            case GETMESSAGES:
                break;
            case GETUSERS:
                break;
        }

        return new Request(Request.Requests.ERROR, "Invalid request");
    }

    private static Request tryToAddUser(Object o) {
        try {
            c.addUser((String) o);
            return new Request(Request.Requests.ADDUSER, c.getUsers());
        } catch(Exception e) {
            return new Request(Request.Requests.ERROR, e.getMessage());
        }
    }


}
