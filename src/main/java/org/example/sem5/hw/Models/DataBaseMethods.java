package org.example.sem5.hw.Models;

import org.example.sem5.hw.Config;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DataBaseMethods implements DataBase{
    @Override
    public List<User> ReadDB(){
        try {
            FileReader fileReader = new FileReader(Config.pathDb);
            BufferedReader reader = new BufferedReader(fileReader);
            String strLine = reader.readLine();
            List<User> userList = new ArrayList<>();
            while (strLine != null){
                String[] strList = strLine.split(",");
                userList.add(new User(Integer.parseInt(strList[0]), strList[1], strList[2], Integer.parseInt(strList[3]), Double.parseDouble(strList[4])));
                strLine = reader.readLine();
            }
            reader.close();
            return userList;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void WriteDB(List<User> users){
        try {
            FileWriter fileWriter = new FileWriter(Config.pathDb);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            StringBuilder strToWrite = new StringBuilder();
            for (User user:users
            ) {
                strToWrite.append(user.getUserId() + "," +
                        user.getUserName() + "," +
                        user.getUserSurname()+ "," +
                        user.getUserAge()+ "," +
                        user.getBankAccount() + System.getProperty("line.separator"));
            }
            writer.write(strToWrite.toString());
            writer.flush();
            System.out.println("Запись осуществлена успешно.");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
