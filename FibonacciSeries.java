import java.util.Arrays;

public class FibonacciSeries {

	public static void main(String[] args) {		
		FibonacciSeries fib = new FibonacciSeries();
		System.out.println(Arrays.toString(fib.fibonacciWithOutRecursive(10)));
		System.out.println(Arrays.toString(fib.fibonacciWithRecursive(10)));
	}

	private Number[] fibonacciWithOutRecursive(int num) {		
		Number[] series = new Number[num + 1];
		if(num < 0)
			return series;
		Integer f1 = 0, f2 = 1, f3;
		if(num >= 0)
			series[0] = f1;
		if(num >= 1)
			series[1] = f2;
		if(num >= 2)
		{
			int count = 2;
			while(count <= num)
			{
				f3 = f1 + f2;
				series[count++] = f3;
				f1 = f2;
				f2 = f3;
			}
		}		
		return series;
	}
	
	private Number[] fibonacciWithRecursive(int num) {		
		Number[] series = new Number[num + 1];
		Integer f1 = 0, f2 = 1, f3;
		if(num < 0)
			return series;		
		if(num == 0)
			series[0] = f1;
		if(num == 1)
			series[1] = f2;
		if(num >= 2)
		{
			f3 = f1 + f2;
			series[num--] = f3;
			f1 = f2;
			f2 = f3;
		}			
		fibonacciWithRecursive(--num);
		return series;
	}

}
