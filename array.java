import java.util.*;
public class array {

   // question 11

    public static void question11() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;

        System.out.println("Spiral order:");
        while (top <= bottom && left <= right) {
            // Traverse top row
            for (int j = left; j <= right; j++) {
                System.out.print(matrix[top][j] + " ");
            }
            top++;
              for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

           
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }
                bottom--;
            }

          
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }

   //  question 12

    public static void question12() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

       
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) {
            set.add(num);
        }

        if (set.size() < 2) {
            System.out.println("Second Smallest : -1");
            System.out.println("Second Largest : -1");
        } else {
           
            List<Integer> list = new ArrayList<>(set);
            int secondSmallest = list.get(1);
            int secondLargest = list.get(list.size() - 2);

            System.out.println("Second Smallest : " + secondSmallest);
            System.out.println("Second Largest : " + secondLargest);
        }
    }

   //  question 13

   public static void question13() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of intervals: ");
        int n = sc.nextInt();

        int[][] intervals = new int[n][2];
        System.out.println("Enter intervals (start end):");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
               merged.add(interval);
            } else {
                // Overlap → merge with last interval
                merged.get(merged.size() - 1)[1] = Math.max(
                    merged.get(merged.size() - 1)[1], interval[1]
                );
            }
        }

         System.out.println("Merged Intervals:");
        for (int[] in : merged) {
            System.out.println("[" + in[0] + "," + in[1] + "]");
        }
    }

   //  question 14

    public static void question14() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] A = new int[rows][cols];
        int[][] B = new int[rows][cols];

        System.out.println("Enter elements of Matrix A:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of Matrix B:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                B[i][j] = sc.nextInt();
            }
        }

          boolean identical = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] != B[i][j]) {
                    identical = false;
                    break;
                }
            }
        }

        if (identical) {
            System.out.println("Matrices are identical");
        } else {
            System.out.println("Matrices are not identical");
        }
    }

   //  question 15

      public static void question15() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

       
        int start = 0, end = n - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        
        System.out.print("Reversed Array: {");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
              if (i != n - 1) System.out.print(",");
        }
        System.out.println("}");
    }

   //  question 16

    public static void question16() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = findKthLargest(nums, k);
        System.out.println("Kth Largest Element: " + result);
    }

   
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
         for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); 
            }
        }

        return minHeap.peek();
    }

   //  question 17

     public static void question17() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = findMissingNumber(nums);
        System.out.println("Missing Number: " + result);
    }

    // Function using sum formula
    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

                return expectedSum - actualSum;
    }

   //  question 18

   public static void question18() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array (N+1): ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int duplicate = findDuplicate(arr);
        System.out.println("Duplicate Number: " + duplicate);
    }

    
    public static int findDuplicate(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(num)) {
                return num; 
            }
            seen.add(num);
        }
        return -1;
    }

   //  question 19

   public static void question19() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter m (size of nums1 valid elements): ");
        int m = sc.nextInt();
        System.out.print("Enter n (size of nums2): ");
        int n = sc.nextInt();

        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];

        System.out.println("Enter nums1 elements (first " + m + " valid, rest 0):");
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.println("Enter nums2 elements:");
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        merge(nums1, m, nums2, n);

        System.out.println("Merged Array: " + Arrays.toString(nums1));
    }

     public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; 
        int j = n - 1; 
        int k = m + n - 1; 

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

       
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

   //  question 20

    public static void question20() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k (steps to rotate): ");
        int k = sc.nextInt();

        rotate(nums, k);

        System.out.println("Rotated Array: " + Arrays.toString(nums));
    }

    
    public static void rotate(int[] nums, int k) {

       int n = nums.length;
        k = k % n; 

        
        reverse(nums, 0, n - 1);

        
        reverse(nums, 0, k - 1);

       
        reverse(nums, k, n - 1);
    }

    
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

   //  question 21

   public static void question21() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = maxProduct(nums);
        System.out.println("Maximum Product Subarray: " + result);
    }

    
    public static int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int maxProd = nums[0];

        for (int i = 1; i < nums.length; i++) {
         if (nums[i] < 0) {
              
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(nums[i], currMax * nums[i]);
            currMin = Math.min(nums[i], currMin * nums[i]);

            maxProd = Math.max(maxProd, currMax);
        }

        return maxProd;
    }

   //  question 22

   public static void question22() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        int result = countPairs(arr, target);
        System.out.println("Number of pairs with sum " + target + ": " + result);
    }

    // Function to count pairs
    public static int countPairs(int[] arr, int target) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int complement = target - num;


            if (freq.containsKey(complement)) {
                count += freq.get(complement);
            }

            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return count;
    }

   //  question 23

   public static void question23() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        moveZeros(nums);
        

        System.out.println("Array after moving zeros: " + Arrays.toString(nums));
    }

    
    public static void moveZeros(int[] nums) {
        int pos = 0; 

        
        for (int num : nums) {
            if (num != 0) {
                nums[pos++] = num;
            }
        }

          while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }

   //  question 24

     public static void question24() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = majorityElement(nums);
        System.out.println("Majority Element: " + result);
    }

    
    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;

                  } else {
                count--;
            }
        }

        return candidate;
    }

   //  question 25

    public static void question25() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of nums1: ");
        int m = sc.nextInt();
        int[] nums1 = new int[m];
        System.out.println("Enter elements of nums1:");
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter size of nums2: ");
        int n = sc.nextInt();
        int[] nums2 = new int[n];
        System.out.println("Enter elements of nums2:");
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        int[] result = intersection(nums1, nums2);
        System.out.println("Intersection: " + Arrays.toString(result));
    }

    
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        
        int[] result = new int[resultSet.size()];
        int idx = 0;
        for (int num : resultSet) {
            result[idx++] = num;
        }

        return result;
    }



   public static void main(String[] args) {
     System.out.println("Hello, World!");
       question11();
       question12();
       question13();
       question14();
       question15();
       question16();
       question17();
       question18();
       question19();
       question20();
       question21();
       question22();
       question23();
       question24();
       question25();
   } 
}
             