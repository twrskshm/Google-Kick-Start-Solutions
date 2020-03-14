import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) throws IOException {
        Scanner input_file = new Scanner(new File("C:\\Users\\Saksham\\Desktop\\Java\\Test\\src\\com\\company\\input_file.in"));
        FileWriter output_file = new FileWriter("C:\\Users\\Saksham\\Desktop\\Java\\Test\\src\\com\\company\\output_file.out");

        int T = input_file.nextInt();

        for(int case_number = 1; case_number <= T; case_number++) {
            int[] book_values = new int[input_file.nextInt()];
            int[] temp = new int[book_values.length];

            for(int i = 0; i < book_values.length; i++) {
                book_values[i] = input_file.nextInt();
                temp[i] = book_values[i];

                int j = i;
                while(j > 0 && temp[j - 1] > temp[j]) {
                    int swap_element = temp[j - 1];
                    temp[j - 1] = temp[j];
                    temp[j--] = swap_element;
                }
            }

            int odd_index = 0, even_index = book_values.length - 1;
            for(int i = 0; i < book_values.length; i++) {
                if(book_values[i] % 2 != 0) {
                    int[] result = get_next_odd(temp, odd_index);
                    book_values[i] = result[0];
                    odd_index = result[1] + 1;
                } else {
                    int[] result = get_next_even(temp, even_index);
                    book_values[i] = result[0];
                    even_index = result[1] - 1;
                }
            }

            output_file.write("Case #" + case_number + ": ");
            for(int i = 0; i < book_values.length; i++)
                output_file.write(book_values[i] + " ");
            output_file.write("\n");
        }

        output_file.close();
    }

    public static int[] get_next_odd(int[] temp, int odd_index) {
        for(int i = odd_index; i < temp.length; i++)
            if(temp[i] % 2 != 0)
                return new int[] {temp[i], i};

        return new int[] {-1, -1};
    }

    public static int[] get_next_even(int[] temp, int even_index) {
        for(int i = even_index; i >= 0; i--)
            if(temp[i] % 2 == 0)
                return new int[] {temp[i], i};

        return new int[] {-1, -1};
    }
}
