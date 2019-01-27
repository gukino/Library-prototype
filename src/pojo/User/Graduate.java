package pojo.User;

import Service.component4.Subject;
import utils.BorrowState;

public class Graduate extends User implements Subject {
	private Administrator ad = new Administrator("admin", "admin");
	public Graduate(String username, String password) {
		this.username = username;
		this.password = password;
		this.hasBorrowed = 0;
		this.maxBorrow = 10;
		this.maxBorrowTime = 180;
		this.borrowState = BorrowState.enable;
		this.penalty = 0;
		this.typeId = 3;
		this.typeName = "研究生";
	}

	public void update(String name, String password){
		super.update(name, password);
		notifyObserver(ad);
	}
}
