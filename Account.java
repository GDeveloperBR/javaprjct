import java.util.ArrayList;

public class Account extends Person{
    ArrayList<Account> friends = new ArrayList<Account>();
    ArrayList<String> friendName = new ArrayList<String>();
    ArrayList<Community> communityMember = new ArrayList<Community>();
    ArrayList<Community> communityHost = new ArrayList<Community>();
    ArrayList<String> friendRequest = new ArrayList<String>();
    ArrayList<Message> msgSent = new ArrayList<Message>();
    ArrayList<Message> msgReceived = new ArrayList<Message>();
    //ArrayList<Mail> admMail = new ArrayList<Mail>();
    //private String name, password, nickname;
    public class AdmUser extends Person{
        public static int admpass = 57245321;
    }
    // public class SystemAdm extends Account{
    //     public admin(String admName, String admEmail, int admPass){
    //         super(admName, admEmail, admPass);
    //     }
    // }

    public Account(String name, String password, String nickname)
    {
        this.name = name;
        setPassword(password);
        this.nickname = nickname;
    }

    public String getName()
    {
        return this.name;
    }

    // public String getPassword()
    // {
    //     return this.password;
    // }

    public String getNick()
    {
        return this.nickname;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    // public void setPassword(String password)
    // {
    //     this.password = password;
    // }

    public void setNick(String nick)
    {
        this.nickname = nick;
    }

    public void addRequest(String friendName)
    {
        friendRequest.add(friendName);
    }

    public void addFriend(Account friend)
    {
        friends.add(friend);
        friendName.add(friend.getName());
    }
}
