package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<String> listOfLines = new ArrayList<>();
    private static int maxLength = 0;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Input the file path:");
        String filePath = in.nextLine();

        try {
            File file = new File(filePath);
            readFileContents(file);
            printMirror();
        } catch (Exception e) {
            System.out.println("File not found");
        }

    }

    private static void readFileContents(File file) throws FileNotFoundException {
        Scanner fileReader = new Scanner(file);

        while (fileReader.hasNext()) {
            String line = fileReader.nextLine();
            listOfLines.add(line);

            if (line.length() > maxLength) maxLength = line.length();
        }
        
    }
    
    private static void printMirror() {
        for (int i = 0; i < listOfLines.size(); i++) {
            String q = listOfLines.get(i);
            String r = reverseString(q);
            String result = String.format("%-" + maxLength + "s | %" + maxLength + "s", q, r);
            System.out.println(result);
        }
    }

    private static String reverseString(String s) {
        StringBuilder reverse = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            char c;
            switch (s.charAt(i)) {
                case '<' -> c = '>';
                case '>' -> c = '<';
                case '[' -> c = ']';
                case ']' -> c = '[';
                case '{' -> c = '}';
                case '}' -> c = '{';
                case '(' -> c = ')';
                case ')' -> c = '(';
                case '\\' -> c = '/';
                case '/' -> c = '\\';
                default -> {
                    continue;
                }
            }

            reverse.setCharAt(i, c);
        }


        return reverse.reverse().toString();
    }

}