package Service.component1;

/**
 * @ClassNameGraduateBorrow
 * @Describtion 研究生借书策略实现
 * @Author
 * @Version 1.0
 **/
public class GraduateBorrow implements BorrowStrategy {
	@Override
	public String borrow() {
		return "研究生借书策略实现:可借10本书，最大借阅时长180天";
	}
}
