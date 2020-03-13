/*
Fails three tests (one small input test case, two large input test cases), needs to be diagnosed.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class BadHorse {
    public static void main(String[] args) throws IOException {
        Scanner input_file = new Scanner(new File("C:\\Users\\Saksham\\Desktop\\Java\\Test\\src\\com\\company\\input_file.in"));
        FileWriter output_file = new FileWriter("C:\\Users\\Saksham\\Desktop\\Java\\Test\\src\\com\\company\\output_file.out");

        int T = input_file.nextInt();
        for(int case_number = 1; case_number <= T; case_number++) {
            int M = input_file.nextInt();
            HashMap<String, HashSet<String>> hash_map = new HashMap();
            HashSet<String> group_one = new HashSet(), group_two = new HashSet();
            boolean result = true;

            for(int i = 0; i < M; i++) {
                String member_one = input_file.next(), member_two = input_file.next();
                if(!result)
                    continue;

                if(!hash_map.containsKey(member_one))
                    hash_map.put(member_one, new HashSet());
                hash_map.get(member_one).add(member_two);

                if(!hash_map.containsKey(member_two))
                    hash_map.put(member_two, new HashSet());
                hash_map.get(member_two).add(member_one);

                boolean member_one_group_one_entry = true, member_one_group_two_entry = true, member_two_group_one_entry = true, member_two_group_two_entry = true;

                for(String group_one_member: group_one) {
                    if(hash_map.get(member_one).contains(group_one_member))
                        member_one_group_one_entry = false;

                    if(hash_map.get(member_two).contains(group_one_member))
                        member_two_group_one_entry = false;

                    if(!member_one_group_one_entry && !member_two_group_one_entry)
                        break;
                }

                for(String group_two_member: group_two) {
                    if(hash_map.get(member_one).contains(group_two_member)) {
                        member_one_group_two_entry = false;
                    }

                    if(hash_map.get(member_two).contains(group_two_member))
                        member_two_group_two_entry = false;

                    if(!member_one_group_two_entry && !member_two_group_two_entry)
                        break;
                }

                if(member_one_group_one_entry && member_two_group_two_entry) {
                    group_one.add(member_one);
                    group_two.add(member_two);
                } else if(member_one_group_two_entry && member_two_group_one_entry) {
                    group_one.add(member_two);
                    group_two.add(member_one);
                } else
                    result = false;
            }

            if(result)
                output_file.write("Case #" + case_number + ": Yes\n");
            else
                output_file.write("Case #" + case_number + ": No\n");
        }

        output_file.close();
    }
}
