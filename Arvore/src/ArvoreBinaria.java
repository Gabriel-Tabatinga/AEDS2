
public class ArvoreBinaria {

	private No raiz;
	private int comparacoes;
	private int movimentacoes;
	private String[] passouPesquisa = new String[30];
	private int contador;
	
	public ArvoreBinaria() {
		
		raiz = null;
		comparacoes = 0;
		movimentacoes = 0;
		contador = 0;
	}
	
	public int getMovimentacoes() {
		return movimentacoes;
	}

	public int getComparacoes() {
		return comparacoes;
	}

	public String[] getPassouPesquisa() {
		return passouPesquisa;
	}
	
	public void printPassouPesquisa() {
		//IMPRIMIR MODELO [The 100] - [Game of Thrones] - [Anne] - [12 Monkeys]
		for(int i=0;i<contador;i++)
			System.out.print("[" + this.passouPesquisa[i] +"]");
	}

	public void setPassouPesquisa() {
		this.passouPesquisa = null;
	}

	public Series pesquisar(String chave) {
		this.contador = 0;
		return pesquisar(this.raiz, chave);
	}
	
	private Series pesquisar(No raizSubarvore, String chave) {
		
		if (raizSubarvore == null)
			return null;
		else if (chave.compareTo(raizSubarvore.getItem().getName()) == 0) 
		{
			this.passouPesquisa[this.contador] = raizSubarvore.getItem().getName();
			this.contador++;
			return raizSubarvore.getItem();
		}
		else if (chave.compareTo(raizSubarvore.getItem().getName()) > 0) {
			this.passouPesquisa[this.contador] = raizSubarvore.getItem().getName();
			this.contador++;
			return pesquisar(raizSubarvore.getDireita(), chave);
		}
		else {
			this.passouPesquisa[this.contador] = raizSubarvore.getItem().getName();
			this.contador++;
			return pesquisar(raizSubarvore.getEsquerda(), chave);
		}
	}
	
	public void inserir(Series novo) throws Exception {
		this.raiz = inserir(this.raiz, novo);
	}
	
	private No inserir(No raizSubarvore, Series novo) throws Exception{
		
		if (raizSubarvore == null)
			raizSubarvore = new No(novo);
		else if (novo.getName().compareTo(raizSubarvore.getItem().getName()) == 0)
			throw new Exception("Não foi possível inserir o item na árvore: chave já inseriada anteriormente!");
		else if (novo.getName().compareTo(raizSubarvore.getItem().getName()) < 0)
			raizSubarvore.setEsquerda(inserir(raizSubarvore.getEsquerda(), novo));
		else
			raizSubarvore.setDireita(inserir(raizSubarvore.getDireita(), novo));
			
		return raizSubarvore;
	}
	
	public void remover(String chaveRemover) throws Exception {
		this.raiz = remover(this.raiz, chaveRemover);
	}
	
	private No remover(No raizSubarvore, String chaveRemover) throws Exception {
		
		if (raizSubarvore == null)
			throw new Exception("Não foi possível remover o item da árvore: chave não encontrada!");
		else if (chaveRemover.compareTo(raizSubarvore.getItem().getName()) == 0) {
			if (raizSubarvore.getEsquerda() == null)
				raizSubarvore = raizSubarvore.getDireita();
			else if (raizSubarvore.getDireita() == null)
				raizSubarvore = raizSubarvore.getEsquerda();
			else
				raizSubarvore.setEsquerda(antecessor(raizSubarvore, raizSubarvore.getEsquerda()));
		} else if (chaveRemover.compareTo(raizSubarvore.getItem().getName()) > 0)
			raizSubarvore.setDireita(remover(raizSubarvore.getDireita(), chaveRemover));
		else
			raizSubarvore.setEsquerda(remover(raizSubarvore.getEsquerda(), chaveRemover));
			
		return raizSubarvore;
	}
	
	private No antecessor(No noRetirar, No raizSubarvore) {
		
		if (raizSubarvore.getDireita() != null)
			raizSubarvore.setDireita(antecessor(noRetirar, raizSubarvore.getDireita()));
		else {
			noRetirar.setItem(raizSubarvore.getItem());
			raizSubarvore = raizSubarvore.getEsquerda();
		}	
		
		return raizSubarvore;
	}
	/*
	public void caminhamentoEmOrdem() {
		caminhamentoEmOrdem(this.raiz);
	}

	private void caminhamentoEmOrdem(No raizSubarvore) {
		
		if (raizSubarvore != null) {
			caminhamentoEmOrdem(raizSubarvore.getEsquerda());
			raizSubarvore.getItem().imprimir();
			caminhamentoEmOrdem(raizSubarvore.getDireita());
		}
	}*/
}

