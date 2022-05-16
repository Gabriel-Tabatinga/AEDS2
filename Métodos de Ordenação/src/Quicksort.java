
public class Quicksort {

	public Series[] vetor;
	private int esq;
	private int dir;
	public int movimentacoes = 0;
	public int comparacoes = 0;
	
	
	Quicksort(Series vetor[], int n){
		this.vetor = vetor;
		this.esq = 0;
		this.dir = n-1;
	}
	
	public void sort(){
		quicksort(vetor, esq, dir);
	}
	
	private void quicksort(Series[] vetor, int esq, int dir) {
				
		int part;
		if (esq < dir){
			part = particao(vetor, esq, dir);
			quicksort(vetor, esq, part - 1);
			quicksort(vetor, part + 1, dir);
		}
	}
					
	private int particao(Series[] vetor, int inicio, int fim) {
			
		Series pivot = vetor[fim];
		int part = inicio - 1;
		for (int i = inicio; i < fim; i++) {
			if (vetor[i].getNumberEpisodes() < pivot.getNumberEpisodes()) {
				part++;
				swap(vetor, part, i);
				comparacoes++;
			}else if(vetor[i].getNumberEpisodes() == pivot.getNumberEpisodes()) {
				if (vetor[i].getName().compareTo(pivot.getName())< 0) {
					part++;
					swap(vetor, part, i);
					comparacoes++;
				}
			}
		}
		part++;
		swap(vetor, part, fim);
		return (part);
	}
		
	private void swap(Series[] vetor, int i, int j) {
		      
		Series temp = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = temp;
		movimentacoes++;
	}
	

}
