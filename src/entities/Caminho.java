package entities;

public class Caminho {
	
	public int peso;
	public int origem;
	public int destino;
	
	public Caminho(int peso, int origem, int destino) {
		this.peso = peso;
		this.origem = origem;
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "\n[peso=" + peso + ", origem=" + origem + ", destino=" + destino + "]";
	}
	
	

}
