import java.util.Arrays;

public class FirstFit {
 public static void main(String[] args) {
 int[] partitions = {10,4,20,18,7,9,12,15};
 int[] requests = {12,10,9};
 int[] allocation = new int[requests.length];

 Arrays.fill(allocation, -1);
 for (int i = 0; i < requests.length; i++) {
 for (int j = 0; j < partitions.length; j++) {
 if (partitions[j] >= requests[i]) {
 allocation[i] = j;
 partitions[j] -= requests[i];
 break; 
 }
 }
 }
 
 System.out.println("Request Size Allocated Partition");
 for (int i = 0; i < requests.length; i++) {
 if (allocation[i] != -1) {
 System.out.println(requests[i] + " MB" + "    Partition " + (allocation[i] + 1));
 } else {
 System.out.println(requests[i] + " MB" + "    Not Allocated");
 }
 }
 }
}
