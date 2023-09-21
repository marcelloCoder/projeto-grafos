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
	
	public void buscaValor() {
		ArrayList<Vertice<E>> marcados = new ArrayList<Vertice<E>>();
		ArrayList<Vertice<E>> fila = new ArrayList<Vertice<E>>();
		Vertice<E> atual = this.vertices.get(0);
		marcados.add(atual);
		System.out.println(atual.getDado());
		fila.add(atual);
		while(fila.size() > 0) {
			Vertice<E> visitado = fila.get(0);
			for(int i = 0; i < visitado.getArestasSaidas().size(); i++) {
				Vertice<E> next = visitado.getArestasSaidas().get(i).getFim();
				if(!marcados.contains(next)) {
					marcados.add(next);
					System.out.println(next.getDado());
					fila.add(next);
				}
			}
			fila.remove(0);
			
		}
	}
	
	
	
	
	
	

}
