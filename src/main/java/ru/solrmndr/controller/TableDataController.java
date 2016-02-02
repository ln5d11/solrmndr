package ru.solrmndr.controller;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by artem on 31.01.2016.
 */
public class TableDataController {

    private static final String DATA_FILE = TableDataController.class.getClassLoader().getResource("resources/data.txt").getFile();

    private static final String SEPORATOR = ",";


    public static ArrayList<String[]> loadData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE));
        String line;
        ArrayList<String[]> data = new ArrayList<String[]>();
        try {

                data.add(line.split(SEPARATOR));
=======
                data.add(line.split(SEPORATOR));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
<<<<<<< HEAD
            reader.
        }
        return data;
    }
}
=======
            reader.close();
        }
        return data;
    }
}
>>>>>>> 245a947b5f8cd0b47e5f2419f045607af9973cc8
