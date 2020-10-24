package Map.Medium_729;

public class Main {
    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20)); // returns true
        System.out.println(calendar.book(15, 25)); // returns false
        System.out.println(calendar.book(20, 30)); // returns true
    }
}
