package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*Este código é uma implementação do algoritmo de Kruskal para encontrar 
 * a Árvore Geradora Mínima (Minimum Spanning Tree - MST) 
 * de um grafo não direcionado e ponderado.
 *  
 *   
 *   
 *   A classe `Grafo` possui vários métodos. 
 *   
 *   
 *   
 *   */

class Grafo {
	/*A classe `Grafo` representa um grafo e possui três membros: 
 *  `int vertices` (representando o número de vértices no grafo), 
 *  `int arestas` (representando o número de arestas no grafo) e 
 *  `Aresta aresta[]` (uma matriz que contém todas as arestas do grafo). */
    class Aresta implements Comparable<Aresta> {
    	/*A classe `Aresta` representa uma aresta que conecta dois vértices do grafo, 
 *  e possui três membros: `int origem` (representando o vértice de origem da aresta),
 *   `int destino` (representando o vértice de destino da aresta) e 
 *   `int peso` (representando o peso/número associado à aresta).*/
        int origem, destino, peso;

        public int compareTo(Aresta outraAresta) {
            return this.peso - outraAresta.peso;
        }
    };

    class subconjunto {
    	/*A classe `subconjunto` representa um subconjunto de 
    	 * vértices do grafo e possui dois membros: 
 *   `int pai` (representando o pai do subconjunto) e 
 *   `int classificacao` (representando a classificação do subconjunto). */
        int pai, classificacao;
    };

    int vertices, arestas;
    Aresta aresta[];

    Grafo(int v, int a) {
        vertices = v;
        arestas = a;
        aresta = new Aresta[arestas];
        for (int i = 0; i < a; ++i)
            aresta[i] = new Aresta();
    }
    

    int encontrar(subconjunto subconjuntos[], int i) {
    	/*O método `encontrar` é uma função recursiva que encontra o 
 *   conjunto pai de um subconjunto específico em uma árvore de subconjuntos. */
        if (subconjuntos[i].pai != i)
            subconjuntos[i].pai = encontrar(subconjuntos, subconjuntos[i].pai);

        return subconjuntos[i].pai;
    }

    void unir(subconjunto subconjuntos[], int x, int y) {
    	/*O método `unir` une dois subconjuntos diferentes em um único subconjunto.*/
        int raizX = encontrar(subconjuntos, x);
        int raizY = encontrar(subconjuntos, y);

        if (subconjuntos[raizX].classificacao < subconjuntos[raizY].classificacao)
            subconjuntos[raizX].pai = raizY;
        else if (subconjuntos[raizX].classificacao > subconjuntos[raizY].classificacao)
            subconjuntos[raizY].pai = raizX;
        else {
            subconjuntos[raizY].pai = raizX;
            subconjuntos[raizX].classificacao++;
        }
    }

    void KruskalMST() {
    	/*O método `KruskalMST` executa o algoritmo de Kruskal para encontrar a
 *   Árvore Geradora Mínima do grafo. 
 *   Ele ordena as arestas em ordem crescente de peso,
 *   cria os subconjuntos de vértices, 
 *   seleciona as arestas em ordem crescente de peso 
 *   e as adiciona à MST se elas não formam um ciclo.
 *   Imprime as arestas da MST.*/
        Aresta resultado[] = new Aresta[vertices];
        int e = 0;
        int i = 0;
        for (i = 0; i < vertices; ++i)
            resultado[i] = new Aresta();

        Arrays.sort(aresta);

        subconjunto subconjuntos[] = new subconjunto[vertices];
        for (i = 0; i < vertices; ++i)
            subconjuntos[i] = new subconjunto();

        for (int v = 0; v < vertices; ++v) {
            subconjuntos[v].pai = v;
            subconjuntos[v].classificacao = 0;
        }
        i = 0;
        while (e < vertices - 1) {
            Aresta proximaAresta = aresta[i++];
            int x = encontrar(subconjuntos, proximaAresta.origem);
            int y = encontrar(subconjuntos, proximaAresta.destino);
            if (x != y) {
                resultado[e++] = proximaAresta;
                unir(subconjuntos, x, y);
            }
        }

        System.out.println("As arestas na MST construída são:");
        for (i = 0; i < e; ++i)
            System.out.println(resultado[i].origem + " -- "
                    + resultado[i].destino + " == " + resultado[i].peso);
    }
}

public class AppMST {
    public static void main(String[] args) {
    	
    	/*A classe `AppMST` é a classe principal do programa. 
 *   Ela lê o grafo de um arquivo de texto e cria um objeto da classe `Grafo` 
 *   com base nas informações lidas. 
 *   Em seguida, ela chama o método `KruskalMST` para encontrar e exibir a 
 *   Árvore Geradora Mínima do grafo. No arquivo `g.txt`, 
 *   a primeira linha contém o número de vértices e o número de arestas do grafo. 
 *   As linhas seguintes contêm as informações de cada aresta: o vértice de origem, 
 *   o vértice de destino e o peso da aresta.*/
    	
        try {
            File arquivo = new File("C:\\\\projetos-java-jdk17\\\\trabalho-grafos\\\\g.txt");
            Scanner scanner = new Scanner(arquivo);
            int V = scanner.nextInt();
            int A = scanner.nextInt();
            Grafo grafo = new Grafo(V, A);

            for(int i = 0; i < A; i++) {
                grafo.aresta[i].origem = scanner.nextInt() - 1;
                grafo.aresta[i].destino = scanner.nextInt() - 1;
                grafo.aresta[i].peso = scanner.nextInt();
            }

            scanner.close();
            grafo.KruskalMST();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}