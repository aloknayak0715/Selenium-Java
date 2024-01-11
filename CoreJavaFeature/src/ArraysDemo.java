import java.util.Arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int b[] = {1,3,4,6};
		int c[] = new int[5];
		c[0] =1;
		c[1]= 12;
		c[2] = 4;
		c[3] = 8;
		c[4] = 10;
		
		Arrays.sort(c);
		
		for(int i=0;i<c.length;i++) {
			System.out.println(c[i]);
		}
		
	////a[row][coloum]


		int a[][] = new int[2][3];
		a[0][0]=2;
		a[0][1]=4;
		a[0][2]=5;
		a[1][0]=3;
		a[1][1]=4;
		a[1][2]=7;
		//System.out.println(a[1][0]);
		/*int b[][]= {‌{2,4,5},{3,4,7},{5,2,1}};
		System.out.println(b[2][1]);*/

		for(int i=0;i<2;i++) //row
		{

		for(int j=0;j<3;j++) //coloumn
		{

		System.out.println(a[i][j]);
		}
		}

		
	
	}

}
