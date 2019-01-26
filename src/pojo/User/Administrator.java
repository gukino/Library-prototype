package pojo.User;

public class Administrator extends User {
    public Administrator(String username, String password){
        this.username = username;
        this.password = password;
        this.hasBorrowed = 0;
        this.maxBorrow = 999;
        this.maxBorrowTime = 999;
    }
}
