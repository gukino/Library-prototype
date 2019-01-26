package Service;

/**
 * @ClassNameTeacherBorrow
 * @Describtion 教师借书策略实现
 * @Author
 * @Version 1.0
 **/
public class TeacherBorrow implements BorrowStrategy {
	@Override
	public void borrow() {
		System.out.println("教师借书策略实现");
	}
}
