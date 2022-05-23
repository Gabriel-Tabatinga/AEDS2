
public class ListaEncadeada {

	private Celula primeiro;
	private Celula ultimo;
	private int tamanho;
	
	public ListaEncadeada() {
		
		Celula sentinela = new Celula();
		
		primeiro = sentinela;
		ultimo = sentinela;
		tamanho = 0;
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
	
	public void inserir(Series novo, int posicao) throws Exception {
		
		Celula anterior, novaCelula, proximaCelula;
		
		if ((posicao >= 0) && (posicao <= tamanho)) {
			anterior = primeiro;
			for (int i = 0; i < posicao; i++)
				anterior = anterior.getProximo();
				
			novaCelula = new Celula(novo);
			
			proximaCelula = anterior.getProximo();
			
			anterior.setProximo(novaCelula);
			novaCelula.setProximo(proximaCelula);
			
			if (posicao == tamanho)  // a inser��o ocorreu na �ltima posi��o da lista
				ultimo = novaCelula;
			
			tamanho++;
			
		} else
			throw new Exception("N�o foi poss�vel inserir o item na lista: a posi��o informada � inv�lida!");
	}
	public void inserirInicio(Series novo) {
		try {
			inserir(novo, 0);
		} catch (Exception e) {;}
	}
	public void inserirFim(Series novo) {
		try {
			inserir(novo, tamanho);
		} catch (Exception e) {;}
	}
	
	
	
	public Series remover(int posicao) throws Exception {
		
		Celula anterior, celulaRemovida, proximaCelula;
		
		if (! listaVazia()) {
			if ((posicao >= 0) && (posicao < tamanho)) {
				anterior = primeiro;
				for (int i = 0; i < posicao; i++)
					anterior = anterior.getProximo();
				
				celulaRemovida = anterior.getProximo();
				
				proximaCelula = celulaRemovida.getProximo();
				
				anterior.setProximo(proximaCelula);
				celulaRemovida.setProximo(null);
				
				if (celulaRemovida == ultimo)
					ultimo = anterior;
				
				tamanho--;
				
				return (celulaRemovida.getItem());	
			} else
				throw new Exception("N�o foi poss�vel remover o item da lista: a posi��o informada � inv�lida!");
		} else
			throw new Exception("N�o foi poss�vel remover o item da lista: a lista est� vazia!");
	} 
	public Series removerInicio() throws Exception {
		return remover(0);
	}
	public Series removerFim() throws Exception {
		return remover(tamanho-1);
	}
	
	public void mostrar() throws Exception {
		
		Celula aux;
		int i=0;
		if (! listaVazia()) {
			
			aux = primeiro.getProximo();
			while (aux != null) {
				System.out.print("[" + i++ + "]");
				aux.getItem().printClass();
				aux = aux.getProximo();
			}
		} else
			throw new Exception("N�o foi poss�vel imprimir o conte�do da lista: a lista est� vazia!");
	}
}
