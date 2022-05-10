import java.util.Scanner;
import java.util.Objects;

public class Main {

    public static void main(String[] args)
    {
            Scanner input = new Scanner(System.in);
            Iface iface = new Iface();
            int aux1 = 1, aux2 = 1;
            while(aux2 != 2)
            {
                System.out.println("-->> What do you want to do? <<--\n[1] - SignUp\n[2] - LogIn\n[99] - Exit");
                aux1 = input.nextInt();
                if(aux1 == 99)
                {
                    System.out.print("\n\n ->>> Bye bye, have a nice day! <<<- \n\n\n");
                    break;
                }

                String username, password, name;

                switch(aux1)
                {
                    case 1:
                        System.out.print("\nFirst name: ");
                        input.nextLine();
                        name = input.nextLine();

                        while(iface.names.contains(name))
                        {
                            System.out.print("\nName in use, try another:");
                            name = input.nextLine();
                        }
                        iface.names.add(name);

                        System.out.print("User: ");
                        username = input.nextLine();

                        while(iface.nickNames.contains(username))
                        {
                            System.out.print("\nUsername in use, try another:");
                            username = input.nextLine();
                        }
                        iface.nickNames.add(username);

                        System.out.print("Password: ");
                        password = input.nextLine();
                        iface.passwords.add(password);

                        Account newAccount = new Account(name, password, username);
                        iface.add(newAccount);
                        System.out.print("\nAccount created. Press [1] to LogIn: ");
                        aux2 = input.nextInt();
                        aux1 = 1;
                    case 2:
                        //System.out.print("Linha 52");
                        System.out.print("\nUser: ");
                        input.nextLine();
                        username = input.nextLine();

                        System.out.print("Password: ");
                        password = input.nextLine();

                        while(!(iface.nickNames.contains(username)) || !iface.passwords.contains(password)
                        || ((iface.nickNames.indexOf(username)) != iface.passwords.indexOf(password)))
                        {
                            System.out.print("\nWe do not found you in system, try again or type [0] to return\nUser: ");
                            username = input.nextLine();

                            if(Objects.equals(username, "0"))
                            {
                                break;
                            }

                            System.out.print("Password: ");
                            password = input.nextLine();
                        }
                            if(!Objects.equals(username,"0"))
                        {
                            int otoAux = iface.nickNames.indexOf(username);
                            Account logged = iface.accounts.get(otoAux);
                            name = iface.names.get(otoAux);

                            System.out.print("\n-->> Welcome, you're logged in " + logged.getNick());
                            System.out.print(" <<--\n\n");
                            int menuNavigation = 1;
                            while(menuNavigation != 14)
                            {
                                System.out.println("-->> What do you want to do? <<-- \n[1] - Change profile\n[2] - Account info\n[3] - Add new friend\n[4] - Friend requests\n[5] - Friends\n[6] - Send message\n[7] - New messages\n[8] - Chats\n[9] - New community\n[10] - Search community\n[11] - Community admin painel\n[12] - Community list\n[13] - Delete my profile\n[14] - Logout");
                                menuNavigation = input.nextInt();
                                if(menuNavigation == 1)
                                {
                                    System.out.print("\n -- Change profile info -- \n");
                                        //Nome
                                        System.out.print("New name: ");
                                        input.nextLine();
                                        name = input.nextLine();
                                        while(iface.names.contains(name))
                                        {
                                            System.out.print("\nName in use, try again.\nNew name: ");
                                            name = input.nextLine();
                                        }
                                        logged.setName(name);
                                        iface.set(logged, otoAux);
                                        iface.names.set(otoAux, name);
                                        //Usuario
                                        System.out.print("New username: ");
                                        //input.nextLine();
                                        username = input.nextLine();
                                        while(iface.nickNames.contains(username))
                                        {
                                            System.out.print("\nUsername in use, try again\nNew username: ");
                                            username = input.nextLine();
                                        }
                                        logged.setNick(username);
                                        //Senha
                                        System.out.print("New password: ");
                                        //input.nextLine();
                                        password = input.nextLine();
                                        logged.setPassword(password);
                                        iface.set(logged, otoAux);
                                        iface.passwords.set(otoAux, password);
                                        iface.set(logged, otoAux);
                                        iface.nickNames.set(otoAux, username);

                                    System.out.print("\nChanges saved\n\n");
                                }
                                if(menuNavigation == 2)
                                {
                                    System.out.print("-->> These are your account info <<--\n");
                                    System.out.print("\nName: " + logged.getName());
                                    System.out.print("\nUser: " + logged.getNick());              
                                    System.out.print("\nPassword: " + logged.getPassword());
                                    System.out.print("\n\n");
                                }
                                if(menuNavigation == 3)
                                {
                                    System.out.print("\nFriend's name:");
                                    input.nextLine();
                                    String friendName = input.nextLine();

                                    while(((!iface.names.contains(friendName)) && (!Objects.equals(friendName,"0"))) || (Objects.equals(friendName, logged.getName())))
                                    {
                                        System.out.print("\nFriend was not found.\n\n");
                                        System.out.print("[0] - Back to menu\n");
                                        friendName = input.nextLine();
                                    }
                                    if(!Objects.equals(friendName,"0"))
                                    {
                                        int index_friend = iface.names.indexOf(friendName);
                                        Account friend = iface.accounts.get(index_friend);
                                        friend.addRequest(name);

                                        System.out.print("\nFriend request sent\n");
                                    }
                                }
                                if(menuNavigation == 4)
                                {
                                    if(logged.friendRequest.isEmpty())
                                    {
                                        System.out.print("\nNo friend requests yet\n");
                                    }
                                    else
                                    {
                                        for(int i = 0; i<logged.friendRequest.size(); i++)
                                        {
                                            String friendName = logged.friendRequest.get(i);

                                            System.out.print(friendName + "\n");
                                            System.out.print("[1] - Accept friend\n[2] - Cancel request\n");
                                            int friendshipKey = input.nextInt();

                                            if(friendshipKey == 1)
                                            {
                                                int friend_index = iface.names.indexOf(friendName);
                                                Account friend = iface.accounts.get(friend_index);
                                                logged.addFriend(friend);
                                                friend.addFriend(logged);
                                                logged.friendRequest.remove(i);
                                            }
                                            else{
                                                logged.friendRequest.remove(i);
                                            }
                                        }
                                    }
                                    
                                }
                                if(menuNavigation == 5)
                                {
                                    if(logged.friends.isEmpty())
                                    {
                                        System.out.print("\nYou do not have friends yet!\n\n");
                                    } 
                                    else
                                    {
                                        System.out.print("\nFriends: \n\n");
                                        for(int i=0; i<logged.friends.size(); i++)
                                        {
                                            if(i+1 == logged.friends.size()) System.out.print(logged.friends.get(i).getNick() + ".\n\n");
                                            else System.out.print(logged.friends.get(i).getNick() + ";\n");
                                        }
                                    }
                               
                                }
                                if(menuNavigation == 6)
                                {
                                    System.out.print("\nPlease, enter the receiver name: ");
                                    input.nextLine();
                                    String receiver_name = input.nextLine();
                                    while(!logged.friendName.contains(receiver_name) && (!Objects.equals(receiver_name, "0")))
                                    {
                                        System.out.print("\nFriend not found. Try again or type [0] to cancel\n");
                                        receiver_name = input.nextLine();
                                    }
                                    if(!Objects.equals(receiver_name, "0"))
                                    {
                                        System.out.print("\nPlease, type the message:\n");
                                        String body = input.nextLine();

                                        int receiver_index = iface.names.indexOf(receiver_name);
                                        Account receiver = iface.accounts.get(receiver_index);
                                        Message message = new Message(body, receiver, logged);
                                        receiver.msgReceived.add(message);
                                        logged.msgSent.add(message);
                                        System.out.print("\nMessage delivered\n\n");
                                        System.out.print("---- MENU ----.\n\n");
                                    }
                                }
                                if(menuNavigation == 7)
                                {
                                    int count1 = 0;
                                    for(int i=0; i<logged.msgReceived.size(); i++)
                                    {
                                        if(logged.msgReceived.get(i).read) count1++;
                                    }
                                    if(count1 == logged.msgReceived.size()) System.out.print("\nNo new messages\n\n");
                                    else
                                    {
                                        for(int i=0; i<logged.msgReceived.size(); i++)
                                        {
                                            if (!logged.msgReceived.get(i).read)
                                            {
                                                System.out.print("New message ->" + logged.msgReceived.get(i).getSender() + ".\n");
                                                System.out.print("\n" + logged.msgReceived.get(i).getBody() + "\n");
                                                logged.msgReceived.get(i).read = true;
                                                System.out.print("[1] - msgop;\n[2] - Mark as read\n");
                                                input.nextLine();
                                                int msgop = input.nextInt();

                                                if (msgop == 1)
                                                {
                                                    System.out.print("\nMessage:\n");
                                                    input.nextLine();
                                                    String body = input.nextLine();

                                                    int receiver_index = iface.names.indexOf(logged.msgReceived.get(i).getSender());
                                                    Account receiver = iface.accounts.get(receiver_index);

                                                    Message message = new Message(body, receiver, logged);

                                                    receiver.msgReceived.add(message);
                                                    logged.msgSent.add(message);

                                                    System.out.print("\nMessage sent!\n\n");
                                                    System.out.print("---- MENU ----.\n\n");
                                                }
                                            }
                                        }
                                    }
                                }
                                if(menuNavigation == 8)
                                {
                                    int lalala = 9;
                                    System.out.print("\nChats:\n\n");
                                    if(logged.msgReceived.isEmpty()){
                                        System.out.print("Empty\n");
                                        lalala = 0;
                                    }
                                    else
                                    {
                                        for(int i=0; i<logged.msgReceived.size(); i++)
                                        {
                                            System.out.print("From: " + logged.msgReceived.get(i).getSender() + "\n");
                                            System.out.print(logged.msgReceived.get(i).getBody() + "\n\n");
                                        }
                                    }
                                    if(logged.msgSent.isEmpty() && lalala != 0){
                                        System.out.print("Empty\n");
                                    }
                                    else
                                    {
                                        System.out.print("\nMessages sent:\n\n");
                                        for(int i=0; i<logged.msgSent.size(); i++)
                                        {
                                            System.out.print("To: " + logged.msgSent.get(i).getReceiver() + "\n");
                                            System.out.print(logged.msgSent.get(i).getBody() + "\n\n");
                                        }
                                    }
                                }
                                if(menuNavigation == 9)
                                {
                                    String communityName;
                                    System.out.print("\nCommunity name: ");
                                    input.nextLine();
                                    communityName = input.nextLine();

                                    while(iface.communitysNames.contains(communityName))
                                    {
                                        System.out.print("\nYou can't chose this name. Try again:");
                                        communityName = input.nextLine();
                                    }

                                    System.out.print("Description: ");
                                    String description = input.nextLine();

                                    System.out.print("\nCommunity created\n\n");

                                    Community my_community = new Community(communityName, description, logged);
                                    iface.communitysNames.add(communityName);
                                    iface.communitys.add(my_community);
                                    logged.communityHost.add(my_community);
                                    logged.communityMember.add(my_community);
                                }
                                if(menuNavigation == 10)
                                {
                                    String communityName;
                                    System.out.print("\nCommunity name: ");
                                    input.nextLine();
                                    communityName = input.nextLine();

                                    while(!iface.communitysNames.contains((communityName)))
                                    {
                                        System.out.print("\nCommunity inexistent. Try again or type [0] to cancel:\n");
                                        communityName = input.nextLine();
                                        if(Objects.equals(communityName, "0"))
                                        {
                                            break;
                                        }
                                    }
                                    if(!Objects.equals(communityName, "0"))
                                    {
                                        int index_community = iface.communitysNames.indexOf(communityName);
                                        Community Community = iface.communitys.get(index_community);
                                        int lala = 9;
                                        while(Community.members.contains(logged))
                                        {
                                            System.out.print("\nYou're already a member");
                                            lala = 0;
                                            break;
                                        }
                                        index_community = iface.communitysNames.indexOf(communityName);
                                        Community = iface.communitys.get(index_community);

                                        Community.joinRqt.add(logged.getNick());
                                        if(lala != 0)
                                        {
                                            System.out.print("\nMember request sent\n\n");
                                        }
                                        System.out.print("---- MENU ----\n\n");
                                    }
                                }
                                if(menuNavigation == 11)
                                {
                                    if(logged.communityHost.isEmpty())
                                    {
                                        System.out.print("\nYou are not a community host\n\n");
                                    }
                                    else
                                    {
                                        int manage, cmtHost;
                                        Community open;
                                        for(int i=0; i<logged.communityHost.size(); i++)
                                        {
                                            System.out.print("\nDo you want to manage " + logged.communityHost.get(i).getName() + "?\n");
                                            System.out.print("[1] - Yes;\n[2] - No.\n");
                                            input.nextLine();
                                            manage = input.nextInt();

                                            if(manage == 1)
                                            {
                                                open = logged.communityHost.get(i);
                                                cmtHost = 1;

                                                while(cmtHost != 6)
                                                {
                                                    System.out.print("\n----COMMUNITY MENU---- \n");
                                                    System.out.print("[1] - Add member\n");
                                                    System.out.print("[2] - Check join requests\n");
                                                    System.out.print("[3] - Ban member\n");
                                                    System.out.print("[4] - See members\n");
                                                    System.out.print("[5] - Delete community\n");
                                                    System.out.print("[6] - Back\n");
                                                    cmtHost = input.nextInt();
                                                    if(cmtHost == 1)
                                                    {
                                                        String memberCmtName;
                                                        System.out.print("\nAccount name:");
                                                        input.nextLine();
                                                        memberCmtName = input.nextLine();
                                                        while (!iface.names.contains(memberCmtName))
                                                        {
                                                            System.out.print("\nAccount not found.\nAccount name:");
                                                            memberCmtName = input.nextLine();
                                                        }
                                                        if(open.memberrNmes.contains(memberCmtName))
                                                        {
                                                            System.out.print(memberCmtName + "is already a member");
                                                        }
                                                        int member_index = iface.names.indexOf(memberCmtName);
                                                        Account member = iface.accounts.get(member_index);
                                                        member.communityMember.add(open);
                                                        open.add_member(member);
                                                        open.memberrNmes.add(member.getName());
                                                        System.out.print("\nMember added\n\n");
                                                    }
                                                    if(cmtHost == 2)
                                                    {
                                                        if(open.joinRqt.isEmpty())
                                                        {
                                                            System.out.print("\nRequest box empty\n");
                                                        }
                                                        else
                                                        {
                                                            for(i=0; i<open.joinRqt.size(); i++)
                                                            {
                                                                System.out.print(open.joinRqt.get(i));
                                                                System.out.print(" want to enter your community?\n");
                                                                System.out.print("[1] - Accept\n[2] - Reject\n");
                                                                int accept = input.nextInt();
                                                                if(accept == 1)
                                                                {
                                                                    int member_index = iface.nickNames.indexOf(open.joinRqt.get(i));
                                                                    Account member = iface.accounts.get(member_index);

                                                                    member.communityMember.add(open);
                                                                    open.add_member(member);
                                                                    open.memberrNmes.add(member.getName());
                                                                    open.joinRqt.remove(i);
                                                                    System.out.print("\nMember accepted\n\n");
                                                                }
                                                                if(accept == 2)
                                                                {
                                                                    System.out.print("\nRequest rejected\n\n");
                                                                    open.joinRqt.remove(i);
                                                                }
                                                            }

                                                        }
                                                    }
                                                    if(cmtHost == 3)
                                                    {
                                                        String memberCmtName;
                                                        System.out.print("\nMember name:");
                                                        input.nextLine();
                                                        memberCmtName = input.nextLine();
                                                        while(!open.memberrNmes.contains(memberCmtName))
                                                        {
                                                            System.out.print("\nMember not found! Try again: ");
                                                            memberCmtName = input.nextLine();
                                                        }
                                                        int member_index = open.memberrNmes.indexOf(memberCmtName);
                                                        Account member = open.members.get(member_index);
                                                        open.members.remove(member);
                                                        open.memberrNmes.remove(memberCmtName);
                                                        member.communityMember.remove(open);
                                                        System.out.print("\nMember banned!\n\n");
                                                    }
                                                    if(cmtHost == 4)
                                                    {
                                                        System.out.print("\nMembers list: \n\n");
                                                        for(i=0; i<open.members.size(); i++)
                                                        {
                                                            System.out.print(open.members.get(i).getNick());
                                                            if(i+1 == open.members.size()) System.out.print(".\n");
                                                            else System.out.print(";\n");
                                                        }
                                                    }
                                                    if(cmtHost == 5)
                                                    {
                                                        open.delete();
                                                        iface.communitys.remove(open);
                                                        iface.communitysNames.remove(open.getName());
                                                        System.out.print("\nCommunity deleted!\n\n");
                                                        cmtHost = 6;
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }
                                if(menuNavigation == 12)
                                {
                                    if(logged.communityMember.isEmpty())
                                    {
                                        System.out.print("\nYou are not a community member\n\n");
                                    }
                                    else
                                    {
                                        System.out.print("\nYou're member of:\n\n");
                                        for(int i=0; i<logged.communityMember.size(); i++)
                                        {
                                            System.out.print(logged.communityMember.get(i).getName());
                                            if(i+1 == logged.communityMember.size()) System.out.print(".\n\n");
                                            else System.out.print(";\n");
                                        }
                                    }

                                }
                                if(menuNavigation == 13)
                                {
                                    int i;
                                    for(i=0; i<logged.friends.size(); i++)
                                    {
                                        logged.friends.get(i).friends.remove(logged);
                                    }
                                    for(i=0; i<logged.communityMember.size(); i++)
                                    {
                                        logged.communityMember.get(i).members.remove(logged);
                                        logged.communityMember.get(i).memberrNmes.remove(logged.getName());
                                    }
                                    for(i=0; i<logged.communityHost.size(); i++)
                                    {
                                        iface.communitys.remove(logged.communityHost.get(i));
                                        iface.communitysNames.remove(logged.communityHost.get(i).getName());
                                        logged.communityHost.get(i).delete();
                                    }
                                    iface.names.remove(logged.getName());
                                    iface.passwords.remove(logged.getPassword());
                                    iface.nickNames.remove(logged.getNick());
                                    iface.accounts.remove(logged);
                                    System.out.print("\nDone!\n\n");
                                    menuNavigation = 14;
                                }
                            }
                        }
                    }
            }
    }
}
