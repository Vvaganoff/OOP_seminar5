package org.example.sem5.hw.Presenter;

import org.example.sem5.hw.Models.DataBaseMethods;
import org.example.sem5.hw.Models.User;
import org.example.sem5.hw.Viewer.UI;

import java.util.*;

public class NewUser {
    public void CreateNewUser(){
        DataBaseMethods dbm = new DataBaseMethods();
        List<User> userList = dbm.ReadDB();
        int id = 0;
        Map<Integer, User> mapUser= new HashMap<>();
        for (User user:userList
             ) {
            mapUser.put(user.getUserId(), user);
        }
        while (mapUser.containsKey(id)){
            id++;
        }
        userList.add(InputNewUser(id));
        System.out.println("Желаете ввести ещё клиента? (для отмены введите пустую строку): ");
        Scanner scanner = new Scanner(System.in);
        String strAnswer = scanner.nextLine();
        int i = 0;
        while (!strAnswer.equals("")){
            while (mapUser.containsKey(id)){
                id++;
            }
            userList.add(InputNewUser(id));
            System.out.println("Желаете ввести ещё клиента? (для отмены введите пустую строку): ");
            strAnswer = scanner.nextLine();
        }
        Collections.sort(userList);
        WriteNewUser(userList);
    }

    private User InputNewUser(int id) {
        UI ui = new UI();
        User user = new User();
        user.setUserId(id);
        user.setBankAccount(0);
        ui.InputUserDisplay(user);
        return user;
    }

    private void WriteNewUser(List<User> userList){
        DataBaseMethods dbm = new DataBaseMethods();
        dbm.WriteDB(userList);
    }
}
