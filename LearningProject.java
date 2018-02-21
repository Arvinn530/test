import java.util.Scanner;
import java.util.Arrays;

public class LearningProject {
	public static boolean isPalindrom (String str)  {
        if (str.length() <= 1) {
            return true;
        } else if (str.charAt(0)==str.charAt(str.length()-1)) {
            return isPalindrom(str.substring(1, str.length()-1));
        } else {
            return false;
        }
    }

    public static int normal(int num) {
        if (num == 1) {
        	return 1;
       	} 
        else {
        	return 1 + num * normal(num - 1);
        } 
    }

    public static int combination(String str, int ix) {
        if (ix == str.length()) {
            return 0;
        } else {
            String str1 = str.substring(0, ix) + str.substring(ix+1);
            return palindrom(str1) + combination(str, ix + 1);
        }
    }

    public static int palindrom (String str) {
        if (str.length() == 1 || isPalindrom(str)) {
            return 1;
        } else {
            return 1 + combination(str, 0);
        }
    }

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String str0, str1;
		str0 = "continue";
		while(!str0.equals("stop")) {
			str0 = input.next();
			str1 = input.next();
			if(str0.equals("normal")) {
				System.out.println(normal(str1.length()));
			} else if(str0.equals("palindrom")) {
				System.out.println(palindrom(str1));
			}	
		}
	}
}