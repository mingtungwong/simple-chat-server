import java.util.*;

public class Chat {
    private Map users;
    private List messages;

    public Chat() {
        users = Collections.synchronizedMap(new HashMap<String, User>());
        messages = Collections.synchronizedList(new ArrayList<Message>());
    }

    public void addUser(String uName) throws Exception {
        if(!hasUser(uName)) users.put(uName, new User(uName));
        else throw new Exception("The user already exists");
    }

    public User[] getUsers() { return (User[])users.keySet().toArray(); }

    public boolean hasUser(String uName) {
        return users.get(uName) != null;
    }

    public void addMessage(String username, String message) {
        messages.add(new Message(username, message));
        messages.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Message) o1).getTimestamp().compareTo(((Message) o2).getTimestamp());
            }
        });
    }

    public String toString() {
        String result = "";
        for(Object m: messages) result += m.toString() + "\n";
        return result;
    }
}