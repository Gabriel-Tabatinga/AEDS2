
public class Bubblesort {
	
	private Series vetor[];
	private int n;
	
	Bubblesort(Series vetor[], int n){
		this.vetor = vetor;
		this.n = n;
	}
	
	public void sort() {
		for (int i = (n - 1); i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (vetor[j] > vetor[j + 1]) {
						int temp = vetor[j];
						vetor[j] = vetor[j+1];
	      				vetor[j+1] = temp;
				}
			}
		}
	}
}
