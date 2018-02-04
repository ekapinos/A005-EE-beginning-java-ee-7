package local.kapinos.chapter05.model02.compositeid;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class News {
	@EmbeddedId
	private NewsId id;
	private String content;
	
	// Constructors, getters, setters
	
	public News() {
	}
	public News(NewsId id, String content) {
		this.id = id;
		this.content = content;
	}
	public NewsId getId() {
		return id;
	}
	public void setId(NewsId id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}