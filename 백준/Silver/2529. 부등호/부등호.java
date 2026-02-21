import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static List<String> list;
    static long K;
    static String mx;
    static String mn;

    static void go(long num, int idx, List<String> nums, Set<Integer> set) {
        if (nums.size() == K + 1) {
            StringBuilder find = new StringBuilder();
            for (int i = 0; i < nums.size(); i++) {
                find.append(nums.get(i));
            }
            String findString = String.valueOf(find);
            if (mx.equals("") && mn.equals("")) {// 맨 처음에
                mx = findString;
                mn = findString;
            } else {
                if (findString.compareTo(mx) > 0) {
                    mx = findString;
                }
                if (findString.compareTo(mn) < 0) {
                    mn = findString;
                }
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!set.contains(i)) {
                if (canExist(Integer.parseInt(nums.get(idx)), i, idx)) {
                    nums.add(String.valueOf(i));
                    set.add(i);
                    go(i, idx + 1, nums, set);
                    nums.remove(nums.size() - 1);
                    set.remove(i);
                }
            }
        }

    }

    static boolean canExist(int beforeNum, int afterNum, int idx) {
        if (list.get(idx).equals(">")) {
            if (beforeNum > afterNum) {
                return true;
            }
        } else {
            if (beforeNum < afterNum) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(bf.readLine());
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < K; i++) {
            list.add(st.nextToken());
        }

        mx = "";
        mn = "";
        for (int i = 0; i < 10; i++) {
            List<String> nums = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            nums.add(String.valueOf(i));
            set.add(i);
            go(i, 0, nums, set);
        }

        System.out.println(mx);
        System.out.println(mn);
    }
}