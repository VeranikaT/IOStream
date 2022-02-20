package com.company.java.iostream;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileToRead {

    public class Calculator {

        private String str;

        public Calculator(String str) {
            this.str = str;
        }

        public String getNewString() {
            Pattern p = Pattern.compile("^(\\d+)\\s(\\d+|.*\\d)\\s(.*)");
            Matcher m = p.matcher(str);

            if (m.find()) {

                String operator = m.group(3);
                double y = Double.valueOf(m.group(2));
                int x = Integer.valueOf(m.group(1));
                double result = 0;

                switch (operator) {
                    case ("+"):
                        result = x + y;
                        break;
                    case ("-"):
                        result = x - y;
                        break;
                }

                str = x + m.group(3) + y + "=" + result + "\n";
            }
            return str;
        }
    }

    public static boolean main(String[] args) {
        String str = "string";

        System.out.println(str);

        return true;
    }
}
