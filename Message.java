public class Message {

    public Account receiver;
    public Account sender;
    public String body;
    boolean read;

    public Message(String body, Account receiver, Account sender)
    {
        this.receiver = receiver;
        this.sender = sender;
        this.body = body;
        read = false;
    }

    public String getBody()
    {
        return body;
    }

    public String getReceiver()
    {
        return receiver.getName();
    }

    public String getSender()
    {
        return sender.getName();
    }

}
