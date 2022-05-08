
public class Pilha {
	private int tamanho;
	private Series[] serie;
	
	public VetorSeries(int tamanho){
		serie = new Series[tamanho];
		this.tamanho = tamanho;
		
	}
	
	public void AddSeries(String name, String format, String duration, String country, String language, String broadcaster, String dateBeggin, int numberSeasons, int numberEpisodes) {
		Series novaSerie;
		novaSerie = new Series(name, format, duration, country, language, broadcaster, dateBeggin, numberSeasons, numberEpisodes);
		
	}
}
