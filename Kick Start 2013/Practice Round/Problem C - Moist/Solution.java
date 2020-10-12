/*
Problem
Moist has a hobby -- collecting figure skating trading cards. His card collection has been growing, and it is now too
large to keep in one disorganized pile. Moist needs to sort the cards in alphabetical order, so that he can find the
cards that he wants on short notice whenever it is necessary.

The problem is -- Moist can't actually pick up the cards because they keep sliding out his hands, and the sweat causes
permanent damage. Some of the cards are rather expensive, mind you. To facilitate the sorting, Moist has convinced Dr.
Horrible to build him a sorting robot. However, in his rather horrible style, Dr. Horrible has decided to make the
sorting robot charge Moist a fee of $1 whenever it has to move a trading card during the sorting process.

Moist has figured out that the robot's sorting mechanism is very primitive. It scans the deck of cards from top to
bottom. Whenever it finds a card that is lexicographically smaller than the previous card, it moves that card to its
correct place in the stack above. This operation costs $1, and the robot resumes scanning down towards the bottom of the
deck, moving cards one by one until the entire deck is sorted in lexicographical order from top to bottom.

As wet luck would have it, Moist is almost broke, but keeping his trading cards in order is the only remaining joy in
his miserable life. He needs to know how much it would cost him to use the robot to sort his deck of cards.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each one starts with a line
containing a single integer, N. The next N lines each contain the name of a figure skater, in order from the top of the
deck to the bottom.

Output
For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1) and y is the
number of dollars it would cost Moist to use the robot to sort his deck of trading cards.

Limits
1 ≤ T ≤ 100.
Each name will consist of only letters and the space character.
Each name will contain at most 100 characters.
No name with start or end with a space.
No name will appear more than once in the same test case.
Lexicographically, the space character comes first, then come the upper case letters, then the lower case letters.

Small dataset
1 ≤ N ≤ 10.

Large dataset
1 ≤ N ≤ 100.

Sample

Input
2
2
Oksana Baiul
Michelle Kwan
3
Elvis Stojko
Evgeni Plushenko
Kristi Yamaguchi

Output
Case #1: 1
Case #2: 0
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(final String[] parameters) throws IOException {
        Scanner input = new Scanner(new File("C:\\Users\\Saksham\\Desktop\\Java\\Test\\src\\com\\company\\input_file.in"));
        FileWriter output = new FileWriter("C:\\Users\\Saksham\\Desktop\\Java\\Test\\src\\com\\company\\output_file.out");

        int totalTestCases = Integer.parseInt(input.nextLine());

        for (int caseNumber = 1; caseNumber <= totalTestCases; caseNumber++) {
            int cost = 0;
            String[] cards = new String[Integer.parseInt(input.nextLine())];

            for (int index = 0; index < cards.length; index++) {
                cards[index] = input.nextLine();

                int temporaryIndex = index;

                while (temporaryIndex > 0 && smallerThan(cards[temporaryIndex], cards[temporaryIndex - 1])) {
                    String swapValue = cards[temporaryIndex - 1];
                    cards[temporaryIndex - 1] = cards[temporaryIndex];
                    cards[temporaryIndex--] = swapValue;
                }

                if (temporaryIndex != index)
                    cost++;
            }

            output.write("Case #" + caseNumber + ": " + cost + "\n");
        }

        output.close();
    }

    private static boolean smallerThan(final String stringOne, final String stringTwo) {
        for (int stringOneIndex = 0, stringTwoIndex = 0; stringOneIndex < stringOne.length() && stringTwoIndex < stringTwo.length(); stringOneIndex++, stringTwoIndex++) {
            if (stringOne.charAt(stringOneIndex) > stringTwo.charAt(stringTwoIndex))
                return false;
            else if (stringOne.charAt(stringOneIndex) < stringTwo.charAt(stringTwoIndex))
                return true;
        }

        return stringOne.length() < stringTwo.length();
    }
}