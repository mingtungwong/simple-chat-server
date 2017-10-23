import java.util.Date;

public class Message {
    
    private String sender, message;
    private Date timestamp;

    public Message(String sender, String message) {
        this.sender = sender;
        this.message = message;
        this.timestamp = new Date();
    }

    public String toString() {
        return "<" + timestamp.toString().substring(4, 19) + "> " + sender + ": " + message;
    }

    public Date getTimestamp() { return new Date(timestamp.getTime()); }
}