import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line1 = new StringTokenizer(bf.readLine());

        HashMap<Character, Integer> needMap = new HashMap<>();
        HashMap<Character, Integer> checkMap = new HashMap<>();
        int S = Integer.parseInt(line1.nextToken());
        int P = Integer.parseInt(line1.nextToken());

        String s = bf.readLine();
        StringTokenizer line3 = new StringTokenizer(bf.readLine());
        needMap.put('A', Integer.parseInt(line3.nextToken()));
        needMap.put('C', Integer.parseInt(line3.nextToken()));
        needMap.put('G', Integer.parseInt(line3.nextToken()));
        needMap.put('T', Integer.parseInt(line3.nextToken()));
        int cnt = 0;
        for (int i = 0; i < P; i++) {
            checkMap.put(s.charAt(i), checkMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (checkMap.getOrDefault('A', 0) >= needMap.getOrDefault('A', 0) &&
                checkMap.getOrDefault('C', 0) >= needMap.getOrDefault('C', 0) &&
                checkMap.getOrDefault('G', 0) >= needMap.getOrDefault('G', 0) &&
                checkMap.getOrDefault('T', 0) >= needMap.getOrDefault('T', 0)) {
            cnt++;
        }

        for (int i = 0; i < S - P; i++) {
            boolean isSatisfy = true;
            checkMap.put(s.charAt(i), checkMap.getOrDefault(s.charAt(i), 0) - 1);
            checkMap.put(s.charAt(P + i), checkMap.getOrDefault(s.charAt(P + i), 0) + 1);
            if (checkMap.getOrDefault('A', 0) < needMap.getOrDefault('A', 0)) {
                isSatisfy = false;
            }
            if (checkMap.getOrDefault('C', 0) < needMap.getOrDefault('C', 0)) {
                isSatisfy = false;
            }
            if (checkMap.getOrDefault('G', 0) < needMap.getOrDefault('G', 0)) {
                isSatisfy = false;
            }
            if (checkMap.getOrDefault('T', 0) < needMap.getOrDefault('T', 0)) {
                isSatisfy = false;
            }
            if (isSatisfy) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

