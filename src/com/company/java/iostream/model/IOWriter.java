package com.company.java.iostream.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class IOWriter {

    private String pathToFile;
    private Map<String, Integer> map;

    public IOWriter(String pathToFile, Map<String, Integer> map) {
        this.pathToFile = pathToFile;
        this.map = map;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public boolean saveData() {
        File out = new File(pathToFile);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(out, true);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                fileWriter.write(key + " " + value + ";\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
            }
        }
        return true;
    }
}
