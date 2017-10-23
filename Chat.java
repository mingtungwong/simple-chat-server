import java.util.ArrayList;

public class Chat {
    private ArrayList<User> users;
    private ArrayList<Message> messages;

    public Chat() {
        users = new ArrayList<User>();
        messages = new ArrayList<Message>();
    }

    public void addUser(String uName) throws Exception {
        if(!hasUser(uName)) users.add(new User(uName));
        else throw new Exception("The user already exists");
    }

    public boolean hasUser(String uName) {
        for(User u: users) {
            if(u.getUsername() == uName) return true;
        }
        return false;
    }
}