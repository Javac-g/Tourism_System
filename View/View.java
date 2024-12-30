package View;

import java.util.Scanner;

public class View {

    private final static Scanner scanner = new Scanner(System.in);

    public static void print_menu(){
        System.out.println(" --- M E N U --- ");
        System.out.println("1 - Add client");
        System.out.println("2 - Add tour");
        System.out.println("3 - Add tour to client");
        System.out.println("4 - Find tours by client");
        System.out.println("5 - Delete order");
        System.out.println("6 - Exit");
    }
    public static String getString (String msg){
        System.out.println(msg);
        return scanner.next();
    }
    public static Integer getNumber (String msg){
        System.out.println(msg);
        return scanner.nextInt();
    }
    public static Boolean getBoolean (String msg){
        System.out.println(msg);
        return scanner.nextBoolean();
    }
}
