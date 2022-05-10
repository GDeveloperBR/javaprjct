import java.util.ArrayList;

public class Iface {

    ArrayList<Account> accounts = new ArrayList<Account>();
    ArrayList<Community> communitys = new ArrayList<Community>();
    ArrayList<String> communitysNames = new ArrayList<String>();
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> nickNames = new ArrayList<String>();
    ArrayList<String> passwords = new ArrayList<String>();

    public void add(Account conta)
    {
        accounts.add(conta);
    }

    public void set(Account conta, int y)
    {
        accounts.set(y, conta);
    }
}
