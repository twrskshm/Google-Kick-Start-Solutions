import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class RationalNumberTree {
    public static void main(String[] args) throws IOException {
        Scanner input_file = new Scanner(new File("C:\\Users\\Saksham\\Desktop\\Java\\Test\\src\\com\\company\\input_file.in"));
        FileWriter output_file = new FileWriter("C:\\Users\\Saksham\\Desktop\\Java\\Test\\src\\com\\company\\output_file.out");

        int T = input_file.nextInt();

        for(int case_number = 1; case_number <= T; case_number++) {
            if(input_file.nextInt() == 1)
                output_file.write("Case #" + case_number + ": " + find_element(input_file.nextLong()) + "\n");
            else {
                output_file.write("Case #" + case_number + ": " + find_position(input_file.nextLong(), input_file.nextLong()) + "\n");
            }
        }

        output_file.close();
    }

    static Fraction find_element(long position) {
        LinkedList<Fraction> queue = new LinkedList();
        queue.add(new Fraction(1, 1));

        while(position > 1) {
            Fraction fraction = queue.remove();
            long numerator = fraction.numerator, denominator = fraction.denominator;

            queue.add(new Fraction(numerator, numerator + denominator));
            queue.add(new Fraction(numerator + denominator, denominator));
            position--;
        }

        return queue.remove();
    }

    static int find_position(long numerator, long denominator) {
        int result = 1;
        Fraction actual = new Fraction(numerator, denominator);
        LinkedList<Fraction> queue = new LinkedList();
        queue.add(new Fraction(1, 1));

        while(!queue.peek().equals(actual)) {
            Fraction current = queue.remove();
            long n = current.numerator, d = current.denominator;

            queue.add(new Fraction(n, n + d));
            queue.add(new Fraction(n + d, d));
            result++;
        }

        return result;
    }
}

class Fraction {
    public long numerator, denominator;

    public Fraction(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public boolean equals(Fraction fraction) {
        return (numerator == fraction.numerator) && (denominator == fraction.denominator);
    }

    @Override
    public String toString() {
        return numerator + " " + denominator;
    }
}
