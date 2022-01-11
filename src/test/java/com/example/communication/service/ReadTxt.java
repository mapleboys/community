package com.example.communication.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadTxt {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("s", "yt");

        Integer s1 = 14;
        Integer m = 5;
        Integer x = s1/m + 1;
        File checkPassword = new File("checkPassword");
        FileInputStream fileInputStream = new FileInputStream(checkPassword);
        Scanner scanner = new Scanner(fileInputStream, "UTF-8");
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if ("".equals(s)) {
                break;
            }
            ArrayList<String> strings = new ArrayList<>();
            String[] split = s.split("\\|");
            if (split.length > 1) {
                boolean isOk = check(split[1]);
                if (! isOk == true) {
                    System.out.println(split[0] + ", " + split[1] + "\n");
                }
            }
        }
    }

    private static boolean check(String s) {
        if(s.length() < 8){
            return false;
        }
        char[] chars = s.toCharArray();
        boolean isNum = false;
        boolean isABC = false;
        boolean isSpecial = false;
        for (char aChar : chars) {
            if ((aChar >= 65 && aChar <= 90) || (aChar >= 97 && aChar <= 122)) {
                isABC = true;
            }
        }
        return true;
    }
}
