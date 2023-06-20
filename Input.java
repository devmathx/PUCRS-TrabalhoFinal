import java.util.Scanner;

public class Input{

    public static Scanner in = new Scanner(System.in);

    public static int lerInt(String text){
        System.out.print(text);
        int value = 0;

        try{
            value = in.nextInt();
        }
        catch(Error e){
            System.out.println("Erro na entrada de dados!");
            value = -1;
        }

        return value;
    }

    public static String lerString(String text){
        System.out.print(text);
        String value = "";

        try{
            value = in.nextLine();
        }
        catch(Error e){
            System.out.println("Erro na entrada de dados!");
            value = "";
        }

        return value;
    }

    public static boolean clearBuffer(){
        in.nextLine();
        return true;
    }
}