package com.company.java.iostream.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOReader {

    private String pathToFile;

    public IOReader(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getText() {

        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder;
        String text = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(pathToFile));
            stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            text = stringBuilder.toString();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                }
            }
        }
        return text;
    }
}
