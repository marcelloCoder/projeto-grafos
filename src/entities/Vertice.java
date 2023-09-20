package entities;

import java.util.ArrayList;

public class Vertice<E> {
	
	private E dado;
	private ArrayList<Aresta<E>> arestasEntradas;
	private ArrayList<Aresta<E>> arestasSaidas;

	

	public Vertice(E dado) {
		this.dado = dado;
		this.arestasEntradas = new ArrayList<Aresta<E>>();
		this.arestasSaidas = new ArrayList<Aresta<E>>();
	}

	public E getDado() {
		return dado;
	}

	public void setDado(E dado) {
		this.dado = dado;
	}
	
	public void addArestaEntrada(Aresta<E> aresta) {
		this.arestasEntradas.add(aresta);
	}
	
	public void addArestaSaida(Aresta<E> aresta) {
		this.arestasSaidas.add(aresta);
	}
	
	

}
