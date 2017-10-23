import java.util.HashMap;
import java.util.ArrayList;

public class Chat {
    private HashMap<String, User> users;
    private ArrayList<Message> messages;

    public Chat() {
        users = new HashMap<String, User>();
        messages = new ArrayList<Message>();
    }

    public void addUser(String uName) throws Exception {
        if(!hasUser(uName)) users.add(new User(uName));
        else throw new Exception("The user already exists");
    }

    public boolean hasUser(String uName) {
        return users.get(uName) != null;
    }
}