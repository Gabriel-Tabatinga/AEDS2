
public class Heapsort {
	
	public Series[] vetor;
	private int n;
	public int movimentacoes = 0;
	public int comparacoes = 0;
	
	Heapsort(Series vetor[], int n){
		this.vetor = vetor;
		this.n = n;
	}
	
	
	public void sort() {
	      	Series[] tmp = new Series[n + 1];
	      	for(int i = 0; i < n; i++) {
	        	tmp[i+1] = vetor[i];
	        	
	      	}
	      	vetor = tmp;

	      	//Contrucao do heap
	      	for(int tamHeap = 2; tamHeap <= n; tamHeap++) {
	        	constroi(vetor, tamHeap);
	      	}

	      	//Ordenacao propriamente dita
	      	int tamHeap = n;
	      	while(tamHeap > 1) {
	        	troca(vetor, 1, tamHeap--);
	         	reconstroi(vetor, tamHeap);
	      	}

	      	//Alterar o vetor para voltar à posição zero
	      	tmp = vetor;
	      	vetor = new Series[n];
	      	for(int i = 0; i < n; i++) {
	        	vetor[i] = tmp[i+1];
	        	
	      	}
	}

	void constroi(Series[] vetor, int tamHeap) {

		for(int i = tamHeap; i > 1 && vetor[i].getNumberSeasons() > vetor[i/2].getNumberSeasons(); i /= 2) {
	        	troca(vetor, i, i/2);
	        	comparacoes++;
	    }
	}

	void reconstroi(Series[] vetor, int tamHeap) {

		int i = 1;
	      	
		while(i <= (tamHeap/2)) {
	        	int filho = getMaiorFilho(vetor, i, tamHeap);
	        	if(vetor[i].getNumberSeasons() < (vetor[filho].getNumberSeasons())) {
	            		troca(vetor, i, filho);
	            		comparacoes++;
	            		i = filho;
	         	} else {
	            		i = tamHeap;
	         	}
	      	}
	}

	int getMaiorFilho(Series[] vetor, int i, int tamHeap) {

		int filho;

		if (2*i == tamHeap || vetor[2*i].getNumberSeasons() > vetor[2*i+1].getNumberSeasons() ) {
	        filho = 2*i;
		    comparacoes++;
	      	} else {
	        	filho = 2*i + 1;
	        	comparacoes++;
	      	}
	      	return filho;
	}

	void troca(Series[] vetor, int i, int j) {
		      
		Series temp = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = temp;
		movimentacoes++;
	}

}
