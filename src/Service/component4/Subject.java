package Service.component4;

import pojo.User.Administrator;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    List<Administrator> observers = new ArrayList<>();
    default void addObserver(Administrator ad){
        observers.add(ad);
    }

    default void deleteObserver(Administrator ad){
        observers.remove(ad);
    }


    default void notifyObserver(Administrator ad) {
        ad.update();
    }
}
