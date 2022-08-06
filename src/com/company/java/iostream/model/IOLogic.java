package com.company.java.iostream.model;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOLogic {

    private static final Pattern pattern = Pattern.compile("byte|short|int|long|char|float|double|boolean|if|else|switch|case|default|while|do|break|continue|for|try|catch|finally|throw|throws|private|protected|public|import|package|class|interface|extends|implements|static|final|void|abstract|native|new|return|this|super|synchronized|volatile|const|goto|instanceof|enum|assert|transient|strictfp");

    public Map <String, Integer> count(String text) {
		Map <String, Integer> map = new HashMap<>();
        Matcher m = pattern.matcher(text);
        String buffer;
        while (m.find()) {
            buffer = m.group(0);
            if (map.containsKey(buffer)){
                Integer value = map.get(buffer);
                map.replace(buffer, value++);
            }else {
                map.put(buffer, 1);
            }
        }
        return map;
    }
}
