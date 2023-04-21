package org.example.sem5.hw.Models;

import java.util.Comparator;

public class User implements Comparable<User>, Comparator<User> {
    private int userId;
    private String userName;
    private String userSurname;
    private int userAge;
    private double bankAccount;


    public User() {
    }

    public User(int userId, String userName, String userSurname, int userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAge = userAge;
        this.bankAccount = 0;
    }

    public User(int userId, String userName, String userSurname, int userAge, double bankAccount) {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAge = userAge;
        this.bankAccount = bankAccount;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public int getUserAge() {
        return userAge;
    }

    public double getBankAccount() {
        return bankAccount;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public void setBankAccount(double bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Клиент:" + '\n' +
                "Id: " + userId + '\n' +
                "Имя: " + userName + '\n' +
                "Фамилия: " + userSurname + '\n' +
                "Возраст: " + userAge + '\n' +
                "Банковский балланс: " + bankAccount;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.userId, o.getUserId());
    }

    @Override
    public int compare(User o1, User o2) {
        return o1.compareTo(o2);
    }
}
