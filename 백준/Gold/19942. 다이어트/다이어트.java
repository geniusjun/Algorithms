import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int sProtein, sFat, sCarbo, sVitamin;
    static Food[] foods;
    static List<Integer> retList;
    static int ret;

    static class Food {
        int protein;
        int fat;
        int carbo;
        int vitamin;
        int price;

        Food(int protein, int fat, int carbo, int vitamin, int price) {
            this.protein = protein;
            this.fat = fat;
            this.carbo = carbo;
            this.vitamin = vitamin;
            this.price = price;
        }
    }

    static void go(int protein, int fat, int carbo, int vitamin, List<Integer> foodList, int price, int here) {
        if (protein >= sProtein && fat >= sFat && carbo >= sCarbo && vitamin >= sVitamin) {
            if (price < ret) {
                ret = price;
                retList = new ArrayList<>(foodList);
                return;
            }
        }

        if (price > ret) {
            return;
        }

        for (int i = here; i < N; i++) {
            int dProtein = protein + foods[i].protein;
            int dFat = fat + foods[i].fat;
            int dCarbo = carbo + foods[i].carbo;
            int dVitamin = vitamin + foods[i].vitamin;
            foodList.add(i);
            int dPrice = price + foods[i].price;
            go(dProtein, dFat, dCarbo, dVitamin, foodList, dPrice, i + 1);
            foodList.remove(foodList.size() - 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        sProtein = Integer.parseInt(st.nextToken());
        sFat = Integer.parseInt(st.nextToken());
        sCarbo = Integer.parseInt(st.nextToken());
        sVitamin = Integer.parseInt(st.nextToken());

        foods = new Food[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer line = new StringTokenizer(bf.readLine());
            int protein = Integer.parseInt(line.nextToken());
            int fat = Integer.parseInt(line.nextToken());
            int carbo = Integer.parseInt(line.nextToken());
            int vitamin = Integer.parseInt(line.nextToken());
            int price = Integer.parseInt(line.nextToken());
            foods[i] = new Food(protein, fat, carbo, vitamin, price);
        }

        ret = Integer.MAX_VALUE;
        List<Integer> foodList = new ArrayList<>();
        retList = new ArrayList<>();
        go(0, 0, 0, 0, foodList, 0, 0);

        if (ret == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ret);
            for (int i = 0; i < retList.size(); i++) {
                System.out.print(retList.get(i) + 1 + " ");
            }
        }

    }
}