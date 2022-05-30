
public class No {
	private Series item;
	private No esquerda;
	private No direita;
	
	public No() {
		
		item = new Series();
		esquerda = null;
		direita = null;
	}
	
	public No(Series registro) {
		
		item = registro;
		esquerda = null;
		direita = null;
	}
	
	public Series getItem() {
		return item;
	}
	public void setItem(Series item) {
		this.item = item;
	}
	
	public No getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}
	
	public No getDireita() {
		return direita;
	}
	public void setDireita(No direita) {
		this.direita = direita;
	}
}
