package Task_42;

import java.util.LinkedList;
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

    public static void activityTracking() throws Exception {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> response = new LinkedList<>();
        String lastApp = null;
        int lastIndex = 0;

        while (true) {

            String action = scanner.nextLine();


            if (action.equals("stop")) {
                break;
            } else {
                try {
                    String[] action_split = action.split("[ +]+"); // Неогранниченный сплит по пробелу или плюсу
                    String firstInstruction = action_split[0].toLowerCase(); // Run, alt
                    String secondInstruction = action_split[1].toLowerCase(); // Tab, delete ,applications


                    if (firstInstruction.equals("run")) {
                        String nodeAction = getFullNameWord(action_split);
                        response.add(nodeAction);
                        lastApp = nodeAction;
                        lastIndex = response.size() - 1;
                        System.out.println(response.getLast());
                    } else if (firstInstruction.equals("alt")) {
                        if (secondInstruction.equals("tab")) {
                            for (int i = 0; i < action_split.length - 1; i++) {
                                if (lastIndex == response.size() - 1) lastIndex = 0;
                                else lastIndex++;
                            }
                            lastApp = response.get(lastIndex);
                            System.out.println(lastApp);
                        } else if (secondInstruction.equals("delete")) {
                            response.remove(lastApp);
                        }
                    } else System.out.println("Такой инструкции не существует");
                } catch (Exception ignored){
                    System.out.println("Комманда некорректна");
                }
            }

        }

    }

    public static void main(String[] args) throws Exception {
        activityTracking();
    }
}
