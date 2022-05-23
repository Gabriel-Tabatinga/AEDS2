
public class ListaLinear {

	private Series lista[];
	private int primeiro;
	private int ultimo;
	private int tamanho;
	
	public ListaLinear(int M) {
		lista = new Series[M];
		tamanho = 0;
		primeiro = 0;
		ultimo = 0;
	}
	
	public ListaLinear() {
		
		lista = new Series[99];
		tamanho = 0;
		primeiro = 0;
		ultimo = 0;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	
	public boolean listaVazia() {
		
		boolean resp;
		
		if (primeiro == ultimo)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public boolean listaCheia() {
		
		boolean resp;
		
		if (ultimo == lista.length) 
		// if (tamanho == lista.length)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public void inserir(Series novo, int posicao) {
		
		if (! listaCheia()) {
			if ((posicao >= 0) && (posicao <= tamanho)) {
				for (int i = ultimo; i > posicao; i--)
					lista[i] = lista[i-1];
				
				lista[posicao] = novo;
				
				ultimo++;
				tamanho++;
			} 
		} 
	}
	
	public void inserirInicio(Series novo) {
		inserir(novo, primeiro);
	}
	
	public void inserirFim(Series novo) {
		inserir(novo, ultimo);
		
	}
	
	
	public Series remover(int posicao) throws Exception {
		
		Series removido = new Series();
		
		if (! listaVazia()) {
			if ((posicao >= 0) && (posicao < tamanho)) {
				
				removido = lista[posicao];
				this.tamanho--;
				
				for (int i = posicao; i < tamanho; i++) {
					lista[i] = lista[i+1];
				}
				
				this.ultimo--;
				
				return removido;
			} else
				throw new Exception("N�o foi poss�vel remover o item da lista: posi��o informada � inv�lida!");
		} else
			throw new Exception("N�o foi poss�vel remover o item da lista: a lista est� vazia!");
	}
	
	public Series removerInicio() throws Exception{
		return remover(primeiro);
	}
	public Series removerFim() throws Exception{
		return remover(ultimo-1);
	}
	
	public void mostrar() throws Exception {
		
		if (! listaVazia()) {
			
			for (int i = primeiro; i < ultimo; i++) {
				System.out.print("[" + i + "]");
				lista[i].printClass();
			}
		} else
			throw new Exception("N�o foi poss�vel imprimir o conte�do da lista: a lista est� vazia!");
	}
}
