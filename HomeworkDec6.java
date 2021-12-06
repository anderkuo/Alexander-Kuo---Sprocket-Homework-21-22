import java.util.Arrays;

public class HomeworkDec6 {
    public static void main(String[] args) {
        
        //Calculate the 347th number of the fibonacci sequence (1, 1, 2, 3, 5, 8 …)
        //If you’re up for the challenge, calculate the 3473rd!
                
        System.out.println("347th number of the fibonacci sequence is " + fibo(347));
        //3473rd number results in infinity
        System.out.println();

        //Given an array of longs and an int n, rotate the array by n values. 
        //For example, given [2L, 192L, 19L, 1L, 8L, 3.14L] and n = 2, the rotated array should be [19L, 1L, 8L, 3.14L, 2L, 192L].
        long[] test = {2L, 192L, 19L, 1L, 8L, 3L};
        int test2 = 2;
        System.out.println("The array " + Arrays.toString(test) + " rotated " + test2 + " times is " + rotateArray(test, test2));
        
        System.out.println();

        //Given an int which is greater than or equal to zero, create an array of Strings with the following pattern: 
        //[“ONE”, “ONE”, “TWO”, “ONE", “TWO”, “THREE”, “ONE”, “TWO”, “THREE”, “FOUR”,  ... “ONE”, “TWO”, “THREE”, “FOUR, .. “(N in String form)”]
        //Note: For values greater than 10, make their string a concatenation of the digits. 
        //For example, 15 would be “ONEFIVE” and 217 would be “TWOONESEVEN”.

        int expand = 15;
        System.out.println("The number " + expand + " expanded is " + expandedNumber(expand));

    }
    //task 1
    private static double fibo(double number) {
        
        double fiboOne = 1;
        double fiboTwo = 1;
        double fiboTerm;
        double answer = 0;
            
        for (int i = 1; i <= number; i++){
            if (i == 1){
                answer = fiboOne;
            }
            else if (i == 2) {
                answer = fiboTwo;
            }
            else {
                fiboTerm = fiboOne + fiboTwo;
                fiboOne = fiboTwo;
                fiboTwo = fiboTerm;
                answer = fiboTerm;
            }
        }
        return answer;
    }

    //task 2
    private static String rotateArray (long[] original, int factor) {
        long answer[] = new long[original.length];
        for (int i = 0; i < original.length - factor; i++) {
            answer[i] = original[i + factor];
        }
        int k = 0;
        for (int j = original.length - factor; j < original.length; j++, k++) {
            answer[j] = original[k];
        }
        return Arrays.toString(answer);
    }

    //task 3
    private static String getNumber(int p) {
        p++;
        String newNum = Integer.toString(p);
        int times = newNum.length();
        String temp = "";

        for (int i = 1; i <= times; i++) {
            String check = newNum.substring(i-1, i);
            if (check.equals("0")){
                temp += "ZERO";
            }
            if (check.equals("1")){
                temp += "ONE";
            }
            if (check.equals("2")){
                temp += "TWO";
            }
            if (check.equals("3")){
                temp += "THREE";
            }
            if (check.equals("4")){
                temp += "FOUR";
            }
            if (check.equals("5")){
                temp += "FIVE";
            }
            if (check.equals("6")){
                temp += "SIX";
            }
            if (check.equals("7")){
                temp += "SEVEN";
            }
            if (check.equals("8")){
                temp += "EIGHT";
            }
            if (check.equals("9")){
                temp += "NINE";
            }
        }
        return temp;
    }
    private static String expandedNumber (int n) {
        String[] zero = {"ZERO"};
        if (n == 0) {
            return Arrays.toString(zero);
        }
        String[] result = new String[(n * (n+1))/2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int index = ((i+1)*(i+2)/2 + j - i - 1);
                String whatNumber = getNumber(j);
                result[index] = whatNumber;
            }
        }
        return Arrays.toString(result);
    }
}