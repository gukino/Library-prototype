package pojo.User;


import Service.component4.Observer;

public class Administrator extends User implements Observer {
	public Administrator(String username, String password) {
		this.username = username;
		this.password = password;
		this.hasBorrowed = 0;
		this.maxBorrow = 999;
		this.maxBorrowTime = 999;
		this.typeId = 1;
		this.typeName = "管理员";
	}
}
