package Service.component1;

/**
 * @ClassNameGraduateBorrow
 * @Describtion 研究生借书策略实现
 * @Author
 * @Version 1.0
 **/
public class GraduateBorrow implements BorrowStrategy {
	@Override
	public void borrow() {
		System.out.println("研究生借书策略实现");
	}
}
