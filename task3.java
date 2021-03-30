public class task3  {
    public static int digital_root(int x){
        while (x>9) {
            return digital_root(x%10 + digital_root(x/10));
        }
        return x;
    }

	public static void main(String[] args) {
		System.out.println(digital_root(16));
		System.out.println(digital_root(942));
		System.out.println(digital_root(132189));
		System.out.println(digital_root(493193));
	}
}
