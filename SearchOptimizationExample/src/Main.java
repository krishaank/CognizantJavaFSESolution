import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create an array of products
        Product[] products = {
            new Product(105, "Laptop", "Electronics"),
            new Product(101, "Smartphone", "Electronics"),
            new Product(108, "Desk Chair", "Furniture"),
            new Product(102, "Coffee Maker", "Appliances"),
            new Product(110, "Headphones", "Electronics")
        };

        int searchTarget = 108;

        System.out.println("--- Linear Search ---");
        // Linear search does not require a sorted array
        Product foundLinear = SearchAlgorithms.linearSearch(products, searchTarget);
        if (foundLinear != null) {
            System.out.println("Found (Linear): " + foundLinear);
        } else {
            System.out.println("Product ID " + searchTarget + " not found.");
        }

        System.out.println("\n--- Binary Search ---");
        // Binary search requires the array to be sorted by the search key
        Arrays.sort(products);
        System.out.println("Array sorted by Product ID.");
        
        Product foundBinary = SearchAlgorithms.binarySearch(products, searchTarget);
        if (foundBinary != null) {
            System.out.println("Found (Binary): " + foundBinary);
        } else {
            System.out.println("Product ID " + searchTarget + " not found.");
        }
    }
}
