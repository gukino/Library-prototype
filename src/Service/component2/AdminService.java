package Service.component2;

/**
 * @ClassNameAdminService
 * @Describtion 管理者的服务，实现授权服务
 * @Author
 * @Version 1.0
 **/
public class AdminService implements AuthorizedService {
	public void editLiteratureInfo() {

	}

	public void addUser() {

	}

	public void deleteUser() {

	}

	public void createUserInfo() {

	}

	public void searchUserInfo() {

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
