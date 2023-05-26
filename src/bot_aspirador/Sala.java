package bot_aspirador;

public class Sala {
	
	private int numero;
	private boolean sujo;
	private boolean aspiradorPresente;
	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isSujo() {
		return sujo;
	}

	public void setSujo(boolean sujo) {
		this.sujo = sujo;
	}

	public boolean isAspiradorPresente() {
		return aspiradorPresente;
	}

	public void setAspiradorPresente(boolean aspiradorPresente) {
		this.aspiradorPresente = aspiradorPresente;
	}

}
