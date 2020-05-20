package kyu6;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Description:
 * Encrypt this!
 *
 * You want to create secret messages which can be deciphered by the Decipher this! kata. Here are the conditions:
 *
 * 1. Your message is a string containing space separated words.
 * 2. You need to encrypt each word in the message using the following rules:
 *      - The first letter needs to be converted to its ASCII code.
 *      - The second letter needs to be switched with the last letter
 * 3. Keepin' it simple: There are no special characters in input.
 *
 * Examples:
 * encryptThis "Hello" == "72olle"
 * encryptThis "good" == "103doo"
 * encryptThis "hello world" == "104olle 119drlo"
 */

public class EncryptThis {

    public static String encryptThis(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        if (text != null && !text.isEmpty()) {
            String[] strings = text.split(" ");
            for (int i = 0; i < strings.length; i++) {
                stringBuilder.append(transform(strings[i]));
                if (i < strings.length - 1) {
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }

    private static String transform(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = string.toCharArray();

        stringBuilder.append((int)chars[0]);

        if (chars.length > 1) {
            char[] substringCharArray = string.substring(1).toCharArray();
            char temp = substringCharArray[0];
            substringCharArray[0] = substringCharArray[substringCharArray.length - 1];
            substringCharArray[substringCharArray.length - 1] = temp;

            stringBuilder.append(substringCharArray);
        }

        return stringBuilder.toString();
    }

    public static String encryptThisBestPractices(String text) {
        return Arrays.stream(text.split(" "))
                .map(string -> string.length() > 2 ?
                        (int)string.charAt(0) + string.substring(string.length() - 1) + string.substring(2, string.length() - 1) + string.substring(1, 2)
                        : string.length() > 1 ? (int)string.charAt(0) + string.substring(1)
                            : string.length() == 1 ? (int)string.charAt(0) + "" : "")
                .collect(Collectors.joining(" "));
    }

}
