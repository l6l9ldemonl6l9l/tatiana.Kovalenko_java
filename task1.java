import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class task1{
	public static List<Integer> getIntegersFromList(List<?> args){
		List<Integer> integerList = new ArrayList<Integer>();
		for (int i = 0; i < args.size(); i++) {
			if (args.get(i) instanceof Integer) {
           		integerList.add((Integer)args.get(i));
        	};
		};
		return integerList;
	};

	public static void main(String[] args) {
		System.out.println(getIntegersFromList(Arrays.asList(1, 2, "a", "b")).toString()); // expected [1, 2]
		System.out.println(getIntegersFromList(Arrays.asList(1, 2, "a", "b", 0, 15)).toString()); // expected [1, 2, 0, 15]
		System.out.println(getIntegersFromList(Arrays.asList(1, 2, "a", "b", "aasf", "1", "123", 231)).toString()); // expected [1, 2, 231]
	};
}
