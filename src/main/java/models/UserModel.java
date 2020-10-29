package models;

public class UserModel {
    private String name;
    private String password;
    private String fname;
    private String sname;

    public UserModel( ) {

    }

    public UserModel(String name, String password, String fname, String sname) {
        this.name = name;
        this.password = password;
        this.fname = fname;
        this.sname = sname;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getFname() {
        return fname;
    }

    public String getSname() {
        return sname;
    }
}
