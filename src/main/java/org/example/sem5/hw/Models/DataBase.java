package org.example.sem5.hw.Models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public interface DataBase {
    List<User> ReadDB() throws FileNotFoundException;
    void  WriteDB (List<User> objects) throws IOException;
}
