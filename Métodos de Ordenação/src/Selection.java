
public class Selection {

	private Series vetor[];
	private int n;
	
	Selection(Series vetor[], int n){
		this.vetor = vetor;
		this.n = n;
	}
	
	void sort() {
		for (int i = 0; i < (n - 1); i++) {
	        	int menor = i;
	         	for (int j = (i + 1); j < n; j++) {
	            		if (vetor[menor] > vetor[j]) {
	               			menor = j;
	            		}
	         	}
	      		int temp = vetor[i];
	      		vetor[i] = vetor[menor];
	      		vetor[menor] = temp;
	      	}
	}
}
