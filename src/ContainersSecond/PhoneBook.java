package ContainersSecond;

import java.util.HashMap;

public class PhoneBook extends HashMap<String, String> {
    //Напишите программу, реализующую телефонный справочник для абонентов. Предусмотрите возможность
    //добавления новых абонентов , удаления абонентов, поиска фамилии абонента по номеру его телефона

    public PhoneBook() {
        super();
    }

    public String search(String phoneNumber) {
        return this.get(phoneNumber);
    }

    public void addSub(String phoneNumber, String name) {
        this.put(phoneNumber, name);
    }

    public void delete(String phoneNumber) {
        this.remove(phoneNumber);
    }

}
