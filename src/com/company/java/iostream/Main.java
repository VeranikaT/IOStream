package com.company.java.iostream;

import com.company.java.iostream.model.IOLogic;
import com.company.java.iostream.model.IOReader;
import com.company.java.iostream.model.IOWriter;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        IOReader ioReader = new IOReader("resources/file.java");
        String text = ioReader.getText();
        IOLogic ioLogic = new IOLogic();
        Map <String, Integer> map = ioLogic.count(text);

        IOWriter ioWriter = new IOWriter("resources/output.txt", map);
        ioWriter.saveData();
    }
}
