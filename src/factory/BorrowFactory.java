package factory;

import Service.component1.BorrowStrategy;
import Service.component1.GraduateBorrow;
import Service.component1.TeacherBorrow;
import Service.component1.UngraduateBorrow;

/**
 * @ClassNameBorrowFactory
 * @Describtion 简单工厂对不同用户生成不同策略
 * @Author
 * @Version 1.0
 **/
public class BorrowFactory {
	public static BorrowStrategy createStrategy(String userType) {
		BorrowStrategy borrowStrategy = null;
		switch (userType) {
			case "教师":
				borrowStrategy = new TeacherBorrow();
				break;
			case "研究生":
				borrowStrategy = new GraduateBorrow();
				break;
			case "本科生":
				borrowStrategy = new UngraduateBorrow();
				break;
		}
		return borrowStrategy;
	}
}
