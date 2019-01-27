package Service.component2;

/**
 * @ClassNameAdminService
 * @Describtion 管理者的服务，实现授权服务
 * @Author
 * @Version 1.0
 **/
public class AdminService implements AuthorizedService {
	public void editLiteratureInfo() {
		System.out.println("修改图书信息");
	}

	public void addtLiteratureInfo() {
		System.out.println("新增图书信息");
	}

	public void deleteLiteratureInfo() {
		System.out.println("删除图书信息");
	}

	public void addUser() {
		System.out.println("新增用户");
	}

	public void deleteUser() {
		System.out.println("删除用户");
	}

	public void createUserInfo() {
		System.out.println("新建用户信息");
	}

	public void editUserInfo() {
		System.out.println("修改用户信息");
	}

	public void searchUserInfo() {
		System.out.println("查询用户信息");
	}

	@Override
	public void generateBorrowReport() {
		System.out.println("生成借书记录");
	}

	@Override
	public void generatePenalty() {
		System.out.println("生成罚金");
	}

}
