package Service.component2;

/**
 * @ClassNameAuthorizeUser
 * @Describtion TODO
 * @Author
 * @Version 1.0
 **/
public class AuthorizeUser implements AuthorizedService {
	@Override
	public void generateBorrowReport() {
		new AdminService().generateBorrowReport();
	}

	@Override
	public void generatePenalty() {
		new AdminService().generatePenalty();
	}
}
