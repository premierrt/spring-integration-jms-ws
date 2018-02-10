package rt.eureka.model;

import java.io.Serializable;

/**
 * https://docs.spring.io/spring-integration/reference/html/messaging-transformation-chapter.html
 * http://www.enterpriseintegrationpatterns.com/patterns/messaging/CanonicalDataModel.html
 * @author rafal
 *
 */
public class CustomerCanonical implements Serializable {
	private int id;
	private String name;
	private int yearOfBirth;
	private String adress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "CustomerCanonical [id=" + id + ", name=" + name + ", yearOfBirth=" + yearOfBirth + ", adress=" + adress
				+ "]";
	}
	
	
}
