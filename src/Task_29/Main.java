package Task_29;

import java.util.Scanner;

public class Main {

    // Достать полное имя приложения
    public static String getFullNameWord(String[] words) {
        String app = "";
        if (words.length > 2) {
            for (int i = 1; i < words.length; i++) {
                app += " " + words[i];
            }
            return app.strip();
        } else {
            return words[1];
        }

    }

    public static void activityTracking() {
        Scanner scanner = new Scanner(System.in);
        L1List<String> response = new L1List<>();

        while (true) {
            String action = scanner.nextLine();
            String lastAction = null;

            if (action.equals("stop")) {
                break;
            } else if (action.equals("") || action.equals(" ")) {
                System.out.println("Введите команду");
            } else {
                try {
                    String[] action_split = action.split("[ +]+"); // Неогранниченный сплит по пробелу или плюсу
                    String firstInstruction = action_split[0].toLowerCase(); // Run, alt
                    String secondInstruction = action_split[1].toLowerCase(); // Tab, delete ,applications
                    if (firstInstruction.equals("alt")) {
                        lastAction = firstInstruction;
                        if (secondInstruction.equals("tab")) {
                            lastAction = secondInstruction;
                            for (int i = 0; i < action_split.length - 1; i++) {
                                response.forward();
                                if (response.isEnd()) response.toFront();
                            }
                        } else if (secondInstruction.equals("delete")) {
                            lastAction = secondInstruction;
                            response.erase();
                        }
                    } else if (firstInstruction.equals("run")) {
                        lastAction = firstInstruction;
                        response.insert(getFullNameWord(action_split));
                    } else System.out.println("Такой операции не существует.");
                    if (lastAction.equals("delete")) {
                        response.erase();
                    } else {
                        System.out.println(response.after());
                    }
                } catch (Exception ignored) {
                    System.out.println("Введите подходящее под условие команду.");
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        activityTracking();

    }


}
