import java.util.*;
public class Main {
  
//  Question --1
    public static boolean isPrime(int n) {
      if (n <= 1)
         return false;
      for (int i = 2; i < n; i++) {
        if (n % i == 0)
             return false;
      }
      return true;
    }
// Question --2
    public static void Triplets(int limit){
        for (int a = 1; a < limit; a++) {
            for (int b = a; b < limit; b++) {
                int c = (int) Math.sqrt(a * a + b * b);
                if (c < limit && a * a + b * b == c * c) {
                    System.out.println(a + " " + b + " " + c);
                }
            }
        }
    }

    // question --3

     public static void question3() {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter no of semester: ");
        int semesters = sc.nextInt();

        for (int sem = 1; sem <= semesters; sem++) {
            System.out.print("Enter no of subjects in " + sem + " semester: ");
            int subjects = sc.nextInt();

            int[] marks = new int[subjects];
            System.out.print("Marks obtained in semester " + sem + ": ");
            for (int i = 0; i < subjects; i++) {
                marks[i] = sc.nextInt();
            }

             boolean valid = true;
            for (int m : marks) {
                if (m < 0 || m > 100) {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                System.out.println("You have entered invalid mark.");
            } else {
                // Find maximum mark
                int maxMark = marks[0];
                for (int m : marks) {
                    if (m > maxMark) {
                        maxMark = m;
                    }
                }
                System.out.println("Maximum mark in " + sem + " semester: " + maxMark);
            }
        }
    }

    // question --4

    public static void question4() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of a: ");
        int a = sc.nextInt();

        System.out.print("Enter value of b: ");
        int b = sc.nextInt();

        
        System.out.print("Enter value of c: ");
        int c = sc.nextInt();

       
        int result = (int) Math.pow(a + b, 3);

        System.out.println("Result of the equation: " + result);
    }

    // question --5

     public static void question5() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of dealerships: ");
        int dealerships = sc.nextInt();

        for (int i = 1; i <= dealerships; i++) {
            int cars = sc.nextInt();
            int bikes = sc.nextInt();

            int totalTyres = (cars * 4) + (bikes * 2);

            System.out.println(totalTyres);
            System.out.println("dealership" + i + " contains " + cars + " cars and " + bikes + " bikes");
            System.out.println("Total number of tyres in dealership" + i +
                               " is (" + cars + " x 4) + (" + bikes + " x 2) = " + totalTyres);
        }
    }

    // question --6

     public static void question6() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = Integer.parseInt(sc.nextLine());

        String[] items = new String[n];
        int[] discounts = new int[n];

        int minDiscount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(",");

            String name = parts[0];
            int price = Integer.parseInt(parts[1]);
            int percent = Integer.parseInt(parts[2]);

            int discountAmount = (price * percent) / 100;

            items[i] = name;
            discounts[i] = discountAmount;

            if (discountAmount < minDiscount) {
                minDiscount = discountAmount;
            }
        }

        System.out.println("Items with the least discount:");
        for (int i = 0; i < n; i++) {
            if (discounts[i] == minDiscount) {
                System.out.println(items[i]);
            }
        }
    }

    // question --7

    public static void question7() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num == 0) {
            System.out.println("No Factors");
        } else {
            num = Math.abs(num); 
            System.out.print("Factors: ");
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    System.out.print(i);
                    if (i != num) {
                        System.out.print(",");
                    }
                }
            }
            System.out.println(); 
        }
    }

    // question --8

     public static void question8() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of matrix (n x n): ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

        
        System.out.println("Rotated Matrix:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    // question --9

    public static void question9() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println("Target found at index: " + index);
        } else {
            System.out.println("Target not found.");
        }

        }

    
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; 
    }

    // question --10

    public static void question10() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

       
        Map<Integer, Integer> freqMap = new LinkedHashMap<>(); 

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

       
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + " occurs " + entry.getValue() + " times");
        }
    }



 


    


    public static void main(String[] args) {
        int n = 29;
        System.out.println(isPrime(n));
        Triplets(20);
        question3();
        question4();
        question5();
        question6();
        question7();
        question8();
        question9();
        question10();
    }
}


