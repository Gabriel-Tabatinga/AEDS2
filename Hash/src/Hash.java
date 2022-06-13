
public class Hash {

	private int M;	

	private ListaEncadeada[] tabelaHash;
	
	public Hash(int tamanho){

		this.M = tamanho;


		tabelaHash = new ListaEncadeada[tamanho];


		for (int i = 0; i < M; i++)
			tabelaHash[i] = new ListaEncadeada();
	}


	private boolean isPrime(int n)
	{
	    if (n == 0 || n == 1)
	        return false;
	    for (int i = 2; i * i <= n; i++)
	        if (n % i == 0)
	            return false;
	 
	    return true;
	}
	
	private int funcaoHash(String chave){ 
		int soma=0;
		for (int i = 0; i < chave.length(); i++) {
	        if (isPrime(i + 1))
	            soma += (int)(chave.charAt(i));
	    }
		return (soma % M);
	}

	public int inserir(Series SeriesNovo) throws Exception{

		int posicao = funcaoHash(SeriesNovo.getName());

		if ((tabelaHash[posicao].pesquisar(SeriesNovo.getName())) == null){
			tabelaHash[posicao].inserirFim(SeriesNovo);
			return posicao;
		}
		else{
			throw new Exception("Não foi possível inserir o novo elemento na tabela hash: o elemento já havia sido inserido anteriormente!");
		}
	}

	public Series pesquisar(String chave){
		
		int posicao = funcaoHash(chave);

		return (tabelaHash[posicao].pesquisar(chave));
	}


	public void imprimir(){
		
	}
}