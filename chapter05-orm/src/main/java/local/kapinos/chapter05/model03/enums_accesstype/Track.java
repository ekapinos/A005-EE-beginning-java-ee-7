package local.kapinos.chapter05.model03.enums_accesstype;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Track {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private Float duration;
	@Basic(fetch = FetchType.LAZY)
	@Lob
	private byte[] wav;
	@Column(name = "descr", nullable = false, length=500, updatable = false)
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Transient
	private Integer age;
	
	// Constructors, getters, setters
	
	public Track() {
	}	
	public Track(String title, Float duration, byte[] wav, String description) {
		this.title = title;
		this.duration = duration;
		this.wav = wav;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Float getDuration() {
		return duration;
	}
	public void setDuration(Float duration) {
		this.duration = duration;
	}
	public byte[] getWav() {
		return wav;
	}
	public void setWav(byte[] wav) {
		this.wav = wav;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
