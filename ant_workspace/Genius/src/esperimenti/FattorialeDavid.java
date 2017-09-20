package esperimenti;

public class FattorialeDavid {

	public static void main(String[] args) {
		
		int sum=0;
		int i=10;

		
		while(sum!=i) {
			i++;
			sum = fattoriTot(i);
		}
		
		System.out.println(""+sum);

	}
	
	static int fattori(int num){
		int fat=1;
		
		while(num>0) {
			fat*=num--;
		}
		return fat;
	}
	
	static int fattoriTot(int num) {
		int per=1, ris=0, temp=0;;
		
		while(num>per*10) {
			per*=10;
		}
		
		while(num>per) {
			temp = (int) num/per;
			num -= temp*per;
			per /= 10;
			ris += fattori(temp);
			//System.out.println(""+fattori(temp));
		}
		return ris;
	}

}
