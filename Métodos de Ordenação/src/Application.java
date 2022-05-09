public class Application {

	public static void main(String[] args) {
		String input;
		Series serie;
		Fila fila = new Fila(40);
		
		ArquivoTextoLeitura bancoDeDados;
		bancoDeDados = new ArquivoTextoLeitura("/tmp/data.txt");
		input = bancoDeDados.ler();
		input = bancoDeDados.ler();
		
		while(input != null) {
			
			String[] r = input.split (";");
			serie = new Series();
			if(r[0] != null)
				serie.setName(r[0]);
			if(r[1] != null)
				serie.setFormat(r[1]);
			if(r[2] != null)
				serie.setDuration(r[2]);
			if(r[3] != null)
				serie.setCountry(r[3]);
			if(r[4] != null)
				serie.setLanguage(r[4]);
			if(r[5] != null)
				serie.setBroadcaster(r[5]);
			if(r[6] != null)
				serie.setDateBeggin(r[6]);
			if(r[7] != null)
				serie.setNumberSeasons(Integer.parseInt(r[7]));
			if(r[8] != null)
				serie.setNumberEpisodes(Integer.parseInt(r[8]));
			try {
				fila.enfileirar(serie);
			} catch (Exception e) {;}
			input = bancoDeDados.ler();
		}
		bancoDeDados.fecharArquivo();
		
		String entrada;
		entrada = MyIO.readLine();
		
		
		

	}

}
