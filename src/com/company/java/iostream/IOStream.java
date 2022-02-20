package com.company.java.iostream;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOStream {

    static void ioKeyWords(String file) {
        try {

            FileReader reader = new FileReader(file);
            BufferedReader buffR = new BufferedReader(reader);
            StringBuffer buffS = new StringBuffer();
            String str;

            while ((str = buffR.readLine()) != null) {
                buffS.append(str);
            }
            buffR.close();

            FileWriter outFile = new FileWriter("OutputFileKeyWords.txt");
            String stringBuffer;
            int count = 0;

            Pattern p = Pattern.compile("byte|short|int|long|char|float|double|boolean|if|else|switch|case|default|while|do|break|continue|for|try|catch|finally|throw|throws|private|protected|public|import|package|class|interface|extends|implements|static|final|void|abstract|native|new|return|this|super|synchronized|volatile|const|goto|instanceof|enum|assert|transient|strictfp");
            Matcher m = p.matcher(buffS);

            while (m.find()) {
                stringBuffer = m.group(0) + " ";
                outFile.write(stringBuffer);
                count++;
            }

            String words = "\nCount of Key Words: " + count;
            outFile.write(words);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
