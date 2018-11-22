package code.Pt3;

import java.util.Scanner;

/**
 * @program: JalrAglsHome
 * @description: Analysis no.3 assignment in algorithm.
 * <p>
 * Created by Jalr on 2018/11/17.
 */
class LvXingGuiHua {

    private static double totalDist, capacity, distPerLiter, startPrice;

    private static int n;

    private static double maxDriveDist, cost;
    private static boolean canReach;
    private static double MAX = 999999.99;

    private static double[] dist,price;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            totalDist = input.nextDouble();
            capacity = input.nextDouble();
            distPerLiter = input.nextDouble();
            startPrice = input.nextDouble();
            n = input.nextInt();

            dist = new double[n+2];
            price = new double[n+2];

            //始点
            dist[0] = 0;
            price[0] = startPrice;

            for(int i=1; i<=n; i++){
                dist[i] = input.nextDouble();
                price[i] = input.nextDouble();
            }

            //终点
            dist[n+1] = totalDist;
            price[n+1] = 0;

            maxDriveDist = capacity * distPerLiter;
            cost = 0.0;
            canReach = true;

            for (int i=1; i<n+2; i++)
                if(dist[i]-dist[i-1] > maxDriveDist)
                    canReach = false;

            if (!canReach) {
                System.out.println("No Solution!");
            } else {
                driving();
                System.out.println(String.format("%.2f",cost));
            }
        }
    }


    private static int minPriceStation(int currentStation) {
        double minPrice = MAX;
        int nextStation = currentStation + 1;

        for (int i=currentStation+1; i <=n+1 && (dist[i]-dist[currentStation])<=maxDriveDist; i++) {
            if (price[i] < price[currentStation]) {
                nextStation = i;
                break;
            }

            if (price[i] < minPrice) {
                minPrice = price[i];
                nextStation = i;
            }
        }

        return nextStation;
    }

    private static void driving() {

        double rest = 0.0;
        double driveDist;
        double tmpCost;
        int currentStation = 0;
        int nextStation;

        while (currentStation <= n) {
            nextStation = minPriceStation(currentStation);
            driveDist = dist[nextStation] - dist[currentStation];
            if (price[nextStation] < price[currentStation]) {
                tmpCost = (driveDist / distPerLiter - rest) * price[currentStation];
                cost += tmpCost;
                rest = 0.0;
            } else {
                tmpCost = (capacity - rest) * price[currentStation];
                rest = capacity - driveDist / distPerLiter;
                cost += tmpCost;
            }
            currentStation = nextStation;
        }

    }
}