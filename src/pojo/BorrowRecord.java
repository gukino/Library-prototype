package pojo;

import java.sql.Date;

public class BorrowRecord {
    private int id;
    private int userId;
    private int bookId;
    private Date borrowTime;
    private Date backTime;
    private boolean ifBack = false;

    public BorrowRecord(int id, int userId, int bookId){
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowTime = new Date(new java.util.Date().getTime());
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getBookId(){
        return bookId;
    }

    public void setBookId(int bookId){
        this.bookId = bookId;
    }

    public Date getBorrowTime(){
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime){
        this.borrowTime = borrowTime;
    }

    public Date getBackTime(){
        return backTime;
    }

    public void setBackTime(Date backTime){
        this.backTime = backTime;
    }

    public boolean getIfBack(){
        return ifBack;
    }

    public void setIfBack(boolean ifBack){
        this.ifBack = ifBack;
    }
}
