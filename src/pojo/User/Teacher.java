package pojo.User;

import utils.BorrowState;

public class Teacher extends User {
	public Teacher(String username, String password) {
		this.username = username;
		this.password = password;
		this.hasBorrowed = 0;
		this.maxBorrow = 10;
		this.maxBorrowTime = 365;
		this.borrowState = BorrowState.enable;
		this.penalty = 0;
		this.typeId = 2;
	}
}
