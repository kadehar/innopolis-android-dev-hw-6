package hw.parser;

import java.util.ArrayList;
import java.util.Arrays;

public class Converter {
    public ArrayList<String> toList(ArrayList<String> list) {
        ArrayList<String> words = new ArrayList<>();
        list.forEach(str -> {
            words.addAll(Arrays.asList(str.split("[^а-яА-Я]+")));
        });
        return words;
    }
}
