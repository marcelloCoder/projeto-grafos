package application;

import java.util.Scanner;

public class AppKruskal {
	
	int MAXTAM = 100;
	int pais[] = new int[MAXTAM];
	
	public int encontrar(int x) {
		if(pais[x] == x) {
			return x;
		}
		return encontrar(pais[x]);
	}
	
	public void unir(int x, int y) {
		int fx = encontrar(x);
		int fy = encontrar(y);
		pais[fx]=fy;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		AppKruskal kruskal = new AppKruskal();
		
		for(int i = 0; i < 100; i++) {
			kruskal.pais[i] = i;
			
		}
		
		System.out.println("INICIO DO PROGRAMA");
		
		

	}

}
