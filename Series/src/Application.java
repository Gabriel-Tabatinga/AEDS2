
public class Application {

	public static void main(String[] args) {
		String input;
		Series serie;
		
		input = MyIO.readLine();
		
		while(!input.equals("FIM")) {
			
			String[] r = input.split (";");
			serie = new Series(r[0], r[1], r[2], r[3], r[4], r[5], r[6], Integer.parseInt(r[7]), Integer.parseInt(r[8]));
			input = MyIO.readLine();
		}

	}

}

