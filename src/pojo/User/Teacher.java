package pojo.User;

public class Teacher extends User {
    public Teacher(String username, String password){
        this.username = username;
        this.password = password;
        this.hasBorrowed = 0;
        this.maxBorrow = 10;
        this.maxBorrowTime = 365;
    }
}
