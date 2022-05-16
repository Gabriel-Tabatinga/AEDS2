
public class Mergesort {

	public Series[] vetor;
	private int esq;
	private int dir;
	public int movimentacoes = 0;
	public int comparacoes = 0;
	
	
	Mergesort(Series vetor[], int n){
		this.vetor = vetor;
		this.esq = 0;
		this.dir = n-1;
	}
	
	public void sort() {
		mergesort(vetor, esq, dir);
	}
	
	private void mergesort(Series[] vetor, int esq, int dir) {
		if (esq < dir) {
			int meio = (esq + dir) / 2;
			mergesort(vetor, esq, meio);
			intercalar(vetor, esq, meio, dir);
	      	}
	}

	
	private void intercalar(Series[] vetor, int esq, int meio, int dir) {

		int n1, n2, i, j, k;

	      	
	      	n1 = meio - esq + 1;
	      	n2 = dir - meio;

	      	Series[] a1 = new Series[n1];
	      	Series[] a2 = new Series[n2];

	  
	      	for (i = 0; i < n1; i++) {
	        	a1[i] = vetor[esq + i];
	        	movimentacoes++;
	      	}


	      	for (j = 0; j < n2; j++) {
	        	a2[j] = vetor[meio + j + 1];
	        	movimentacoes++;
	      	}


	      	for (i = j = 0, k = esq; (i < n1 && j < n2); k++) {
	        	if (a1[i].getName().compareTo(a2[j].getName()) <= 0)
				{vetor[k] = a1[i++];
	        	movimentacoes++;}
			else {
				vetor[k] = a2[j++];
			}
				
	        	movimentacoes++;
	        	comparacoes++;
	      	}
		
		if (i == n1)
			for (; k <= dir; k++) {
		    		vetor[k] = a2[j++];
		    		movimentacoes++;
		    	}
		else
		    	for (; k <= dir; k++) {
		    		vetor[k] = a1[i++];
		    		movimentacoes++;
		    	}
	}

}
