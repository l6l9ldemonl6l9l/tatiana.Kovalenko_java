import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class task5 {
    public static String inviteList(String str){
        List<String> persons = Arrays.asList(str.split(";"));
        persons.forEach(person -> {
            String[] temp = person.split(":");
            persons.set(persons.indexOf(person), "(" + temp[1] + ", " + temp[0] + ") ");
        });
        
        Collections.sort(persons);
        
        String invitedList = "";
        for(String s: persons){
           invitedList += s;
        }      
        return invitedList;
    }

	public static void main(String[] args) {
	    String s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
		String invitedList = inviteList(s);
        System.out.println(invitedList);
	}
}
