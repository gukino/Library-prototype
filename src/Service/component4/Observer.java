package Service.component4;

public interface Observer {
    default void update(){
        System.out.println("用户信息已更改");
    }
}
