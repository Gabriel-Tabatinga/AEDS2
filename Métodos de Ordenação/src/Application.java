public class Application {

	public static void main(String[] args) {
		String input;
		Series serie;
		Series[] fila = new Series[99];
		
		
		long startTime = System.nanoTime();
        int u = 0;
		
		ArquivoTextoLeitura bancoDeDados = null;
		try {
			bancoDeDados = new ArquivoTextoLeitura/*("/tmp/data.txt");*/("data.txt");
		} catch (Exception e) {;}
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
			serie.setNumberDuration();
			fila[u] = serie;
			u++;
			input = bancoDeDados.ler();
		}
		bancoDeDados.fecharArquivo();
		MyIO.setCharset("UTF-8");
		String primeiraLinha;
		primeiraLinha = MyIO.readLine();
		String entrada;
		int n = Integer.parseInt(primeiraLinha);
		Series[] sort = new Series[n];
		
		//System.out.println(n);
		
		for(int i=0; i<=n-1;i++) {
			sort[i] = new Series();
			entrada = MyIO.readLine();
			//System.out.println(entrada);
			for(int j =0;j<u;j++) {
		    	if(entrada.equals(fila[j].getName()))
		    		{
		    			sort[i] = fila[j];
		    			j=u;
		    		}
		    }
		}
		/*
		for(int i=0;i<n;i++) {
			sort[i].printClass();
			System.out.println(i);
		}*/

		
		Insertion insert = new Insertion(sort, n);
		insert.sort();
	    
		  
		
		long endTime = System.nanoTime();
		long duration = (endTime-startTime);
		
		for(int i=0;i<n;i++) {
			sort[i].printClass();
		}
		
		ArquivoTextoEscrita saidaBolha;

		saidaBolha = new ArquivoTextoEscrita("729636_insercao.txt");


		saidaBolha.escrever("729636" + "\t" + duration + "\t" + insert.comparacoes + "\t" + insert.movimentacoes);
        saidaBolha.fecharArquivo();
	}

}
