import java.util.Scanner;

public class FinnishVocabTeacherCLI {
    
    private static String [] menuOptions = {"Save and Exit", "Exit without Saving", "Do daily practice", "Add word", "Do one random word",
                                            ""};
    
    public FinnishVocabTeacherCLI() {
        //
    }

    public static void start()
    {
        println("\n---- Welcome to Finnish Vocab Teacher ----\n");

        Scanner in = new Scanner(System.in);
        String s = "";

        while ("0".equals(s) == false)
        {
            print("\nMAIN MENU\n");
            for (int i = 0; i < menuOptions.length; i++) {
                String line = Integer.toString(i) + ") " + menuOptions[i];
                println(line);
            }
            print("> ");

            s = in.nextLine();
            if ("1".equals(s)) {
                //

            } else if ("2".equals(s)) {
                println("Your selection was 2\n");
                
            } else if ("3".equals(s)) {
                //
                
            } else if ("4".equals(s)) {
                //
                
            }
        }
    }

    public static void println() { System.out.println(); }
    public static void println(String s) { System.out.println(s); }
    public static void print(String s) { System.out.print(s); }
}
