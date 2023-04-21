package org.example.sem5.hw.Presenter;

import org.example.sem5.hw.Models.DataBaseMethods;
import org.example.sem5.hw.Models.User;
import org.example.sem5.hw.Viewer.UI;

import java.util.List;

public class RemoveUser {
    public void DeleteUser() {
        UI ui = new UI();
        DataBaseMethods dbm = new DataBaseMethods();
        List<User> userList = dbm.ReadDB();
        List<Integer> intIdList = ui.DeleteUserDisplay(userList);

        for (int id : intIdList){
            userList.removeIf(user -> user.getUserId() == id);
        }
        dbm.WriteDB(userList);
    }
}
