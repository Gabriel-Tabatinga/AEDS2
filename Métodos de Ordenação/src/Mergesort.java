
public class Mergesort {

	private Series[] vetor;
	private int esq;
	private int dir;
	
	
	Mergesort(Series vetor[], int n){
		this.vetor = vetor;
		this.esq = 0;
		this.dir = n-1;
	}
	
	/**
	* Algoritmo de ordenação Mergesort.
	* @param int esq: início do vetor a ser ordenado
	* @param int dir: fim do vetor a ser ordenado
	*/
	// 1.a chamada do método mergesort: esq: 0; dir: vetor.length - 1
	public void mergesort() {
		if (esq < dir) {
			int meio = (esq + dir) / 2;
			mergesort(vetor, esq, meio);
			intercalar(vetor, esq, meio, dir);
	      	}
	}

	/**
	* Algoritmo que intercala os elementos localizados entre as posições esq e dir
	* @param int esq: início do vetor a ser ordenado
	* @param int meio: posição do meio do vetor a ser ordenado
	* @param int dir: fim do vetor a ser ordenado
	*/ 
	private void intercalar(int[] vetor, int esq, int meio, int dir) {

		int n1, n2, i, j, k;

	      	//Definir tamanho dos dois subvetors
	      	n1 = meio - esq + 1;
	      	n2 = dir - meio;

	      	int[] a1 = new int[n1];
	      	int[] a2 = new int[n2];

	      	//Inicializar primeiro subvetor
	      	for (i = 0; i < n1; i++) {
	        	a1[i] = vetor[esq + i];
	      	}

	      	//Inicializar segundo subvetor
	      	for (j = 0; j < n2; j++) {
	        	a2[j] = vetor[meio + j + 1];
	      	}

		//Intercalação propriamente dita
	      	for (i = j = 0, k = esq; (i < n1 && j < n2); k++) {
	        	if (a1[i] <= a2[j])
				vetor[k] = a1[i++];
			else
				vetor[k] = a2[j++];
	      	}
		
		if (i == n1)
			for (; k <= dir; k++) {
		    		vetor[k] = a2[j++];
		    	}
		else
		    	for (; k <= dir; k++) {
		    		vetor[k] = a1[i++];
		    	}
	}

}
