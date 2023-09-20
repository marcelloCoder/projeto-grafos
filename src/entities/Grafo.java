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
		this.arestas.add(aresta);
	}
	
	public Vertice<E> getVertice(E dado){
		Vertice<E> vertice = null;
		for(int i = 0; i < this.vertices.size(); i++) {
			if(this.vertices.get(i).getDado().equals(dado)) {
				vertice = this.vertices.get(i);
				break;
			}
		}
		return vertice;
	}
	
	
	
	
	
	

}
