
public class Insertion {
	
	public Series[] vetor;
	private int n;
	public int movimentacoes = 0;
	public int comparacoes = 0;
	
	Insertion(Series vetor[], int n){
		this.vetor = vetor;
		this.n = n;
	}
	
	
	public void sort() {
		for (int i = 1; i < n; i++) {
			Series tmp = vetor[i];
	         	int j = i - 1;

	         	while ((j >= 0) && (vetor[j].getBroadcaster().compareTo(tmp.getBroadcaster()) > 0)) {
		         		comparacoes++;	
		         		vetor[j + 1] = vetor[j];
			            j--;
			            movimentacoes++;
		         	
	         	}
	         	while ((j >= 0) && (vetor[j].getBroadcaster().compareTo(tmp.getBroadcaster()) == 0) && (vetor[j].getName().compareTo(tmp.getName()) > 0)) {
	         		
         			comparacoes++;
	         		vetor[j + 1] = vetor[j];
		            j--;
		            movimentacoes++;
	         		
	         		
	         	
         	}
	         	
	         	vetor[j + 1] = tmp;
	         	movimentacoes++;
	      	}
	}
}
