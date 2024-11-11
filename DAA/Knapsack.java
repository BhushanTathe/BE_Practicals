
public class Knapsack {

    public static void Knapsack( double[] profit, double[] weight, double capacity) {
        double[] ratio = new double[profit.length];

        // Calculate profit-to-weight ratios
        for (int i = 0; i < profit.length; i++) {
            ratio[i] = profit[i] / weight[i];
        }

        // Sort by ratio in descending order using selection sort
        for (int i = 0; i < profit.length - 1; i++) {
            int maxidx = i;
            for (int j = i + 1; j < profit.length; j++) {
                if (ratio[j] > ratio[maxidx]) {
                    maxidx = j;
                }
            }

            // Swap ratios
            double temp = ratio[i];
            ratio[i] = ratio[maxidx];
            ratio[maxidx] = temp;

           
            // Swap profit and weight arrays
            double tempProfit = profit[i];
            profit[i] = profit[maxidx];
            profit[maxidx] = tempProfit;

            double tempWeight = weight[i];
            weight[i] = weight[maxidx];
            weight[maxidx] = tempWeight;
        }

        double checkCapacity = 0;
        double maxProfit = 0;

        // Loop through each item based on sorted order and add to knapsack
        for (int i = 0; i < profit.length; i++) {
            if (checkCapacity + weight[i] <= capacity) {
                // If the whole item can be taken
                checkCapacity += weight[i];
                maxProfit += profit[i];
            } else {
                // Take the fraction of the item that fits
                double remainingCapacity = capacity - checkCapacity;
                maxProfit += (remainingCapacity / weight[i]) * profit[i];
                break;
            }
        }

        System.out.println("Maximum Profit: " + maxProfit);
    }

    public static void main(String[] args) {
        double[] profit = {25, 24, 15};
        double[] weight = {18, 15, 10};
        double capacity = 20;

        Knapsack(profit, weight, capacity);
    }
}
