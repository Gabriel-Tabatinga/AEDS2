
public class Selection {

	public Series[] vetor;
	private int n;
	public int movimentacoes = 0;
	public int comparacoes = 0;
	
	Selection(Series vetor[], int n){
		this.vetor = vetor;
		this.n = n;
	}
	
	void sort() {
		for (int i = 0; i < (n - 1); i++) {
	        	int menor = i;
	         	for (int j = (i + 1); j < n; j++) {
	            		if (vetor[menor].getName().compareTo(vetor[j].getName()) > 0) {
	               			menor = j;
	               			comparacoes++;
	            		}
	         	}
	      		Series temp = vetor[i];
	      		vetor[i] = vetor[menor];
	      		vetor[menor] = temp;
	      		movimentacoes++;
	      	}
	}
}
