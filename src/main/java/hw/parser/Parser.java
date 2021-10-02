package hw.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    private final Converter converter = new Converter();

    public ArrayList<String> parse(File file) {
        ArrayList<String> list = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)
                .useDelimiter("[^а-яА-Я]+")) {
            String line = scanner.nextLine();
            while (scanner.hasNextLine()) {
                list.add(line);
                line = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return converter.toList(list);
    }
}
