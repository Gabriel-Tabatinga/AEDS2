
public class Pilha {
	private int tamanho;
	private Series[] array;
	
	
	public Pilha(){
		array = new Series[100];
		this.tamanho = 0;
	}
	
	public Pilha(int tamanho){
		array = new Series[tamanho];
		this.tamanho = 0;
		
	}
	
	
	public void AddSeries(String name, String format, String duration, String country, String language, String broadcaster, String dateBeggin, int numberSeasons, int numberEpisodes) {
		Series novaSerie;
		novaSerie = new Series(name, format, duration, country, language, broadcaster, dateBeggin, numberSeasons, numberEpisodes);
		array[tamanho] = novaSerie;
		tamanho++;
	}
	
	public void empilha(Series item) {
		array[tamanho] = item;
		tamanho++;
	}

	public Series desempilha() {
		Series desemp = new Series();
		desemp = array[tamanho-1];
		tamanho--;
		return desemp;
	}

	public void imprimir() {
		int k=0;
		for (int i = tamanho-1; i >= 0; i--) {
            array[i].printClass(k);
            k++;
		}
	}

	public boolean pesquisar(Series item) {
		for (int i = 0; i < tamanho; i++)
			if (array[i].equals(item))
				return true;
		return false;
	}
	
}
