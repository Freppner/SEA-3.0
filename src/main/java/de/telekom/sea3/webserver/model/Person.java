package de.telekom.sea3.webserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity  // entspricht der "Zeile" in der Datenbanktabelle
@Table(name="persons")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // entspricht dem autoincrement in der Datenbank, CREATE TABLE ... ( ID BIGINT PRIMARY KEY AUTO_INCREMENT, ... )
	private long id;
	@Version
	private  long version;
	@Column
	private String anrede;
	@Column
	private String vorname;
	@Column
	private String nachname;
	@Column
	private String bday;
	@Column
	private String str; 
	@Column
	private String hausnr; 
	@Column
	private String plz; 
	@Column
	private String ort; 
	@Column
	private String email;

	
	//CREATE TABLE persons ( ID integer primary key, ANREDE VARCHAR(10), VORNAME VARCHAR(20), NACHNAME VARCHAR(20), STR VARCHAR(40), HAUSNR VARCHAR(5), PLZ VARCHAR(5), ORT VARCHAR(20), EMAIL VARCHAR(40));
	//CREATE TABLE persons ( ID bigint primary key NOT NULL AUTO_INCREMENT, VERSION BIGINT NOT NULL DEFAULT 1, ANREDE VARCHAR(10), VORNAME VARCHAR(20), NACHNAME VARCHAR(20),BDAY DATE, STR VARCHAR(40), HAUSNR VARCHAR(5), PLZ VARCHAR(5), ORT VARCHAR(20), EMAIL VARCHAR(40));
	
	
	public Person(Long id, String anrede, String vorname, String nachname, String bday,
			String str,  String hausnr, String plz, String ort, String email ) {
		this.id = id;
		this.anrede = anrede;
		this.vorname = vorname;
		this.nachname = nachname;
		this.bday= bday;
		this.str = str;
		this.hausnr = hausnr;
		this.plz = plz;
		this.ort = ort;
		this.email = email;
	}
	
	
	public Person () {
		
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public long getVersion() {
		return version;
	}
	
	
	public void setVersion(long version) {
		this.version = version;
	}
	
	
	
	
	public String getAnrede() {
		return anrede;
	}
	
	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	public String getVorname() {
		return vorname;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public String getBday() {
		return bday;
	}
	
	public void setBday(String bday) {
		this.bday = bday;
	}
		

	public String getStr() {
		return str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
	public String getHausnr() {
		return hausnr;
	}
	
	public void setHausnr(String hausnr) {
		this.hausnr = hausnr;
	}
	
	public String getPlz() {
		return plz;
	}
	
	public void setPlz(String plz) {
		this.plz = plz;
	}
	
	public String getOrt() {
		return ort;
	}
	
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
