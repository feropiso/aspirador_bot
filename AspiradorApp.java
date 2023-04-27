package bot_aspirador;

import javax.swing.JOptionPane;

public class AspiradorApp {
	
	private int ambiente [][];	
	private int inicio;
	
	public AspiradorApp() {
		this.ambiente = new int [3][3];		
		this.inicio = 1;
	}
	
	public static void main(String[] args) {
		
		/*********************************************************
		 *Definição: 0 -> sala limpa; 1 -> sala suja; 2 -> aspirador.
		 *O ambiente:  
		 * | 1 | 2 | 3 |
		 * | 4 | 5 | 6 |
		 * | 7 | 8 | 9 |
		 *********************************************************/
		
		AspiradorApp asp = new AspiradorApp();
		
		asp.posicionaAspirador();
		asp.geraEstadoAmbiente();
		asp.mostraSalas();
		System.out.println("\nLimpando...\n");
		asp.limpaSalas();
		asp.mostraSalas();
		

	}
	
	public void posicionaAspirador() {
		
		inicio = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a sala que o aspirador irá começar:", 
                "Salas de [1-9]", JOptionPane.INFORMATION_MESSAGE));
		
		switch (inicio) {

		case 1:
			
			ambiente[0][0] = 2;						

		break;

		case 2:
			
			ambiente[0][1] = 2;

		break;

		case 3:
			
			ambiente[0][2] = 2;

		break;
		
		case 4:
			
			ambiente[1][0] = 2;

		break;
		
		case 5:
			
			ambiente[1][1] = 2;

		break;
		
		case 6:
			
			ambiente[1][2] = 2;

		break;
		
		case 7:
			
			ambiente[2][0] = 2;

		break;
		
		case 8:
			
			ambiente[2][1] = 2;

		break;
		
		case 9:
			
			ambiente[2][2] = 2;

		break;

		default:

			JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);

		}
	}
	
	public void geraEstadoAmbiente() {
		
		int cont = 0;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				if(ambiente[i][j] == 2) {
					cont++;
					continue;
				}
				else {
					cont++;
					int resp = JOptionPane.showConfirmDialog(null,
							"A sala "+cont+" está limpa?", "Sala "+cont, JOptionPane.YES_NO_OPTION);
					ambiente[i][j] = resp;
				}
			}
		}
			
	}
	
	public void mostraSalas() {
		
		for (int t = 0; t < 3; t++)			
			System.out.println("| "+ambiente [t][0]+" | "+ambiente [t][1]+" | "+ambiente [t][2]+" |");	
		
		
	}
	
	public void limpaSalas() {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				if(ambiente[i][j] == 0) {					
					continue;
				}
				else {
					ambiente[i][j] = 0;
				}
			}
		}
		
		ambiente[0][0] = 2;
		
	}

}
