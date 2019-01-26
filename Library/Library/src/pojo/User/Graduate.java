package pojo.User;

public class Graduate extends User{
    public Graduate(String username, String password){
        this.username = username;
        this.password = password;
        this.hasBorrowed = 0;
        this.maxBorrow = 10;
        this.maxBorrowTime = 180;
    }
}
