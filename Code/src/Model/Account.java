package Model;

public class Account extends Person{
    private String user;
    private String passWord;

    public Account() {
    }

    public Account(String name, int age, String phone, String address) {
        super(name, age, phone, address);
    }

    public Account(String user, String passWord) {
        this.user = user;
        this.passWord = passWord;
    }

    public Account(String user, String passWord, String name, int age, String phone, String address) {
        super(name, age, phone, address);
        this.user = user;
        this.passWord = passWord;
    }

    public String getUser() {
        return user;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    
}
