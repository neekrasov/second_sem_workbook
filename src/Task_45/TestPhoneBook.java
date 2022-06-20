package Task_45;

import java.io.IOException;

public class TestPhoneBook {
    public static void main(String[] args) throws IOException {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addSub("+79999999999", "Андрей");
        phoneBook.addSub("+79999999998", "Евгений");
        phoneBook.addSub("+79999999996", "Михаил");

        System.out.println(phoneBook);

        phoneBook.delete("+79999999999");
        System.out.println(phoneBook);

        System.out.println("search - >" + phoneBook.search("+79999999996"));


    }
}
