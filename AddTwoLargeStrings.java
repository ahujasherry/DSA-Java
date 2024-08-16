public class LargeNumberAddition {

    // Function to add two large numbers represented as strings
    public static String addLargeNumbers(String str1, String str2) 
   {
        // Make sure str1 is the longer string, swap if necessary
        if (str1.length() < str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        // Reverse both strings
        str1 = new StringBuilder(str1).reverse().toString();
        str2 = new StringBuilder(str2).reverse().toString();

        StringBuilder result = new StringBuilder();

        int carry = 0;
        int n1 = str1.length();
        int n2 = str2.length();

        // Add digits from both strings
        for (int i = 0; i < n2; i++) {
            int sum = (str1.charAt(i) - '0') + (str2.charAt(i) - '0') + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        // Add remaining digits of the longer string
        for (int i = n2; i < n1; i++) {
            int sum = (str1.charAt(i) - '0') + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        // Add the final carry if any
        if (carry > 0) {
            result.append(carry);
        }

        // Reverse the result to get the final sum
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "3333311111111111";
        String str2 = "0044422222221111";
        System.out.println("Sum: " + addLargeNumbers(str1, str2));

        str1 = "7777555511111111";
        str2 = "3332222221111";
        System.out.println("Sum: " + addLargeNumbers(str1, str2));
    }
}
