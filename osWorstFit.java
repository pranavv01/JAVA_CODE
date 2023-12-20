import java.util.Arrays;

public class osWorstFit {
    public static void main(String[] args) {
        int[] partitions = {100, 500, 200, 450, 600};
        int[] requests = {212, 417, 112, 426};
        int[] allocation = new int[requests.length];
        
        Arrays.fill(allocation, -1); // Initialize allocation array with -1 (unallocated)

        // Iterate through each request and find the worst fit partition
        for (int i = 0; i < requests.length; i++) {
            int worstFit = -1;
            for (int j = 0; j < partitions.length; j++) {
                if (partitions[j] >= requests[i]) {
                    if (worstFit == -1 || partitions[j] > partitions[worstFit]) {
                        worstFit = j;
                    }
                }
            }

            if (worstFit != -1) {
                allocation[i] = worstFit;
                partitions[worstFit] -= requests[i];
            }
        }

        // Display the allocation results
        System.out.println("Request Size   Allocated Partition");
        for (int i = 0; i < requests.length; i++) {
            if (allocation[i] != -1) {
                System.out.println(requests[i] + " KB" + "            Partition " + (allocation[i] + 1));
            } else {
                System.out.println(requests[i] + " KB" + "            Not Allocated");
            }
        }
    }
}

