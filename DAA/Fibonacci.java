 //by recursive 
public class Fibonacci{

    public static int  fibb(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibb(n-1)+fibb(n-1);
    }
    public static void main(String[] args) {
        int n =4;
        System.out.println(fibb(n));
    }
}

//by non recursive

// public class FibonacciNonRecursive {

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter the number of terms in Fibonacci sequence: ");
//         int n = scanner.nextInt();

//         if (n <= 0) {
//             System.out.println("Please enter a positive number.");
//         } else {
//             System.out.println("Fibonacci sequence:");
//             printFibonacci(n);
//         }

//         scanner.close();
//     }

//     // Function to print the Fibonacci sequence
//     public static void printFibonacci(int n) {
//         int a = 0, b = 1;

//         // Print the Fibonacci sequence up to n terms
//         for (int i = 1; i <= n; i++) {
//             System.out.print(a + " ");

//             // Calculate next Fibonacci number
//             int nextTerm = a + b;
//             a = b;
//             b = nextTerm;
//         }
//     }
// }


