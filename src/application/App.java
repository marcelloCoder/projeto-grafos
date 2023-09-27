package application;

import javax.swing.JOptionPane;

import entities.Grafo;

public class App {

	static Grafo<String> grafo = new Grafo<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//iniciarPrograma();
		iniciarPrograma();
		
		
		
	
		
	}
	
	
	
	private static void grafoTest() {
		
		
		//String qntd = JOptionPane.showInputDialog("Quantidade");
	
		
		
	
		
	
        	
        // Adicione vértices e arestas ao grafo conforme necessário
        
       
		
		
		
	}



	private static void iniciarPrograma() {
		
		String init = JOptionPane.showInputDialog("Digite\n 1 para Modulo de Logistia.\n 2 para Modulo de jogo.\n 3 para sair \n");
		Integer esc = Integer.parseInt(init);
		if(esc == 1) {
			
			exibeMenuModuloLogistica();
			
		}else if(esc == 2) {
			
			exibeMenuModuloJogo();
			
		}else {
			
			exibeMessageError();
			
		}
		
	}
	private static void exibeMessageError() {
		System.err.println("EXIT");
		
	}
	private static void exibeMenuModuloJogo() {
			
		String modJogo = JOptionPane.showInputDialog("Digite\n"
				+ "1 para ir ao Menu principal\n"
				+ "2 para Inserir Rotas\n"
				+ "3 para sair");
		
		Integer n = Integer.parseInt(modJogo);
		
		if(n == 1) {
			iniciarPrograma();
		}else if(n == 2){
			String v1 = JOptionPane.showInputDialog("addVertices1");
			String v2 = JOptionPane.showInputDialog("addVertices2");
			String v3 = JOptionPane.showInputDialog("addVertices3");
			String v4 = JOptionPane.showInputDialog("addVertices4");
			String v5 = JOptionPane.showInputDialog("addVertices5");
			
			grafo.addVertice(v1);
			grafo.addVertice(v2);
			grafo.addVertice(v3);
			grafo.addVertice(v4);
			grafo.addVertice(v5);
			grafo.addAresta(2.0, v1, v3);
			grafo.addAresta(3.0, v3, v2);
			grafo.addAresta(9.0, v2, v4);
			grafo.addAresta(5.0, v4, v1);
			grafo.addAresta(3.0, v1, v5);
			exibeMenuModuloJogo();
			
		}else if(n ==3) {
			grafo.buscaValor();
			grafo.exibirDadosDoGrafo();
		}else {
			exibeMessageError();
		}
		
	}

	private static void exibeMenuModuloLogistica() {
		
		String modLog = JOptionPane.showInputDialog("Digite\n"
				+ "1 para ir ao Menu principal\n"
				+ "2 para Inserir Rotas\n"
				+ "3 para sair");
		
		Integer n = Integer.parseInt(modLog);
		
		if(n == 1) {
			iniciarPrograma();
		}else if(n == 2){
			
			String v1 = JOptionPane.showInputDialog("addVertices1");
			String v2 = JOptionPane.showInputDialog("addVertices2");
			String v3 = JOptionPane.showInputDialog("addVertices3");
			String v4 = JOptionPane.showInputDialog("addVertices4");
			String v5 = JOptionPane.showInputDialog("addVertices5");
			
			grafo.addVertice(v1);
			grafo.addVertice(v2);
			grafo.addVertice(v3);
			grafo.addVertice(v4);
			grafo.addVertice(v5);
			grafo.addAresta(2.0, v1, v3);
			grafo.addAresta(3.0, v3, v2);
			grafo.addAresta(9.0, v2, v4);
			grafo.addAresta(5.0, v4, v1);
			grafo.addAresta(3.0, v1, v5);
			exibeMenuModuloJogo();
			
		}else if(n == 3) {
			grafo.buscaValor();
			grafo.exibirDadosDoGrafo();
		}
		else {
			exibeMessageError();
		}
	}

	private static void inicializarGrafo() {
		// TODO Auto-generated method stub
		
	}

}
