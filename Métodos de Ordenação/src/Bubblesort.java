
public class Bubblesort {
	
	private Series[] vetor;
	private int n;
	private int tamanho;
	public int comparacoes;
	public int movimentacoes;
	
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
		    	 if(vetor[j] != null) {
		    		 if(vetor[j].getNumberDuration() > vetor[j + 1].getNumberDuration()) {
		   	          Series aux = new Series();
		   	          aux = vetor[j];
		   	          vetor[j] = vetor[j+1];
		   	          vetor[j + 1] = aux;
		   	          movimentacoes++;
		   	        }else if(vetor[j].getNumberDuration() == vetor[j+1].getNumberDuration()) {
						if (vetor[j].getName().compareTo(vetor[j+1].getName())> 0) {
							Series aux = vetor[j];
				    		vetor[j] = vetor[j + 1];
				    		vetor[j + 1] = aux;
				    		movimentacoes++;
						}
					}
		   	        comparacoes++;
		    	 }
		      }
		    }
	}
	
	
	public void imprimir() {
		for(int i=0;i<tamanho;i++) {
			vetor[i].printClass();
		}
	}
}
