import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Moist {
    public static void main(String[] args) throws IOException {
        Scanner input_file = new Scanner(new File("C:\\Users\\Saksham\\Desktop\\Java\\Test\\src\\com\\company\\input_file.in"));
        FileWriter output_file = new FileWriter("C:\\Users\\Saksham\\Desktop\\Java\\Test\\src\\com\\company\\output_file.out");

        int T = input_file.nextInt();

        for(int case_number = 1; case_number <= T; case_number++) {
            String[] cards = new String[input_file.nextInt()];
            input_file.nextLine();

            for(int i = 0; i < cards.length; i++)
                cards[i] = input_file.nextLine();

            int count = 0;

            for(int i = 1; i < cards.length; i++) {
                int j = i;

                if(less_than(cards[j - 1], cards[j]))
                    count++;

                while(j > 0 && less_than(cards[j - 1], cards[j])) {
                    String temp = cards[j - 1];
                    cards[j - 1] = cards[j];
                    cards[j--] = temp;
                }
            }

            output_file.write("Case #" + case_number + ": " + count + "\n");
        }

        output_file.close();
    }

    public static boolean less_than(String string_one, String string_two) {
        for(int i = 0, j = 0; i < string_one.length() && j < string_two.length(); i++, j++) {
            if(string_one.charAt(i) > string_two.charAt(j))
                return true;
            else if(string_two.charAt(j) > string_one.charAt(i))
                return false;
        }

        return string_one.length() > string_two.length();
    }
}