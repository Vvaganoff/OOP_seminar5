package org.example.sem5.hw.Viewer;

import org.example.sem5.hw.Models.User;

import java.util.List;

public interface UserInterface {
    void WelcomeDisplay();

    String ChooseAction();
    void InputUserDisplay(User user);
    List<Integer>  DeleteUserDisplay(List<User> userList);
    void ShowAllUser();
    User ChooseUser(List<User> userList);
    void BallanceDisplay(User user);
    Double PlusDisplay();
    Double MinusDisplay();
    void ShowBallance(User user);
}
