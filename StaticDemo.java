class Counter {
    // Static variable to keep track of the count
    static int count = 0;

    // Constructor to increment the count
    Counter() {
        count++;
    }

    // Static method to get the count
    static int getCount() {
        return count;
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        // Create instances of the Counter class
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        // Call the static method to get the count
        int totalCount = Counter.getCount();

        // Print the value of the static variable
        System.out.println("Total Count: " + totalCount);
    }
}

