import java.io.Serializable;

public class Request implements Serializable{

    public enum Requests {
        ADDUSER,
        ADDMESSAGE,
        GETMESSAGES,
        GETUSERS,
        ERROR
    };
    private Requests type;
    private Object data;

    public Request(Requests requestType, Object data) {
        this.type = requestType;
        this.data = data;
    }

    public Requests getRequestType() { return type; }
    public Object getData() { return data; }
}
