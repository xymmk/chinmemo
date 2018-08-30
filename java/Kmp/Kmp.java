public class Kmp {
	public static Integer[] getNext(String str) {
		Integer [] result = new Integer[str.length()];
		for(int i = 0; i < str.length(); i++) {
			String temp = str.substring(0, i + 1);
			int flag = -1;
			for(int n = 0 ; n < temp.length(); n++) {
				if(temp.substring(0, n).equals(temp.substring(temp.length() - n , temp.length())) && !(temp.substring(0, n).equals(""))) {
					result[i] = n;
					flag = 1;
				}
			}
			if(flag == -1) {
				result[i] = 0;
			}
		}
		return result;
	}
	public static int getIndex(Integer[] next, String dest, String context) {
		char [] contextString = context.toCharArray();
		char [] desString = dest.toCharArray();
		int i = 0;
		int j = 0;
		int flag = -1;
		while(i < contextString.length) {
			if(desString[j] == contextString[i]) {
				if(j == desString.length - 1) {
					flag = i - j;
					break;
				}
				if(j < desString.length) {
					j = j + 1;
					i = i + 1;
					continue;
				}
				if(j > desString.length) {
					j = 0;
					i = i + 1;
					continue;
				}
			}
			if(desString[j] != contextString[i]) {
				i = next[j] + i + 1 - j;
				j = 0;
				continue;
			}
		}
		return flag;
	}
	public static void main(String []args) {
		String dest = "ababa";
		String context = "ssdfgasdbababcababa";
		Integer [] next = getNext(dest);
		for(int i = 0; i < next.length; i++) {
			System.out.println(next[i]);
		}
		int findAt = getIndex(next, dest, context);
		System.out.println("findAt " + findAt);
		
	}

}

