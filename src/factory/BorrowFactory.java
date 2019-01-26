package factory;

import Service.BorrowStrategy;
import Service.GraduateBorrow;
import Service.TeacherBorrow;
import Service.UngraduateBorrow;
import utils.UserType;

/**
 * @ClassNameBorrowFactory
 * @Describtion TODO
 * @Author
 * @Version 1.0
 **/
public class BorrowFactory {
	public static BorrowStrategy createStrategy(UserType userType){
		BorrowStrategy borrowStrategy = null;
		switch (userType){
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
