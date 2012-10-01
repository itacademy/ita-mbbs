package jp.itacademy.samples.web.mbbs;

public class User {

    private String handle;
    private String account;
    private String pass;

    public User(String handle, String account, String pass) {
        this.handle = handle;
        this.account = account;
        this.pass = pass;
    }

    public String getHandle() {
        return handle;
    }

    public String getAccount() {
        return account;
    }

    public String getPass() {
        return pass;
    }

}
