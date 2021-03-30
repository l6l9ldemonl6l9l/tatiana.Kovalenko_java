import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class task4 {
	 public static int numberOfPairsByFor(int target, int[] arr){
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] + arr[j] == target){
					count++;
				};
			};
		};
		return count;
	}
	public static int numberOfPairsByStream(int target, int[] arr){
        AtomicInteger count = new AtomicInteger();
        IntStream.range(0, arr.length-1)
            .forEach( i -> {
                IntStream.range(i,arr.length)
                        .forEach(j -> {
                            if(arr[i]+arr[j]==target && i!=j){
                                count.getAndIncrement();
                            };
                        });
            });
        return count.getPlain();	
	}

	public static void main(String[] args) {
          System.out.println(numberOfPairsByFor(5, new int[]{1,3,6,2,2,0,4,5}));
          System.out.println(numberOfPairsByStream(5, new int[]{1,3,6,2,2,0,4,5}));
	}
}
