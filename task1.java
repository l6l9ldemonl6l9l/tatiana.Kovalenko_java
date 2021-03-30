import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class task1{
    
    public static boolean checkList(List list){
        for(Object object: list){
            if(!(object instanceof Integer) && !(object instanceof String))
                return false;
            else if (object instanceof Integer && (Integer)object < 0)
                return false;
        }
        return true;
    }
    
	public static List<Integer> getIntegersFromList(List list){
	    
	    if(!checkList(list))
            throw new IllegalArgumentException("List should consists only non-negative integers and strings.");
        
		List<Integer> integerList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Integer) {
           		integerList.add((Integer)list.get(i));
        	};
		};
		return integerList;
	};

	public static void main(String[] args) {
		try{
		    System.out.println(getIntegersFromList(Arrays.asList(1, 2, "a", "b")).toString()); // expected [1, 2]
		}catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try{
		    System.out.println(getIntegersFromList(Arrays.asList(1, 2, "a", "b", 0, 15)).toString()); // expected [1, 2, 0, 15]
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try{
		    System.out.println(getIntegersFromList(Arrays.asList(1, 2, "a", "b", "aasf", "1", "123", 231)).toString()); // expected [1, 2, 231]
	
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }    
    };
}
