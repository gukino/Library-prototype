package pojo.User;

import Service.component4.Subject;
import pojo.UserType;
import utils.BorrowState;

public class User implements Subject {
    protected int id;
    protected String username;
    protected String password;
    protected int maxBorrow;
    protected int hasBorrowed;
    protected int maxBorrowTime;
    protected double penalty;
    protected BorrowState borrowState = BorrowState.enable;
    protected int typeId;
    protected String typeName;


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return  password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public int getMaxBorrow(){
        return maxBorrow;
    }

    public void setMaxBorrow(int maxBorrow){
        this.maxBorrow = maxBorrow;
    }

    public int getHasBorrowed(){
        return hasBorrowed;
    }

    public void setHasBorrowed(int hasBorrowed){
        this.hasBorrowed = hasBorrowed;
    }

    public int getMaxBorrowTime(){
        return maxBorrowTime;
    }

    public void setMaxBorrowTime(int maxBorrowTime){
        this.maxBorrowTime = maxBorrowTime;
    }

    public int getTypeId(){
        return typeId;
    }

    public void setTypeId(int typeId){
        this.typeId = typeId;
    }

    public BorrowState getBorrowState(){
        return borrowState;
    }

    public String getTypeName(){
        return typeName;
    }

    public void update(String name, String password){
        this.username = name;
        this.password = password;
    }

}
