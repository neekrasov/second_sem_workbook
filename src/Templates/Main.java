package Templates;


import java.util.Scanner;

public class Main {

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
        L1List<String> response = new L1List<>();
        Node<String> lastApp = null;
        while (true) {

            String action = scanner.nextLine();


            if (action.equals("stop")) {
                break;
            } else if (action.equals("all")) {
                response.print();
            } else {
                String[] action_split = action.split("[ +]+"); // Неогранниченный сплит по пробелу или плюсу
                String firstInstruction = action_split[0].toLowerCase(); // Run, alt
                String secondInstruction = action_split[1].toLowerCase(); // Tab, delete ,applications
                if (firstInstruction.equals("run")) {
                    Node<String> nodeAction = new Node<>(getFullNameWord(action_split));
                    response.append(nodeAction);
                    lastApp = nodeAction;
                    System.out.println(response.getLast().getValue());
                } else if (firstInstruction.equals("alt")) {
                    if (secondInstruction.equals("tab")) {
                        for (int i = 0; i < action_split.length-1; i++) {
                            if (lastApp.next == null) lastApp = response.getFirst();
                            else lastApp = lastApp.next;
                        }
                        System.out.println(lastApp.getValue());
                    } else if (secondInstruction.equals("delete")) {
                        response.remove(response.find(lastApp));
                    }
                } else System.out.println("Такой инструкции не существует");
            }

        }

    }


    public static void main(String[] args) throws Exception {
        activityTracking();
    }

}
