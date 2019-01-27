package pojo.User;

import utils.BorrowState;

public class Undergraduate extends User {
    public Undergraduate(String username, String password){
        this.username = username;
        this.password = password;
        this.hasBorrowed = 0;
        this.maxBorrow = 5;
        this.maxBorrowTime = 90;
        this.borrowState = BorrowState.enable;
        this.penalty = 0;
        this.typeId = 4;
    }
}
