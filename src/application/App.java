package application;

import javax.swing.JOptionPane;

import entities.Grafo;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//iniciarPrograma();
		grafoTest();
		
	
		
	}
	
	
	
	private static void grafoTest() {
		Grafo<String> grafo = new Grafo<String>();
		String s = JOptionPane.showInputDialog("Adicionar Vertice");
		grafo.addVertice(s);
		System.out.println(grafo);
		
		
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
			
		}else {
			exibeMessageError();
		}
	}

	private static void inicializarGrafo() {
		// TODO Auto-generated method stub
		
	}

}
