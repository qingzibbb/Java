public class Test{
	public static void main(String[] args){
		//1!+2!+3!+4!+5!
		int i = 1;
		int ret = 1;
		int sum = 0;
		while(i <= 5){
			ret = 1;
			int j = 1;
		    while(j <= i){
		        ret*=j;
		        j++;
		    }
		sum += ret;
		i++;
		}
		System.out.println(sum);
	}
}