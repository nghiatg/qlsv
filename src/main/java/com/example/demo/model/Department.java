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
@Table(name = "Khoa")
public class Department {
	@Id
	@Column(name = "MaKhoa")
	private String departmentId;

	@Column(name = "TenKhoa")
	private String departmentName;

	@Column(name = "DiaChi")
	private String departmentAddress;

	@Column(name = "DienThoai")
	private String departmentPhone;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TheClass> allClasses;

	/**
	 * 
	 */
	public Department() {
		super();
	}

	/**
	 * @param departmentId
	 * @param departmentName
	 * @param departmentAddress
	 * @param departmentPhone
	 * @param allClasses
	 */
	public Department(String departmentId, String departmentName, String departmentAddress, String departmentPhone,
			List<TheClass> allClasses) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.departmentPhone = departmentPhone;
		this.allClasses = allClasses;
	}

	/**
	 * @return the departmentId
	 */
	public String getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the departmentAddress
	 */
	public String getDepartmentAddress() {
		return departmentAddress;
	}

	/**
	 * @param departmentAddress the departmentAddress to set
	 */
	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}

	/**
	 * @return the departmentPhone
	 */
	public String getDepartmentPhone() {
		return departmentPhone;
	}

	/**
	 * @param departmentPhone the departmentPhone to set
	 */
	public void setDepartmentPhone(String departmentPhone) {
		this.departmentPhone = departmentPhone;
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

		Department that = (Department) o;
		return departmentId.equals(that.getDepartmentId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentId);
	}

}
