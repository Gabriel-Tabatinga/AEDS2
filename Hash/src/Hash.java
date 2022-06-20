
public class Hash {

	private int M;
	private ListaEncadeada tabelaHash[];
	private int comparacoes;
	private int posicao;
	
	public Hash(int tamanho) {
		
		this.M = tamanho;
		
		tabelaHash = new ListaEncadeada[this.M];
		for (int i = 0; i < M; i++)
			tabelaHash[i] = new ListaEncadeada();
	}


	public int getComparacoes() {
		return comparacoes;
	}
	
	
	
	private int funcaoHash(String chave){ 
		int soma=0;
		for (int i = 0; i < chave.length(); i++) {
	           soma += (int)(chave.charAt(i));
	    }
		return (soma % M);
	}
	
	public void inserir(Series novo) throws Exception {
		
		int posicao;
		
		posicao = funcaoHash(novo.getName());
		
		if (tabelaHash[posicao].pesquisar(novo.getName()) == null)
			tabelaHash[posicao].inserir(novo, 0);
		else
			throw new Exception("Não foi possível inserir o novo elemento na tabela hash: o elemento já havia sido inserido anteriormente!");
	}
	
	public Series pesquisar(String chave) {
		
		int posicao;
		
		posicao = funcaoHash(chave);
		this.posicao = posicao;
		return tabelaHash[posicao].pesquisar(chave);
	}


	public int getPosicao() {
		return this.posicao;
	}
}