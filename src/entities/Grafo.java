package entities;

import java.util.ArrayList;

public class Grafo<E> {

	private ArrayList<Vertice<E>> vertices;
	private ArrayList<Aresta<E>> arestas;
	
	

	public Grafo() {
		this.vertices = new ArrayList<Vertice<E>>();
		this.arestas = new ArrayList<Aresta<E>>();
	}
	
	public void addVertice(E dado) {
		Vertice<E> novoVertice = new Vertice<E>(dado);
		this.vertices.add(novoVertice);
		
	}
	
	public void addAresta(Double peso, E dadoInicio, E dadoFim) {
		Vertice<E> inicio = this.getVertice(dadoInicio);
		Vertice<E> fim = this.getVertice(dadoFim);
		Aresta<E> aresta = new Aresta<E>(peso, inicio, fim);
		inicio.addArestaSaida(aresta);
		fim.addArestaEntrada(aresta);
		this.arestas.add(aresta); //Salvar dados no grafo
	}
	
	public Vertice<E> getVertice(E dado){ //Verificação se o vertice existe 
		Vertice<E> vertice = null; //Retorna null se nao encontrar
		for(int i = 0; i < this.vertices.size(); i++) {
			if(this.vertices.get(i).getDado().equals(dado)) {
				vertice = this.vertices.get(i);
				break;
			}
		}
		return vertice;
	}
	
	public void buscaValor() {
		ArrayList<Vertice<E>> marcados = new ArrayList<Vertice<E>>();
		ArrayList<Vertice<E>> fila = new ArrayList<Vertice<E>>();
		Vertice<E> atual = this.vertices.get(0); //Pegando o primeiro elemento do grafo
		marcados.add(atual);
		System.out.println(atual.getDado());// Dado na posição visitada marcada e imprimida
		fila.add(atual); // Marca os elementos visitados
		while(fila.size() > 0) { // Enquanto existe vertice/percorrer as arestas na fila ele vai visitando
			Vertice<E> visitado = fila.get(0); // Pegar o primeiro elemento visitado
			for(int i = 0; i < visitado.getArestasSaidas().size(); i++) { //Percorrr todas as Arestas que saem do vertice
				Vertice<E> next = visitado.getArestasSaidas().get(i).getFim(); // Recebe o final da aresta 
				if(!marcados.contains(next)) {//Verificar se vertice nao foi visitado
					marcados.add(next);
					System.out.println(next.getDado());
					fila.add(next); //Adiciona se caso ainda nao foi visitado
					
				}
			}
			fila.remove(0); // Quando faz toda a validação remove o primeiro vertice da fila
			
		}
	}
	
	public void exibirDadosDoGrafo() {
        System.out.println("Vertices:");
        for (Vertice<E> vertice : vertices) {
            System.out.println("Vertice: " + vertice.getDado());
            System.out.println("Arestas de entrada:");
            for (Aresta<E> aresta : vertice.getArestasEntradas()) {
                System.out.println("   - Peso: " + aresta.getPeso());
                System.out.println("     Inicio: " + aresta.getInicio().getDado());
                System.out.println("     Fim: " + aresta.getFim().getDado());
            }
            System.out.println("Arestas de saída:");
            for (Aresta<E> aresta : vertice.getArestasSaidas()) {
                System.out.println("   - Peso: " + aresta.getPeso());
                System.out.println("     Inicio: " + aresta.getInicio().getDado());
                System.out.println("     Fim: " + aresta.getFim().getDado());
            }
            System.out.println();
        }
        System.out.println("Arestas:");
        for (Aresta<E> aresta : arestas) {
            System.out.println("Aresta com peso: " + aresta.getPeso());
            System.out.println("Inicio: " + aresta.getInicio().getDado());
            System.out.println("Fim: " + aresta.getFim().getDado());
            System.out.println();
        }
    }
	
	
	
	
	
	

}
