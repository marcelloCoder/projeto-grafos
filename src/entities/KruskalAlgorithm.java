package entities;

import java.util.Arrays;

class KruskalAlgorithm {
    // Classe para representar uma aresta no grafo
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        // Comparação com base no peso da aresta
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    // Função principal para construir a Minimum Spanning Tree usando o algoritmo de Kruskal
    void kruskalMST(int[][] graph) {
        int V = graph.length;
        Edge[] edges = new Edge[V * V];
        int edgeCount = 0;

        // Constrói o array de arestas, removendo as arestas nulas
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] != 0) {
                    Edge edge = new Edge();
                    edge.src = i;
                    edge.dest = j;
                    edge.weight = graph[i][j];
                    edges[edgeCount++] = edge;
                }
            }
        }

        // Remove arestas nulas
        edges = Arrays.copyOfRange(edges, 0, edgeCount);

        // Sort as arestas com base no peso
        Arrays.sort(edges);

        // Array para armazenar a MST resultante
        Edge[] result = new Edge[V - 1];

        // Índice usado para o resultado[] array
        int i = 0;

        // Índice usado para o edges[] array
        int e = 0;

        // Array para rastrear os conjuntos de vértices
        int[] parent = new int[V];

        // Inicializa os conjuntos de vértices
        for (int v = 0; v < V; ++v)
            parent[v] = v;

        i = 0; // Índice usado para o resultado[] array

        // Número de arestas a serem incluídas é igual a V-1
        while (i < V - 1 && e < edges.length) {
            Edge nextEdge = edges[e++];

            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            // Se incluir essa aresta não forma um ciclo, inclua-a no resultado e incrementa o índice
            // no resultado para a próxima iteração
            if (x != y) {
                result[i++] = nextEdge;
                union(parent, x, y);
            }
            // Else descarta a aresta
        }

        // Print the contents of result[] to display the built MST
        System.out.println("Following are the edges in the constructed MST:");
        for (i = 0; i < V - 1; ++i)
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
    }

    // Função para encontrar o conjunto de um elemento 'i' usando a técnica de união-find
    int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;

        return find(parent, parent[i]);
    }

    // Função que une dois conjuntos de x e y
    void union(int[] parent, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);

        parent[xroot] = yroot;
    }

    // Driver Program
    public static void main(String[] args) {
        /* Let us create the following weighted graph
                 10
            0--------1
            |  \     |
            6|   5\   |15
            |      \ |
            2--------3
                4       */

        int V = 4; // Number of vertices in graph
        int[][] graph = {
                {0, 10, 6, 5},
                {10, 0, 0, 15},
                {6, 0, 0, 4},
                {5, 15, 4, 0}
        };

        KruskalAlgorithm kruskal = new KruskalAlgorithm();
        kruskal.kruskalMST(graph);
    }
}
