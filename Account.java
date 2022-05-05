import java.util.ArrayList;

public class Account {

    ArrayList<Account> friends = new ArrayList<Account>();
    ArrayList<String> friendName = new ArrayList<String>();
    ArrayList<Community> communityMember = new ArrayList<Community>();
    ArrayList<Community> communityHost = new ArrayList<Community>();
    ArrayList<String> friendRequest = new ArrayList<String>();
    ArrayList<Message> msgSent = new ArrayList<Message>();
    ArrayList<Message> msgReceived = new ArrayList<Message>();
    public String name;
    public String password;
    public String nickname;

    public Account(String name, String password, String nickname)
    {
        this.name = name;
        this.password = password;
        this.nickname = nickname;
    }

    public String getName()
    {
        return this.name;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getNick()
    {
        return this.nickname;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setNick(String nick)
    {
        this.nickname = nick;
    }

    public void add_request(String friendName)
    {
        friendRequest.add(friendName);
    }

    public void add_friend(Account friend)
    {
        friends.add(friend);
        friendName.add(friend.getName());
    }
}
