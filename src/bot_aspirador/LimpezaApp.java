package bot_aspirador;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/********************************************
 *Autor: Fernando Rodrigo Pinheiro de Sousa *
 ********************************************/

public class LimpezaApp {

	/****************************************************************************************
	 *Definicao: 
	 *
	 *A sala possui um numero [1-9];
	 *A sala possui um estado limpo ou sujo (sujo => true; limpo => false)
	 *Na sala é indicada se o aspirador está nela. 
	 *
	 *O ambiente:  
	 *
	 * | 1 | 2 | 3 |
	 * | 4 | 5 | 6 |
	 * | 7 | 8 | 9 |
	 * 
	 ***************************************************************************************/
	
	private ArrayList<Sala> salas;
	
	private int inicio;
	
	public LimpezaApp() {
		this.salas = new ArrayList<Sala>();
		//this.ambiente = new int [3][3];		
		this.inicio = 1;
	}

	private void geraEstadoAmbiente() {
		
		inicio = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a sala que o aspirador ira começar:", 
                "Salas de [1-9]", JOptionPane.INFORMATION_MESSAGE));
		
		for(int i = 1; i <= 9; i++) {
			
			Sala sala = new Sala();
			
			int resp = JOptionPane.showConfirmDialog(null,
					"A sala "+i+" está limpa?", "Sala "+i, JOptionPane.YES_NO_OPTION);
			
			
			if (resp == 0)
				sala.setSujo(false);
			
			else
				sala.setSujo(true);
			
			sala.setAspiradorPresente(false);
			sala.setNumero(i);
			salas.add(sala);			
		}
		
		salas.get(inicio).setAspiradorPresente(true);		
	
	}
	
	private void mostraSalas() {
	
		int cont = 0;
		
		String estado;
		
		for(Sala s: salas) {
			
			if (s.isSujo())
				estado = "SUJO ";
			else
				estado = "LIMPO";
				
			System.out.print("| "+estado+" | ");		
			
			cont++;
			
			if (cont%3 == 0)
				System.out.println("");
		}
		
		
	}
	
	private void limpaSalas() {
		
		int contador = 0;
		
		int start = inicio;
		
		int sala_aspirador = inicio;
		
		Sala sala = salas.get(sala_aspirador);
		
		while (contador < 9) {
			

			if (sala.isSujo()) {
				
				System.out.println("A sala "+sala.getNumero()+" esta suja! Comecando a limpeza...");
				
				sala.setSujo(false);
				
				System.out.println("A sala "+sala.getNumero()+" agora esta limpa! Indo para a proxima sala...");
				
				sala.setAspiradorPresente(false);
				
			}
			else {
				System.out.println("A sala "+sala.getNumero()+" ja esta limpa! Indo para a proxima sala...");
				
				sala.setAspiradorPresente(false);
			}
			
			if(sala_aspirador < 8 && start == inicio) {
				sala_aspirador++;
				sala = salas.get(sala_aspirador);
			}
			else {
				start--;
				
				if (start < 0) {
					System.out.println("Fim da limpeza!");
					break;
				}
					
				sala = salas.get(start);
			}
						
			contador++;
		}	
	}

	public static void main(String[] args) {
				
		LimpezaApp asp = new LimpezaApp();
		
		asp.geraEstadoAmbiente();
		asp.mostraSalas();
		System.out.println("\nLimpando...\n");
		asp.limpaSalas();
		System.out.println("\nResultado...\n");
		asp.mostraSalas();		

	}
	

}
