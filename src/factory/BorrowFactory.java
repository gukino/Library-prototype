package factory;

import Service.component1.BorrowStrategy;
import Service.component1.GraduateBorrow;
import Service.component1.TeacherBorrow;
import Service.component1.UngraduateBorrow;
import utils.UserType;

/**
 * @ClassNameBorrowFactory
 * @Describtion 简单工厂对不同用户生成不同策略
 * @Author
 * @Version 1.0
 **/
public class BorrowFactory {
	public static BorrowStrategy createStrategy(UserType userType) {
		BorrowStrategy borrowStrategy = null;
		switch (userType) {
			case Teacher:
				borrowStrategy = new TeacherBorrow();
				break;
			case graduate:
				borrowStrategy = new GraduateBorrow();
				break;
			case Ungraduate:
				borrowStrategy = new UngraduateBorrow();
				break;
		}
		return borrowStrategy;
	}
}
