
public class Celula {
	private Caracter item;
	private Celula proximo;
	
	public Celula(Caracter novo) {
		item = novo;
		proximo = null;
	}
	
	public Celula() {
		
		item = new Caracter();
		proximo = null;
	}
	
	public Caracter getItem() {
		return item;
	}
	public void setItem(Caracter item) {
		this.item = item;
	}
	
	public Celula getProximo() {
		return proximo;
	}
	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}
}
