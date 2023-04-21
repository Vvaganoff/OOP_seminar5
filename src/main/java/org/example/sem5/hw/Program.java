package org.example.sem5.hw;

import org.example.sem5.hw.Viewer.UI;

import java.util.Scanner;

//Реализовать систему работы банковского приложения.
//        - Создать класс пользователь и соответсвующие классы
//        - Реализовать операции зачисления средств пользователю на счет и списания(У пользователя должно быть отдельное поле - его балланс)
//        - Реализовать функции добавления и удаления пользователя
public class Program {
    public static void main(String[] args) {
        UI display = new UI();
        Scanner scanner = new Scanner(System.in);
        display.Run();
        display.ShowAllUser();
        System.out.println("Хотите выполнить другое действие? (для выхода введите пустую строку)");
        String conti = scanner.nextLine();
        while (!conti.equals("")){
            display.Run();
            display.ShowAllUser();
            System.out.println("Хотите выполнить другое действие? (для выхода введите пустую строку)");
            conti = scanner.nextLine();
        }
    }
}
