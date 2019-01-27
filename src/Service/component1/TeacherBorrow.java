package Service.component1;

/**
 * @ClassNameTeacherBorrow
 * @Describtion 教师借书策略实现
 * @Author
 * @Version 1.0
 **/
public class TeacherBorrow implements BorrowStrategy {
	@Override
	public String borrow() {
		return "教师借书策略实现:可借10本书，最大借阅时长365天";
	}
}
