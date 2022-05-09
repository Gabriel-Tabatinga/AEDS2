import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;

public class Application{

	public static void main(String[] args) throws Exception{
		String input;
		Series serie;
		Pilha pilha = new Pilha(70);
		
		FileReader fileReader = new FileReader("/tmp/data.txt");
		
		BufferedReader buffReader = new BufferedReader(fileReader);
		try {
			input = buffReader.readLine();
		}catch (Exception erro) {;}
		
		
		
		input = buffReader.readLine();
		while((!input.equals("D")) && (!input.equals("E"))) {
			
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
			pilha.empilha(serie);
			input = buffReader.readLine();
		}
		
		int tam = Integer.parseInt(input);

		Series desemp;

		for(int i=0;i<=tam;i++) {
			if(input == "D") {
				desemp = pilha.desempilha();
				System.out.println("(D) "+ desemp.getName());
			}else if(input == "E") {
				serie = new Series();
				try{
					pilha.empilha(serie);
				}catch (Exception erro) {;}
			}
			try{
				input = buffReader.readLine();
			}catch (Exception erro) {;}
		}
		pilha.imprimir();
		try{
			buffReader.close();
		}catch (Exception erro) {;}

	}
	
}

