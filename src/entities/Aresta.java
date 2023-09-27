package entities;

public class Aresta<E>{

	private Double peso;
	private Vertice<E> inicio;
	private Vertice<E> fim;
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Vertice<E> getInicio() {
		return inicio;
	}
	public void setInicio(Vertice<E> inicio) {
		this.inicio = inicio;
	}
	public Vertice<E> getFim() {
		return fim;
	}
	public void setFim(Vertice<E> fim) {
		this.fim = fim;
	}
	public Aresta(Double peso, Vertice<E> inicio, Vertice<E> fim) {
		this.peso = peso;
		this.inicio = inicio;
		this.fim = fim;
	}
	@Override
	public String toString() {
		return "Aresta [" + (peso != null ? "peso=" + peso : "") + "]";
	}
	
	
	
}
