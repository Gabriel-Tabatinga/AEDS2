
public class Application {

	public static void main(String[] args) {
		String input;
		Series serie;
		Pilha pilha = new Pilha(50);
		MyIO.setCharset(“UTF-8”);
		

        ArquivoTextoLeitura(/tmp/series/data.txt);
		input = ler();
		
		while(!input.equals("FIM")) {
	            String[] r = input.split (";");
				serie = new Series();
				serie.setName(r[0]);
				serie.setFormat(r[1]);
				serie.setDuration(r[2]);
				serie.setCountry(r[3]);
				serie.setLanguage(r[4]);
				serie.setBroadcaster(r[5]);
				serie.setDateBeggin(r[6]);
				serie.setNumberSeasons(Integer.parseInt(r[7]));
				serie.setNumberEpisodes(Integer.parseInt(r[8]));        
			
			pilha.empilhar(serie);
			input = ler();
		}
		int tam=Integer.parseInt(input);
		input = ler();
		String desemp;
		
		
		for(i=0;i<=tam;i++) {
			if(input == 'D') {
				desemp=pilha.desempilhar();
				System.out.println("(D) "+ desemp);
			}else if(input == 'E') {
				serie = new Series();
				pilha.empilhar(serie);
			}
			input = ler();
		}

		fecharArquivo();
		
		
		pilha.mostrar;

	}

}

