package ru.solrmndr.controller;

import ru.solrmndr.frames.TableModel;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by artem on 31.01.2016.
 */
public class TableDataController {

    private static final String DATA_FILE = TableDataController.class.getClassLoader().getResource("resources/data.txt").getFile();
    private static final String SEPARATOR = ",";

    public static ArrayList<String[]> loadData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE));
        String line;
        ArrayList<String[]> data = new ArrayList<String[]>();
        try {
            while ((line = reader.readLine()) != null) {
                data.add(line.split(SEPARATOR));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        return data;
    }

    public void saveData() {
        BufferedWriter writer = null;
        String s = "";
        TableModel.getSavedData(s);
        try {
            writer = new BufferedWriter(new FileWriter(DATA_FILE));
            writer.write(s);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

