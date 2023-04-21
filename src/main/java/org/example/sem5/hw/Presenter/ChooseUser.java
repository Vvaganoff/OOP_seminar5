package org.example.sem5.hw.Presenter;

import org.example.sem5.hw.Models.DataBaseMethods;
import org.example.sem5.hw.Models.User;
import org.example.sem5.hw.Viewer.UI;

import java.util.List;

public class ChooseUser {
    public User ChooseClient (){
        UI ui = new UI();
        DataBaseMethods dbm = new DataBaseMethods();
        List<User> userList = dbm.ReadDB();
        return ui.ChooseUser(userList);
    }


}
