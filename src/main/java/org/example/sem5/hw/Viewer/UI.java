package org.example.sem5.hw.Viewer;

import org.example.sem5.hw.Models.DataBaseMethods;
import org.example.sem5.hw.Models.User;
import org.example.sem5.hw.Presenter.BalanceOperations;
import org.example.sem5.hw.Presenter.ChooseUser;
import org.example.sem5.hw.Presenter.NewUser;
import org.example.sem5.hw.Presenter.RemoveUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI implements UserInterface {
    public void Run() {
        WelcomeDisplay();
        String action = ChooseAction();
        if (action.equals("1")) {
            NewUser newUser = new NewUser();
            newUser.CreateNewUser();
            Run();
        } else if (action.equals("2")) {
            RemoveUser removeUser = new RemoveUser();
            removeUser.DeleteUser();
            Run();
        }else if (action.equals("3")){
            User user = new ChooseUser().ChooseClient();
            BallanceDisplay(user);
            Run();
        }else if (action.equals("4")){
            ShowAllUser();
            Run();

        } else {
            System.out.println("Досвидания!");
        }
    }

    @Override
    public void WelcomeDisplay() {
        System.out.println("""
                Мы рады приветствовать вас в нашем банке.
                Прошу вас выбрать действие:
                1 - Создать клиента
                2 - Удалить клиента
                3 - Выбрать клиента
                4 - Показать всех клиентов
                Выход - пустая строка.
                """);
    }

    @Override
    public String ChooseAction() {
        Scanner scanner = new Scanner(System.in);
        String strAction = scanner.nextLine();

        while (!strAction.equals("")) {
            switch (strAction) {
                case "1":
                    System.out.println("""
                            Вы выбрали создание нового пользователя.
                            Подтвердите выбор:
                            1 - Создать пользователя
                            2 - Отказаться и вернуться в меню.""");
                    String strConfirm = scanner.nextLine();
                    while (!(strConfirm.equals("1") || strConfirm.equals("2"))) {
                        System.out.println("Повторите ввод");
                        System.out.println("""
                                Вы выбрали создание нового пользователя.
                                Подтвердите выбор:
                                1 - Создать пользователя
                                2 - Отказаться и вернуться в меню.""");
                        strConfirm = scanner.nextLine();
                    }
                    if (strConfirm.equals("2")) {
                        break;
                    } else {
                        return "1";
                    }

                case "2":
                    System.out.println("""
                            Вы выбрали Удаление пользователя.
                            Подтвердите выбор:
                            1 - Удалить пользователя
                            2 - Отказаться и вернуться в меню.""");
                    strConfirm = scanner.nextLine();
                    while (!(strConfirm.equals("1") || strConfirm.equals("2"))) {
                        System.out.println("Повторите ввод");
                        System.out.println("""
                                Вы выбрали Удаление пользователя.
                                Подтвердите выбор:
                                1 - Удалить пользователя
                                2 - Отказаться и вернуться в меню.""");
                        strConfirm = scanner.nextLine();
                    }
                    if (strConfirm.equals("2")) {
                        break;
                    } else {
                        return "2";
                    }
                case "3":
                    System.out.println("""
                            Вы выбрали Выбрать пользователя.
                            Подтвердите выбор:
                            1 - Выбрать пользователя
                            2 - Отказаться и вернуться в меню.""");
                    strConfirm = scanner.nextLine();
                    while (!(strConfirm.equals("1") || strConfirm.equals("2"))) {
                        System.out.println("Повторите ввод");
                        System.out.println("""
                                Вы выбрали Выбрать пользователя.
                                Подтвердите выбор:
                                1 - Выбрать пользователя
                                2 - Отказаться и вернуться в меню.""");
                        strConfirm = scanner.nextLine();
                    }
                    if (strConfirm.equals("2")) {
                        break;
                    } else {
                        return "3";
                    }
                case "4":
                    System.out.println("""
                            Вы выбрали Показать всех клиентов.
                            Подтвердите выбор:
                            1 - Показать всех клиентов
                            2 - Отказаться и вернуться в меню.""");
                    strConfirm = scanner.nextLine();
                    while (!(strConfirm.equals("1") || strConfirm.equals("2"))) {
                        System.out.println("Повторите ввод");
                        System.out.println("""
                                Вы выбрали Выбрать пользователя.
                                Подтвердите выбор:
                                1 - Показать всех клиентов
                                2 - Отказаться и вернуться в меню.""");
                        strConfirm = scanner.nextLine();
                    }
                    if (strConfirm.equals("2")) {
                        break;
                    } else {
                        return "4";
                    }
            }
            WelcomeDisplay();
            System.out.println("Повторите ввод:");
            strAction = scanner.nextLine();
        }
        return "";
}

    @Override
    public void InputUserDisplay(User user) {
        System.out.println("=====Введите нового клиента=====");
        System.out.println("Введите имя клиента:");
        Scanner scanner = new Scanner(System.in);
        user.setUserName(scanner.nextLine());
        System.out.println("Введите фамилию клиента:");
        user.setUserSurname(scanner.nextLine());
        System.out.println("Введите возраст клиента:");
        user.setUserAge(Integer.parseInt(scanner.nextLine()));
    }

    @Override
    public List<Integer> DeleteUserDisplay(List<User> userList) {
        List<Integer> intIdList = new ArrayList<>();
        System.out.println("====Удаление клиентов====");
        System.out.println("Выберите клиента для удаления (для отмены введите пустую строку): ");

        for (User user : userList
             ) {
            System.out.println(user.getUserId() + " - " + user.getUserSurname() + " "
            + user.getUserName() + ", " + user.getUserAge());
        }
        Scanner scanner = new Scanner(System.in);
        String strChoice = scanner.nextLine();
        while (!strChoice.equals("")) {
            int intId = Integer.parseInt(strChoice);
            if (intId >= 0){
                if (intId< userList.size()){
                    intIdList.add(intId);
                } else {
                    System.out.println("Такого клиента нет в базе.");
                }
            } else {
                System.out.println("Индекс не может быть отрицательным.");
            }
            System.out.println("Хотите удалить другого клиента? (для отмены введите пустую строку)");
            strChoice = scanner.nextLine();
        }
        return intIdList;
    }

    @Override
    public void ShowAllUser() {
       List<User> userList = new DataBaseMethods().ReadDB();
        for (User user:userList
             ) {
            System.out.println("=================");
            System.out.println(user.toString());

        }
        System.out.println("Для продолжения нажмите Enter");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    @Override
    public User ChooseUser(List<User> userList) {
        System.out.println("====Выбрать клиента====");
        System.out.println("Выберите клиента для дальнейших операций (для отмены введите пустую строку): ");

        for (User user : userList
        ) {
            System.out.println(user.getUserId() + " - " + user.getUserSurname() + " "
                    + user.getUserName() + ", " + user.getUserAge());
        }
        Scanner scanner = new Scanner(System.in);
        String strChoice = scanner.nextLine();
        int intId = Integer.parseInt(strChoice);
        while (true){
            if (intId >= 0){
                if (intId< userList.size()){

                    for (User user:userList
                         ) {
                        if (user.getUserId() == intId){
                            return user;
                        }
                    }
                    return  null;
                } else {
                    System.out.println("Такого клиента нет в базе.");
                }
            } else {
                System.out.println("Индекс не может быть отрицательным.");
            }
        }
    }

    @Override
    public void BallanceDisplay(User user) {
        ShowBallance(user);
        System.out.println("""
                Что бы вы хотели сделать?:
                1 - Положить на счет
                2 - Снять со счета
                Для возврата введите пустую строку
                """);
        Scanner scanner = new Scanner(System.in);
        String strChoice = scanner.nextLine();
        while (!(strChoice.equals("1") || strChoice.equals("2") || strChoice.equals(""))) {
            System.out.println("Повторите ввод");
            System.out.println("""
                Что бы вы хотели сделать?:
                1 - Положить на счет
                2 - Снять со счета
                Выход - пустая строка
                """);
            strChoice = scanner.nextLine();
        }
        if (strChoice.equals("2")) {
            System.out.println("Какую сумму вы бы хотели снять?");
            Double moneyToWithdraw = Double.parseDouble(scanner.nextLine());
            BalanceOperations balanceOperation = new BalanceOperations();
            balanceOperation.SetBalance(balanceOperation.MinusBalance(balanceOperation.GetBalance(user),
                    moneyToWithdraw), user);
            BallanceDisplay(user);

        } else if (strChoice.equals("1")) {
            System.out.println("Какую сумму вы бы хотели положить?");
            Double moneyToWithdraw = Double.parseDouble(scanner.nextLine());
            BalanceOperations balanceOperation = new BalanceOperations();
            balanceOperation.SetBalance(balanceOperation.PlusBalance(balanceOperation.GetBalance(user),
                    moneyToWithdraw), user);
            BallanceDisplay(user);
        } else {}

    }

    @Override
    public Double PlusDisplay() {
        System.out.println("Введите сумму к зачислению: ");
        return Double.parseDouble(new Scanner(System.in).nextLine());
    }

    @Override
    public Double MinusDisplay() {
        System.out.println("Введите сумму к снятию: ");
        return Double.parseDouble(new Scanner(System.in).nextLine());
    }

    @Override
    public void ShowBallance(User user) {
        System.out.println("======Банковский счет клиента=====");
        System.out.println("Клиент: " + user.getUserSurname() + " " + user.getUserName() + ", " + user.getUserAge() + "г.");
        System.out.println("Баланс на счету: " + user.getBankAccount());
    }
}
