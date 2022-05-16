
public class Bubblesort {
	
	private Series[] vetor;
	private int n;
	private int tamanho;
	private int comparacoes;
	private int movimentacoes;
	
	Bubblesort(Series vetor[], int n){
		this.vetor = vetor;
		this.n = n;
		this.tamanho = n;
		this.comparacoes = 0;
		this.movimentacoes = 0;
	}
	
	public void sort() {
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - 1 - i; j++) {
		    	  if(vetor[j].getName().compareTo(vetor[j + 1].getName()) > 0) {
		    		  Series aux = vetor[j];
		    		  vetor[j] = vetor[j + 1];
		    		  vetor[j + 1] = aux;
		    		  movimentacoes++;
		    	  }
		    	  comparacoes++;
			}
		}
	}
	
	public int getComparar() {
		return this.comparacoes;
	}
	
	public int getMovimentar() {
		return this.movimentacoes;
	}
	
	public void imprimir() {
		for(int i=0;i<tamanho;i++) {
			vetor[i].printClass();
		}
	}
}
