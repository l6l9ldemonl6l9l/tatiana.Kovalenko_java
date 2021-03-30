import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class extra{

    public static int pow(int value, int powValue) {
        if (powValue == 0) {
           return 1;
        } 
        else if (powValue == 1) {
           return value;
        } else {
           return value * pow(value, powValue - 1);
        }
    }

    public static List<Integer> digitsInNumber(int number) {
        String n = Integer.toString(number);
        char[] charArray = n.toCharArray();
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0;i<charArray.length; i++){
            int c = Character.getNumericValue(charArray[i]);
            numbers.add(c);
        }
        return numbers;
    }
    
    public static int numberFromDigits(List<Integer> numbers) {
        int number=0;
        for (int i = 0; i<numbers.size(); i++){
            number=number+numbers.get(numbers.size()-i-1)*pow(10,i);
        }  
        return number;
    }
    
    public static int nextBigger(int number){
        List<Integer> numbers = digitsInNumber(number);
        int len=numbers.size();
        for (int i=len-2; i>=0; i--){
            for (int j=len-1; j>i; j--){
                List<Integer> newNumbers = new ArrayList<Integer>(numbers);
                int num =newNumbers.get(i);
                newNumbers.set(i, newNumbers.get(j));
                newNumbers.set(j,num);
                //System.out.println(numberFromDigits(newNumbers));
                if (numberFromDigits(newNumbers)>numberFromDigits(numbers)){
                    List<Integer> biggerNumber=newNumbers.subList(j,len);
                    Collections.sort(biggerNumber);
                    for (int k=0; k<biggerNumber.size(); k++){
                       newNumbers.set(j+k, biggerNumber.get(k));
                    }
                    return(numberFromDigits(newNumbers));
                }
            }
        }
        return -1;
    }
    
    public static String bitToIP(long number) {
        String string=  Long.toBinaryString(number);
        while(string.length()!=32){
            string = "0" + string;
        }
        
        String[] arr = new String[4];
        String IPv4 = "";
        for(int i=0;i<4;i++){
            int start = i*8;
            arr[i] = string.substring(start, start+8);
            IPv4 += Integer.toString(Integer.parseInt(arr[i],2));
            if (i!=3) IPv4+=".";
        }

        return IPv4;
    }


	
	public static void main(String[] args) {

        System.out.println(nextBigger(12));
        System.out.println(nextBigger(513));
        System.out.println(nextBigger(2017));

        System.out.println(nextBigger(9));
        System.out.println(nextBigger(111));
        System.out.println(nextBigger(531));
        
        System.out.println(nextBigger(2871));
        System.out.println(nextBigger(3894));


        System.out.println(bitToIP(2149583361L));
        System.out.println(bitToIP(32));
        System.out.println(bitToIP(0));

    }
}
