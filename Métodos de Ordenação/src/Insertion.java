
public class Insertion {
	
	private Series[] vetor;
	private int n;
	
	Insertion(Series vetor[], int n){
		this.vetor = vetor;
		this.n = n;
	}
	
	
	public void sort() {
		for (int i = 1; i < n; i++) {
			int tmp = vetor[i];
	         	int j = i - 1;

	         	while ((j >= 0) && (vetor[j] > tmp)) {
	            		vetor[j + 1] = vetor[j];
	            		j--;
	         	}
	         	vetor[j + 1] = tmp;
	      	}
	}
}
