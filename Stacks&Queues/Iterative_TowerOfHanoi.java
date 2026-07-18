import java.util.Stack;

public class Iterative_TowerOfHanoi {
    // Array to match stack indices to readable names: 0 -> 'S' (Source), 1 -> 'A' (Auxiliary), 2 -> 'D' (Destination)
    static char[] rod = { 'S', 'A', 'D' };
    
    // Create an array of 3 Stack objects to represent the 3 physical rods
    static Stack<Integer>[] stacks = new Stack[3];

    // Static block to initialize each individual stack inside the array
    static
    {
        for (int i = 0; i < 3; i++) {
            stacks[i] = new Stack<>();
        }
    }

    /**
     * Tries to move the top disk from rod 'a' to rod 'b' legally.
     * If the move violates the rules (putting a larger disk on a smaller one),
     * it automatically reverses the direction and moves from 'b' to 'a'.
     */
    static void moveDisk(int a, int b)
    {
        // Condition for a legal move from 'a' to 'b':
        // 1. Rod 'b' is completely empty, OR
        // 2. Rod 'a' is not empty AND its top disk is smaller than rod 'b's top disk.
        if (stacks[b].isEmpty()
            || (!stacks[a].isEmpty()
                && stacks[a].peek() < stacks[b].peek())) {
            
            // Print the movement details before actually popping the disk
            System.out.println("Move disk "
                               + stacks[a].peek()
                               + " from rod " + rod[a]
                               + " to rod " + rod[b]);
            
            // Execute the physical move: pop from 'a' and push onto 'b'
            stacks[b].push(stacks[a].pop());
        }
        else {
            // If moving 'a -> b' is illegal, the only mathematical legal choice 
            // left is to move the disk in the opposite direction: 'b -> a'
            moveDisk(b, a);
        }
    }

    // Main logic runner for the iterative Tower of Hanoi puzzle
    static void towerOfHanoi(int n)
    {
        System.out.println("Tower of Hanoi for " + n + " disks:");

        // Map initial index configurations: Source = 0, Aux = 1, Destination = 2
        int src = 0, aux = 1, dest = 2;
        
        // Push all disks onto the Source rod (largest disk 'n' goes first to sit at the bottom)
        for (int i = n; i > 0; i--) {
            stacks[src].push(i);
        }

        // Calculate total moves required using bitwise shift: (1 << n) is equal to Math.pow(2, n)
        int totalMoves = (1 << n) - 1;
        
        // Puzzle Golden Rule: If the number of disks is even, 
        // swap the destination and auxiliary rods to maintain proper directional alignment
        if (n % 2 == 0) {
            int temp = aux;
            aux = dest;
            dest = temp;
        }

        // Loop through every single required legal move sequentially
        for (int i = 1; i <= totalMoves; i++) {
            // Every 3rd move (i = 3, 6, 9...), make a legal move between Auxiliary and Destination
            if (i % 3 == 0)
                moveDisk(aux, dest);
            // Every 1st move sequence (i = 1, 4, 7...), make a legal move between Source and Destination
            else if (i % 3 == 1)
                moveDisk(src, dest);
            // Every 2nd move sequence (i = 2, 5, 8...), make a legal move between Source and Auxiliary
            else
                moveDisk(src, aux);
        }
    }

    public static void main(String[] args)
    {
        int n = 3; // Set the total number of disks to solve for
        towerOfHanoi(n);
    }
}