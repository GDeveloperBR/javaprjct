public class Person {
    public String name, nickname;
    private String password; 

    public String getPass()
    {
        return password; //Encapsulamento 
    }
    public void setPassword(String password){
        this.password = password;
    }
}

