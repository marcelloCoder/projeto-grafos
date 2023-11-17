package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import entities.Caminho;

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
			//System.out.println(kruskal.pais[i]);
			
		}
		
		System.out.println("INICIO DO PROGRAMA");
		
		int vertices;
		int arestas;
		int peso;
		int destino;
		int origem;
		
		List<Caminho> caminhos = new ArrayList<Caminho>();
		System.out.println("DIGITE O NUMERO DE VERTICES DO GRAFO");
		vertices = scan.nextInt();
		System.out.println("DIGITE O NUMERO DE ARESTAS");
		arestas = scan.nextInt();
		System.out.println("DIGITE O NUMERO DE PESOS, DESTINO E ORIGEM DE CADA ARESTA");
		for(int i = 0; i < arestas; i++) {
			System.out.println("ORIGEM");
			origem = scan.nextInt();
			
			System.out.println("DESTINO");
			destino = scan.nextInt();
			
			System.out.println("PESO");
			peso = scan.nextInt();
			caminhos.add(new Caminho(peso, origem, destino));
		}
		
		int peso_total = 0;
		int grafo_caminhos = 0;
		int cont = 0;
		
		Collections.sort(caminhos, new Comparator<Caminho>() {

			@Override
			public int compare(Caminho o1, Caminho o2) {
				// TODO Auto-generated method stub
				return o1.peso - o2.peso;
			}
		});
		
		while((grafo_caminhos < vertices -  1) && (cont < arestas)) {
			origem = caminhos.get(cont).origem;
			destino = caminhos.get(cont).destino;
			peso = caminhos.get(cont).peso;
			
			if(kruskal.encontrar(origem) != kruskal.encontrar(destino)) {
				kruskal.unir(origem, destino);
				peso_total+=peso;
				System.out.println(" " + origem + " ==> " + destino + " :" + peso);
				grafo_caminhos++;
				
			}
			
			cont++;
			
		}

		if(grafo_caminhos != vertices - 1) {
			System.out.println("Grafo incorreto");
			System.out.println("Grafo encontrado é de :" + peso_total);
		}
		
		
	}

}
