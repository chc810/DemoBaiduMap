package com.taxation.bureau.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tshop")
public class Tshop {
	private String id;
	
	private String lessor;   //出租人
	private String user;    //使用人
	private String businessSign;  //营业牌照
	private String measure;     //商铺占用面积
	private String taxYear;     //年应交税额
	private String taxHasPay;    //已交税额
	
	@Id
	@Column(name = "ID", nullable = false, length = 36)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "LESSOR", nullable = false, length = 36)
	public String getLessor() {
		return lessor;
	}
	public void setLessor(String lessor) {
		this.lessor = lessor;
	}
	@Column(name = "USER", nullable = false, length = 36)
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Column(name = "BUSINESS_SIGN", nullable = false, length = 36)
	public String getBusinessSign() {
		return businessSign;
	}
	public void setBusinessSign(String businessSign) {
		this.businessSign = businessSign;
	}
	@Column(name = "MEASURE", nullable = false, length = 36)
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	@Column(name = "TAX_YEAR", nullable = false, length = 36)
	public String getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}
	@Column(name = "TAX_HAS_PAY", nullable = false, length = 36)
	public String getTaxHasPay() {
		return taxHasPay;
	}
	public void setTaxHasPay(String taxHasPay) {
		this.taxHasPay = taxHasPay;
	}
	
	
	
}
