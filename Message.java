import java.util.Date;

public class Message {
    
    private String sender, message;
    private Date timestamp;

    public Message(String sender, String message, Date timestamp) {
        this.sender = sender;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String toString() {
        return '<' + timestamp.toString() + '>' + sender + ':' + message;
    }
}