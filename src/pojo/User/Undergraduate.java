package pojo.User;

import Service.component4.Subject;
import utils.BorrowState;

public class Undergraduate extends User implements Subject {
    private Administrator ad = new Administrator("admin", "admin");

    public Undergraduate(String username, String password) {
        this.username = username;
        this.password = password;
        this.hasBorrowed = 0;
        this.maxBorrow = 5;
        this.maxBorrowTime = 90;
        this.borrowState = BorrowState.enable;
        this.penalty = 0;
        this.typeId = 4;
        this.typeName = "本科生";
    }

    public void update(String name, String password){
        super.update(name, password);
        notifyObserver(ad);
    }
}
