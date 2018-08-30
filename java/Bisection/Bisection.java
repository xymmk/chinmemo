public class Bisection {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7,8,9};
		int begin = 0;
		int end = a.length - 1;
		double b = 5;  //find out b in the array a
		int find = -1;
		while(end >= begin) {
			int index = (int)(end - begin) / 2 + begin;
			if(b > a[index]) {
				begin = index + 1; 
			}
			if(b < a[index]) {
				end = index - 1;
			}
			if(b == a[index]) {
				System.out.println("b at " + index);
				find = index;
				break;
			}
		}
		if(find == -1) {
			System.out.println("not find b");
		}
	}

}
