package pojo.User;

import Service.component4.Subject;
import utils.BorrowState;

public class Teacher extends User implements Subject {
	private Administrator ad = new Administrator("admin", "admin");

	public Teacher(String username, String password) {
		this.username = username;
		this.password = password;
		this.hasBorrowed = 0;
		this.maxBorrow = 10;
		this.maxBorrowTime = 365;
		this.borrowState = BorrowState.enable;
		this.penalty = 0;
		this.typeId = 2;
		this.typeName = "教师";
	}
	public void update(String name, String password){
		super.update(name, password);
		notifyObserver(ad);
	}
}
