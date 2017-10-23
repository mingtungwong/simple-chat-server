import java.util.ArrayList;

public class Chat {
    private ArrayList<User> users;
    private ArrayList<Message> messages;

    public Chat() {
        users = new ArrayList<User>();
        messages = new ArrayList<Message>();
    }
}