package org.example.sem5.hw.Presenter;

import org.example.sem5.hw.Models.DataBase;
import org.example.sem5.hw.Models.DataBaseMethods;
import org.example.sem5.hw.Models.User;

import java.util.List;

public class BalanceOperations {
    void ToPlusTheBalance(String moneyToCollect, User user){
        DataBaseMethods dbm = new DataBaseMethods();
        List<User> userList = dbm.ReadDB();
        for (User user1 : userList){
            if (user1.getUserId() == user.getUserId()){
                user.setBankAccount(PlusBalance(user.getBankAccount(), Double.parseDouble(moneyToCollect)));
            }
        }
        dbm.WriteDB(userList);
    }
    void ToMinusTheBalance(String moneyToWithdraw, User user){
        DataBaseMethods dbm = new DataBaseMethods();
        List<User> userList = dbm.ReadDB();
        for (User user1 : userList){
            if (user1.getUserId() == user.getUserId()){
                user.setBankAccount(MinusBalance(user.getBankAccount(),Double.parseDouble(moneyToWithdraw)));
            }
        }
        dbm.WriteDB(userList);
    }
    public  Double GetBalance(User user){
        return user.getBankAccount();
    }
    public Double PlusBalance(Double oldBalance, Double moneyToCollect) {
        return oldBalance + moneyToCollect;
    }

    public Double MinusBalance(Double oldBalance, Double moneyToWithdraw){
        return oldBalance - moneyToWithdraw;
    }

    public void SetBalance(Double newBalance, User user){
        DataBaseMethods dbm = new DataBaseMethods();
        List<User> userList = dbm.ReadDB();
        User userToSet;
        for (User listuser:userList
                  ) {
            if (user.getUserId() == listuser.getUserId()){
                userToSet = listuser;
                userToSet.setBankAccount(newBalance);
            }
        }
        dbm.WriteDB(userList);
    }
}
