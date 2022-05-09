
public class Quicksort {

	private Series vetor[];
	private int esq;
	private int dir;
	
	
	Quicksort(Series vetor[], int n){
		this.vetor = vetor;
		this.esq = 0;
		this.dir = n-1;
	}
	


	/**
	* Algoritmo de ordenação Quicksort.
	* @param int esq: início da partição a ser ordenada
	* @param int dir: fim da partição a ser ordenada
	*/
	public void quicksort() {
				
		int part;
		if (esq < dir){
			part = particao(vetor, esq, dir);
			quicksort(vetor, esq, part - 1);
			quicksort(vetor, part + 1, dir);
		}
	}
					
	private int particao(int[] vetor, int inicio, int fim) {
			
		int pivot = vetor[fim];
		int part = inicio - 1;
		for (int i = inicio; i < fim; i++) {
			if (vetor[i] < pivot)) {
				part++;
				swap(vetor, part, i);
			}
		}
		part++;
		swap(vetor, part, fim);
		return (part);
	}
		
	private void swap(int[] vetor, int i, int j) {
		      
		int temp = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = temp;
	}

}
