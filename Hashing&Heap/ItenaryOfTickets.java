/*Given a list of tickets, find the itinerary in order using the given list.

Note: It may be assumed that the input list of tickets is not cyclic and there is one ticket from every city except the final destination.

Examples:

Input: "Chennai" -> "Bangalore"
            "Bombay" -> "Delhi"
             "Goa"    -> "Chennai"
             "Delhi"  -> "Goa"
Output: Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Bangalore
*/
import java.util.HashMap;
import java.util.Map;

public class ItenaryOfTickets {

    public static void printItinerary(Map<String, String> tickets) {
        // Step 1: Create a reverse map (Destination -> Source) to find the starting point
        Map<String, String> reverseMap = new HashMap<>();
        for (Map.Entry<String, String> entry : tickets.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        // Step 2: Find the starting city.
        // The starting city is the source city that is NOT present as a destination in reverseMap.
        String startCity = null;
        for (String src : tickets.keySet()) {
            if (!reverseMap.containsKey(src)) {
                startCity = src;
                break;
            }
        }

        // Base check: If no starting city was found (e.g., empty input)
        if (startCity == null) {
            System.out.println("Invalid Input: Cyclic or missing itinerary");
            return;
        }

        // Step 3: Traverse from the starting city to build and print the itinerary
        String currentCity = startCity;
        boolean firstPair = true;
        
        while (tickets.containsKey(currentCity)) {
            String nextCity = tickets.get(currentCity);
            
            // Format output as "Source->Destination"
            if (!firstPair) {
                System.out.print(", ");
            }
            System.out.print(currentCity + "->" + nextCity);
            firstPair = false;

            // Move to the next city in the chain
            currentCity = nextCity;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Input tickets map: Source -> Destination
        Map<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bangalore");
        tickets.put("Bombay", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        System.out.println("Reconstructed Itinerary:");
        printItinerary(tickets);
    }
}