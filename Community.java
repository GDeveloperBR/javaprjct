import java.util.ArrayList;

public class Community {

    public Account host;
    public String description;
    ArrayList<Account> members = new ArrayList<Account>();
    ArrayList<String> memberrNmes = new ArrayList<String>();
    ArrayList<String> joinRqt = new ArrayList<String>();
    public String communityName;

    public Community(String name, String description, Account host)
    {
        this.communityName = name;
        this.host = host;
        members.add(host);
        memberrNmes.add(host.getName());
        this.description = description;

    }

    public String getName()
    {
        return communityName;
    }

    public Account getOwner()
    {
        return host;
    }

    public void add_member(Account member)
    {
        members.add(member);
    }

    public void setName(String name)
    {
        this.communityName = name;
    }

    public void setOwner(Account new_owner)
    {
        this.host = new_owner;
    }

    public void delete()
    {
        int j = 0;

        this.members.get(j).communityHost.remove(this);

        for(j=0; j<this.members.size(); j++)
        {
            this.members.get(j).communityMember.remove(this);
        }
    }
}
