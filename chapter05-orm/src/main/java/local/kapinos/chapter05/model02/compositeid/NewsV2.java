package local.kapinos.chapter05.model02.compositeid;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(NewsIdV2.class)
public class NewsV2 {
	@Id
	private String title;
	@Id
	private String language;
	
	private String content;

	// Constructors, getters, setters
	
	public NewsV2() {
	}
	public NewsV2(String title, String language, String content) {
		this.title = title;
		this.language = language;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}