
public class Series {
	
	private String name, format, duration, country, language, broadcaster, dateBeggin;
	private int numberSeasons, numberEpisodes;
	
	
	public Series(String name, String format, String duration, String country, String language, String broadcaster, String dateBeggin, int numberSeasons, int numberEpisodes) {
		setName(name);
		setFormat(format);
		setDuration(duration);
		setCountry(country);
		setLanguage(language);
		setBroadcaster(broadcaster);
		setDateBeggin(dateBeggin);
		setNumberSeasons(numberSeasons);
		setNumberEpisodes(numberEpisodes);
	}
	public Series() {
		setName("");
		setFormat("");
		setDuration("");
		setCountry("");
		setLanguage("");
		setBroadcaster("");
		setDateBeggin("");
		setNumberSeasons(0);
		setNumberEpisodes(0);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void printName() {
		System.out.print(name);
	}
	
	
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public void printFormat() {
		System.out.print(format);
	}
	
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public void printDuration() {
		System.out.print(duration);
	}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void printCountry() {
		System.out.print(country);
	}
	
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void printLanguage() {
		System.out.print(language);
	}
	
	
	public String getBroadcaster() {
		return broadcaster;
	}
	public void setBroadcaster(String broadcaster) {
		this.broadcaster = broadcaster;
	}
	public void printBroadcaster() {
		System.out.print(broadcaster);
	}
	
	
	public String getDateBeggin() {
		return dateBeggin;
	}
	public void setDateBeggin(String dateBeggin) {
		this.dateBeggin = dateBeggin;
	}
	public void printDateBeggin() {
		System.out.print(dateBeggin);
	}
	
	
	public int getNumberSeasons() {
		return numberSeasons;
	}
	public void setNumberSeasons(int numberSeasons) {
		this.numberSeasons = numberSeasons;
	}
	public void printNumberSeasons() {
		System.out.print(numberSeasons);
	}
	
	
	public int getNumberEpisodes() {
		return numberEpisodes;
	}
	public void setNumberEpisodes(int numberEpisodes) {
		this.numberEpisodes = numberEpisodes;
	}
	public void printNumberEpisodes() {
		System.out.print(numberEpisodes);
	}
	
	
}
