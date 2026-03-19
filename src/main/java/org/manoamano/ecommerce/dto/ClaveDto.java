package org.manoamano.ecommerce.dto;

public class ClaveDto {

	private String clave;
	private String nclave;

	public ClaveDto(String clave, String nclave) {
		super();
		this.clave = clave;
		this.nclave = nclave;
	}// Constructor

	public ClaveDto() {
	}// Constructor - empty

	public String getClave() {
		return clave;
	}// getClave

	public void setClave(String clave) {
		this.clave = clave;
	}// setClave

	public String getNclave() {
		return nclave;
	}// getNclave

	public void setNclave(String nclave) {
		this.nclave = nclave;
	}// setNclave

	@Override
	public String toString() {
		return "ClaveDto [clave=" + clave + ", nclave=" + nclave + "]";
	}// toString

}// ClaveDto