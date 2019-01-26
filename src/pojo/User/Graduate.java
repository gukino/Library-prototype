package pojo.User;

import utils.BorrowState;

public class Graduate extends User {
	public Graduate(String username, String password) {
		this.username = username;
		this.password = password;
		this.hasBorrowed = 0;
		this.maxBorrow = 10;
		this.maxBorrowTime = 180;
		this.borrowState = BorrowState.enable;
		this.penalty = 0;
	}
}
