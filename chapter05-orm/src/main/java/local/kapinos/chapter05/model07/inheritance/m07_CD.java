package local.kapinos.chapter05.model07.inheritance;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("C")
public class m07_CD  extends m07_Item {
	private String musicCompany;
	private Integer numberOfCDs;
	private Float totalDuration;
	private String genre;
	// Constructors, getters, setters
	public m07_CD() {
	}
	public m07_CD(String title, Float price, String description, String musicCompany, Integer numberOfCDs, Float totalDuration, String genre) {
		super(title, price, description);
		this.musicCompany = musicCompany;
		this.numberOfCDs = numberOfCDs;
		this.totalDuration = totalDuration;
		this.genre = genre;
	}
	public String getMusicCompany() {
		return musicCompany;
	}
	public void setMusicCompany(String musicCompany) {
		this.musicCompany = musicCompany;
	}
	public Integer getNumberOfCDs() {
		return numberOfCDs;
	}
	public void setNumberOfCDs(Integer numberOfCDs) {
		this.numberOfCDs = numberOfCDs;
	}
	public Float getTotalDuration() {
		return totalDuration;
	}
	public void setTotalDuration(Float totalDuration) {
		this.totalDuration = totalDuration;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
