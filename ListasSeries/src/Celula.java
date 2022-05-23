
public class Celula {
	private Series item;
	private Celula proximo;
	private Celula anterior;
	
	public Celula(Series novo) {
		item = novo;
		proximo = null;
		anterior = null;
	}
	
	public Celula() {
		
		item = new Series();
		proximo = null;
		anterior = null;
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
	public Celula getAnterior() {
		return anterior;
	}
	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}
}
