/**
 * 
 */
package com.example.demo.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@Table(name = "HeDt")
public class EducationSystem {
	@Id
	@Column(name = "MaHeDT")
	private String systemId;

	@Column(name = "TenHeDT")
	private String systemName;

	@OneToMany(mappedBy = "eduSystem", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TheClass> allClasses;

	/**
	 * 
	 */
	public EducationSystem() {
		super();
	}

	/**
	 * @param systemId
	 * @param systemName
	 * @param allClasses
	 */
	public EducationSystem(String systemId, String systemName, List<TheClass> allClasses) {
		super();
		this.systemId = systemId;
		this.systemName = systemName;
		this.allClasses = allClasses;
	}

	/**
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}

	/**
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/**
	 * @return the systemName
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * @param systemName the systemName to set
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	/**
	 * @return the allClasses
	 */
	public List<TheClass> getAllClasses() {
		return allClasses;
	}

	/**
	 * @param allClasses the allClasses to set
	 */
	public void setAllClasses(List<TheClass> allClasses) {
		this.allClasses = allClasses;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		EducationSystem that = (EducationSystem) o;
		return systemId.equals(that.getSystemId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(systemId);
	}

}
