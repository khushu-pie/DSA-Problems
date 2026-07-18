public class Gas_Station_Problem {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            // If we run out of gas at the current station, 
            // it means we cannot start from the 'startIndex' up to 'i'.
            if (currentGas < 0) {
                // Reset our starting point to the next station
                startIndex = i + 1;
                // Reset the current tank for the new starting point
                currentGas = 0;
            }
        }

        // If the total gas available is less than the total cost,
        // it's impossible to complete the circular tour.
        if (totalGas < totalCost) {
            return -1;
        }

        return startIndex;
    }
    public static void main(String[] args){
        int gas[]={4,5,7,4};
        int cost[]={6,6,3,5};
        int res=canCompleteCircuit(gas,cost);
        System.out.println("Starting index will be:" + res);
    }
}