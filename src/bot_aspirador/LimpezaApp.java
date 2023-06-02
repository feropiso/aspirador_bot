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
		this.inicio = 1;
	}

	private void geraEstadoAmbiente() {
		
		inicio = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a sala que o aspirador ira começar:", 
                "Salas de [1-9]", JOptionPane.INFORMATION_MESSAGE));
		
		System.out.println("\nO aspirador esta na sala "+inicio+"\n");
		
		inicio = inicio - 1;
		
		
		for(int i = 1; i <= 9; i++) {
			
			Sala sala = new Sala();
			
			int resp = JOptionPane.showConfirmDialog(null,
					"A sala "+i+" esta limpa?", "Sala "+i, JOptionPane.YES_NO_OPTION);
			
			
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
		
		int s = 1;
		
		int contador = 0;
		
		int start = inicio;
		
		int sala_aspirador = inicio;
		
		Sala sala = salas.get(sala_aspirador);
		
		boolean sujo = true;
				
		while (contador < 9) {
			
			sujo = sala.isSujo();
						
			if(sala_aspirador <= 8 && start == inicio) {
								
				if (sujo) {					
					
					s = sala.getNumero();
															
					acoes(sujo, s, start, "A sala "+s+" esta suja! Comecando a limpeza...", 
							"A sala "+s+" agora esta limpa! Indo para a proxima sala percorrendo: ");
					
					sala.setSujo(false);
					sala.setAspiradorPresente(false);
					
				}
				else {
										
					s = sala.getNumero();
					
					acoes(sujo, s, start, "A sala "+s+" ja esta limpa!", 
							"A sala "+s+" ja esta limpa! Indo para a proxima sala percorrendo: ");
					
					sala.setSujo(false);
					sala.setAspiradorPresente(false);
				}
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
				
				sujo = sala.isSujo();
				
				s = sala.getNumero();				
				
				if(sujo) {
					acoesRetorno(sujo, s, start, "A sala "+s+" esta suja! Comecando a limpeza...", 
							"A sala "+s+" agora esta limpa! Indo para a proxima sala indo: ");
					sala.setSujo(false);
					sala.setAspiradorPresente(false);
				}
					
				else {
					acoesRetorno(sujo, s, start, "A sala "+s+" ja esta limpa!", 
							"A sala "+s+" ja esta limpa! Indo para a proxima sala indo: ");
					sala.setSujo(false);
					sala.setAspiradorPresente(false);
				}
					
					
			}
						
			contador++;
		}	
	}
	
	private void acoes(boolean sujo, int numSala, int start, String aviso1, String aviso2) {
		
		if(sujo)
			System.out.println(aviso1);
		
		if(numSala < 9 && numSala != 1) {
			
			System.out.println(aviso2);
			
			if(numSala %3 == 0) {
				
				System.out.println("Para baixo...");
				System.out.println("Para esquerda...");
				System.out.println("Para esquerda...");
			}
			else {
				System.out.println("Para a direita...");
			}
		}
						
		else {
			if(numSala == 1) {
				if(sujo)
					System.out.println("A sala "+numSala+" agora esta limpa!");
			}
						
			else if(numSala == 9) {
				
				if(sujo)
					System.out.println("A sala "+numSala+" agora esta limpa!");
				
				if(start %3 == 0) {
					System.out.println("Para cima...");
					System.out.println("Para cima...");
				}
				else if(start %6 == 0) {
					System.out.println("Para cima...");
				}
				else if(start %7 == 0) {
					System.out.println("Para esquerda...");
					System.out.println("Para esquerda...");
				}
				else if(start %4 == 0) {
					System.out.println("Para esquerda...");
					System.out.println("Para esquerda...");
					System.out.println("Para cima...");
				}
				else {
					System.out.println("Para esquerda...");
					System.out.println("Para esquerda...");
					System.out.println("Para cima...");
					System.out.println("Para cima...");
				}
			}
						
		}
	}
	
	public void acoesRetorno(boolean sujo, int numSala, int start, String aviso1, String aviso2) {
		
		if(sujo)
			System.out.println(aviso1);
		
		if(numSala == 2 || numSala == 3 || numSala == 5 || numSala == 6 || numSala == 8) {
			System.out.println(aviso2);
			System.out.println("Para esquerda...");			
		}
		
		else if (numSala == 4 || numSala == 7) {
			System.out.println(aviso2);
			System.out.println("Para cima...");
			System.out.println("Para esquerda...");
			System.out.println("Para esquerda...");
		}
		
		else {
			if(sujo)
				System.out.println("A sala "+numSala+" agora esta limpa!");
			else
				System.out.println(aviso1);
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

