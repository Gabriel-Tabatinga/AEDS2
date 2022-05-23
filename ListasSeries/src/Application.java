public class Application {

	public static void main(String[] args) throws Exception {
		String input;
		Series serie;
		Series[] fila = new Series[99];
		
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
		
		
		
		ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
		String entrada = MyIO.readLine();
		
		while(!entrada.equals("FIM")) {
			
			for(int j =0;j<u;j++) {
		    	if(entrada.equals(fila[j].getName()))
		    		{
		    			lista.inserirFim(fila[j]);
		    			j=u;
		    		}
		    }
			
			entrada = MyIO.readLine();
		}
		
		
		
		entrada = MyIO.readLine();
		int n = Integer.parseInt(entrada);
		Series[] r = new Series[n];
		int i = 0;
		//System.out.println(n);
		
		for(int q=0;q<n;q++) {
			entrada = MyIO.readLine();
			String[] entradaSeparada = entrada.split(" ", 2);
			
			
			switch (entradaSeparada[0]) {

				case "II": //Inserir inicio
					for(int j =0;j<u;j++) {
				    	if(entradaSeparada[1].equals(fila[j].getName()))
				    		{
				    			lista.inserirInicio(fila[j]);
				    			j=u;
				    		}
				    }
					break;
				case "I*": //Inserir determinada posicao
					String[] posicao = entradaSeparada[1].split(" ", 2);
					for(int j=0;j<u;j++) {
				    	if(posicao[1].equals(fila[j].getName()))
				    		{
				    			lista.inserir(fila[j], Integer.parseInt(posicao[0]));
				    			j=u;
				    		}
				    }
					break;
					
				case "IF": //Inserir final
					for(int j =0;j<u;j++) {
				    	if(entradaSeparada[1].equals(fila[j].getName()))
				    		{
				    			lista.inserirFim(fila[j]);
				    			j=u;
				    		}
				    }
					break;
					
				case "RI": //Remover inicio
					try {
						r[i] = lista.removerInicio();
						i++;
					} catch (Exception e) {;}
					break;
					
				case "R*": //Remover determinada posicao
					try {
						r[i] = lista.remover(Integer.parseInt(entradaSeparada[1]));
						i++;
					} catch (Exception e) {;}
					break;
					
				case "RF": //Remover final
					try {
						r[i] = lista.removerFim();
						i++;
					} catch (Exception e) {;}
					break;
			}
			
		}
		
		for(int p=0;p < i;p++) {
			System.out.println("(R) " + r[p].getName());
		}
		
		
		
		try {
			lista.mostrar();
		} catch (Exception e) {;}
	}

}
