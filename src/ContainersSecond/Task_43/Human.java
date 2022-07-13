package ContainersSecond.Task_43;

public class Human implements Comparable<Human> {
    private final String firstName;
    private final String lastName;
    private final String secondName;

     public Human ( String firstName, String lastName, String secondName){
         this.firstName = firstName;
         this.lastName = lastName;
         this.secondName = secondName;
     }

     public String getFullName(){
         return this.firstName + " "+ this.secondName +" "+  this.lastName;
     }

     public String toString(){
         return getFullName();
     }

    public int compareToIgnoreCase( Human human ) {
        return this.getFullName().compareToIgnoreCase(human.getFullName());
    }

    public static int oldCompareTo(String x, String y) {
        int length = Math.max(x.length(), y.length()) - Math.min(x.length(), y.length());
        if (x.length() > y.length()) {
            for (int i = 0; i <= length - 1; i++) {
                y = y.concat("0");
            }
        }
        if (x.length() < y.length()) {
            for (int i = 0; i <= length - 1; i++) {
                x = x.concat("0");
            }
        }
        char[] charX = x.toCharArray();
        char[] charY = y.toCharArray();
        for (int i = 0; i <= charX.length; i++) {
            if (charX[i] > charY[i]) return 1;
            else if (charX[i] < charY[i]) return -1;
        }
        return 0;
    }

    @Override
    public int compareTo(Human human) {
        return this.getFullName().compareTo(human.getFullName());
    }
}
