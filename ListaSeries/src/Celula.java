
public class Celula {
	private Series item;
	private Celula proximo;
	
	public Celula(Series novo) {
		item = novo;
		proximo = null;
	}
	
	public Celula() {
		
		item = new Series();
		proximo = null;
	}
	
	public Series getItem() {
		return item;
	}
	public void setItem(Series item) {
		this.item = item;
	}
	
	public Celula getProximo() {
		return proximo;
	}
	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}
}
