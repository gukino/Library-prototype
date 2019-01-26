package Service.component1;

/**
 * @ClassNameUngraduateBorrow
 * @Describtion 本科生借书策略实现
 * @Author
 * @Version 1.0
 **/
public class UngraduateBorrow implements BorrowStrategy {

	@Override
	public void borrow() {
		System.out.println("本科生借书策略实现");
	}
}
