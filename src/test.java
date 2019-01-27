import pojo.BorrowRecord;
import ui.LoginUI;

public class test {
    public static void main(String[] args){
        BorrowRecord borrowRecord = new BorrowRecord(1,1,1);
        System.out.println(borrowRecord.getBorrowTime());
        LoginUI login = new LoginUI();
    }
}
