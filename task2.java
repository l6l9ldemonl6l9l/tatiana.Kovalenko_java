public class task2{
   
    public static char first_non_repeating_letter(String string){
        for(int i=0;i<string.length()-1;i++){
            String someChar = String.valueOf(string.charAt(i));
            if(string.length()-string.replaceAll("(?i)"+someChar,"").length()==1)
                return someChar.charAt(0);
        }
        return '\0';
    }
    
    public static void main(String[] args) {
        System.out.println(first_non_repeating_letter("stress"));
        System.out.println(first_non_repeating_letter("STress"));
        System.out.println(first_non_repeating_letter("ssS"));
    }
}
