package Service.component1;

/**
 * @ClassNameUngraduateBorrow
 * @Describtion 本科生借书策略实现
 * @Author
 * @Version 1.0
 **/
public class UngraduateBorrow implements BorrowStrategy {

	@Override
	public String borrow() {
		return"本科生借书策略实现:可借5本书，最大借阅时长90天";
	}
}
