package ContainersSecond;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class First {
    public static void main(String[] args) throws IOException {

        //Проведите лексикографический анализ текста устава Московского Политеха: получите данные о том, какие слова
        // в нем встречаются и в каком количестве. Сохраните результаты в файле в порядке убывания частотности слов.

        FileReader reader = new FileReader("files/charter");
        FileWriter writer = new FileWriter("files/charter_out");
        Scanner scanner = new Scanner(reader);
        HashSet<String> hashSet = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        while (scanner.hasNextLine()) {
            String[] splitLine = scanner.nextLine().split("[ ,.—]+");
            for (String word : splitLine) hashSet.add(word.toLowerCase());
            for (String word : hashSet) {
                int countWord = 0;
                for (String s : splitLine) {
                    if (s.equals(word)) {
                        countWord++;
                    }
                    hashMap.put(word, countWord);
                }
            }
        }
//        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet(); // return Set содержащий записи Map
        ArrayList<Map.Entry<String, Integer>> items = new ArrayList<>(hashMap.entrySet());

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < items.size(); i++) {
                Map.Entry<String, Integer> right = items.get(i);
                Map.Entry<String, Integer> left = items.get(i - 1);
                if (right.getValue()<left.getValue()) {
                    Collections.swap(items, i, i - 1);
                    isSorted = false;
                }
            }
        }

        for (Map.Entry<String, Integer> item: items){
            writer.write(item.getKey() + ": " + item.getValue()+"\n");
        }
        reader.close();
        writer.close();
    }
}
