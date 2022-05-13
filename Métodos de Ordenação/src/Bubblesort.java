
public class Bubblesort {
	
	private Series[] vetor;
	private int n;
	private int tamanho;
	private int comparacoes;
	private int movimentacoes;
	
	Bubblesort(Series[] vetor, int n){
		this.vetor = vetor;
		this.n = n;
		this.tamanho = n;
		this.comparacoes = 0;
		this.movimentacoes = 0;
	}
	
	public void sort() {
		boolean houveTroca = true;
        for(int rep = 0; rep < n - 1 && houveTroca; rep++){
	        houveTroca = false;
	        for (int b = 0; b < n -(rep+1); b++)

                if (vetor[b].getNumberSeasons() > vetor[b+1].getNumberSeasons()){
                    Series aux = vetor[b];
                    vetor[b] = vetor[b + 1];
                    vetor[b + 1] = aux;
                    movimentacoes++;
			        houveTroca = true;
		        }

                else if(vetor[b].getNumberSeasons() == vetor[b+1].getNumberSeasons()){
                    if((vetor[b].getName()).compareTo(vetor[b + 1].getName())> 0){
                        Series aux = vetor[b];
                        vetor[b] = vetor[b + 1];
                        vetor[b + 1] = aux;
                        movimentacoes++;
                    }
                }
                comparacoes++;;
        }
	}
	
	public int getComparar() {
		return this.comparacoes;
	}
	
	public int getMovimentar() {
		return this.movimentacoes;
	}
	
	public void imprimir() {
		for(int i=0;i<tamanho;i++) {
			vetor[i].printClass();
		}
	}
}
