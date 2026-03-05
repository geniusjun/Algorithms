import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<String>[] adjList;
    static Set<Integer> ageSet;
    static List<Integer> ages;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        adjList = new ArrayList[201];
        ageSet = new HashSet<>();
        ages = new ArrayList<>();
        for (int i = 0; i < 201; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            adjList[age].add(name);
            if (!ageSet.contains(age)) {
                ages.add(age);
            }
            ageSet.add(age);
        }

        Collections.sort(ages);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ages.size(); i++) {
            for (int j = 0; j < adjList[ages.get(i)].size(); j++) {
                sb.append(ages.get(i)).append(" ").append(adjList[ages.get(i)].get(j)).append("\n");
            }
        }

        System.out.println(sb);
    }
}