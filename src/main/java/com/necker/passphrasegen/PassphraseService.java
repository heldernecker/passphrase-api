package com.necker.passphrasegen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class PassphraseService {
    String path = "src/main/resources/wordlist/eff_short_wordlist_1.txt";

    public String generatePassphrase(int length) {
        String finalPassphrase = "";
        HashMap<Integer, String> words = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String word;
            int count = 0;
            while ((word = reader.readLine()) != null) {
                words.put(count, word.substring(5));
                count++;
            }
            reader.close();

            StringBuilder passphrase = new StringBuilder();
            while (passphrase.length() <= length) {
                int i = new Random().nextInt(count);
                String wordToAdd = words.get(i);
                if (new Random().nextInt(3) % 3 == 0)
                    wordToAdd = wordToAdd.toUpperCase();
                passphrase.append("-" + wordToAdd);
            }

            finalPassphrase = passphrase.substring(1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return finalPassphrase;
    }
}
