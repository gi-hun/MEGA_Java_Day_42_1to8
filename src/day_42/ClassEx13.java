/* 
 * # 1 to 50[3�ܰ�] : 1 to 18
 * 1. ���ۿ��� 1 to 50 �̶�� �˻��Ѵ�.
 * 2. 1 to 50 ���߷� ������ ������ ������ �ǽ��غ���.
 * 3. �� ������ ���ڹ����� ���� 1 to 18�� ���� �����Ѵ�.
 * 4. ���� 1~9�� front �迭�� �����ϰ�,
 *    ���� 10~18�� back �迭�� �����Ѵ�.
 */

package day_42;

import java.util.Scanner;
import java.util.Random;

class Ex13
{
	final int SIZE = 9;
	
	int[] front = new int[SIZE];
	int[] back = new int[SIZE];
}

public class ClassEx13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		Ex13 e = new Ex13();
		
		for(int i=0;i<e.SIZE;i++)		//e.SIZE = 9;
		{
			e.front[i] = i+1;
			e.back[i] = i+10;
		}
		
		for(int i=0;i<1000;i++)			//����
		{
			int r = ran.nextInt(e.SIZE);
			int temp = e.front[0];
			e.front[0] = e.front[r];
			e.front[r] = temp;
		}
		
		int gameNum = 1;
		
		while(true)
		{
			for(int i=0;i<e.SIZE;i++)
			{
				if(e.front[i] == 0)
				{
					System.out.print("\t");
				}
				else
				{
					System.out.print(e.front[i]+"\t");
				}
				
				if(i%3==2) {System.out.println("\n");}
			}
			System.out.println();
			
			if(gameNum == 19)
			{
				System.out.println("���� ����");
				break;
			}
			
			System.out.print("�Է� : ");
			int idx = sc.nextInt();
			
			if(e.front[idx] == gameNum) 
			{
				if(1 <= gameNum && gameNum <= e.SIZE)
				{
					e.front[idx] = e.back[idx];
				}
				else if(e.SIZE < gameNum && gameNum <= 18) 
				{
					e.front[idx] = 0;
				}
				gameNum ++;
			}

		}
	}
}
