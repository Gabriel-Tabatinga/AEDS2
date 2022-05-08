
public class Pilha {
	private int tamanho;
	private Series[] array;
	
	public pilha(int tamanho){
		array = new Series[tamanho];
		this.tamanho = 0;
		
	}
	
	public void AddSeries(String name, String format, String duration, String country, String language, String broadcaster, String dateBeggin, int numberSeasons, int numberEpisodes) {
		Series novaSerie;
		novaSerie = new Series(name, format, duration, country, language, broadcaster, dateBeggin, numberSeasons, numberEpisodes);
		
	}
	
	public boolean empilha(Serie item) {
		if (tamanho < array.length) {
			array[tamanho] = item;
			tamanho++;
			return true;
		}
		return false;
	}

	public Serie desempilha() {
		if (tamanho > 0) {
			return Series[tamanho].getName;
			tamanho--;
		}
		return null;
	}

	public void mostrar() {
		int k=0;
		for (int i = tamanho-1; i >= 0; i--) {
            array[i].printClass(k);
            k++;
		}
	}

	public boolean pesquisar(Serie item) {
		for (int i = 0; i < tamanho; i++)
			if (array[i].equals(item))
				return true;
		return false;
	}
	
}
