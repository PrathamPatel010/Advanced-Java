package Util;

public class User {
    private String username;
    private String email;
    private long mobile;
    private String password;
    
    public User(String username,String email,long mobile,String password){
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public long getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }
}
