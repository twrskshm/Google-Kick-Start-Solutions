import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ReadPhoneNumber {
    public static void main(String[] args) throws IOException {
        Scanner input_file = new Scanner(new File("C:\\Users\\Saksham\\Desktop\\Java\\Test\\src\\com\\company\\input_file.in"));
        FileWriter output_file = new FileWriter("C:\\Users\\Saksham\\Desktop\\Java\\Test\\src\\com\\company\\output_file.out");

        HashMap<Integer, String> count = new HashMap<>();
        count.put(2, "double");
        count.put(3, "triple");
        count.put(4, "quadruple");
        count.put(5, "quintuple");
        count.put(6, "sextuple");
        count.put(7, "septuple");
        count.put(8, "octuple");
        count.put(9, "nonuple");
        count.put(10, "decuple");
        HashMap<Character, String> number_to_word = new HashMap<>();
        number_to_word.put('0', "zero");
        number_to_word.put('1', "one");
        number_to_word.put('2', "two");
        number_to_word.put('3', "three");
        number_to_word.put('4', "four");
        number_to_word.put('5', "five");
        number_to_word.put('6', "six");
        number_to_word.put('7', "seven");
        number_to_word.put('8', "eight");
        number_to_word.put('9', "nine");

        int T = input_file.nextInt();

        for(int case_number = 1; case_number <= T; case_number++) {
            String number = input_file.next(), result = "";
            String[] partitions = input_file.next().split("-");
            int index = 0;

            for(int i = 0; i < partitions.length; i++) {
                int partition = Integer.parseInt(partitions[i]), counter = 1;

                for(int j = 0; j < partition - 1; j++) {
                    if(number.charAt(index + j) != number.charAt(index + j + 1)) {
                        if (counter == 1)
                            result += number_to_word.get(number.charAt(index + j)) + " ";
                        else {
                            result += count.get(counter) + " " + number_to_word.get(number.charAt(index + j)) + " ";
                            counter = 1;
                        }
                    } else
                        counter++;
                }

                if(counter == 1)
                    result += number_to_word.get(number.charAt(index + partition - 1)) + " ";
                else
                    result += count.get(counter) + " " + number_to_word.get(number.charAt(index + partition - 1)) + " ";

                index += partition;
            }

            output_file.write("Case #" + case_number + ": " + result + "\n");
        }

        output_file.close();
    }
}