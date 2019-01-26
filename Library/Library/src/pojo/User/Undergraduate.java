package pojo.User;

public class Undergraduate extends User {
    public Undergraduate(String username, String password){
        this.username = username;
        this.password = password;
        this.hasBorrowed = 0;
        this.maxBorrow = 5;
        this.maxBorrowTime = 90;
    }
}
