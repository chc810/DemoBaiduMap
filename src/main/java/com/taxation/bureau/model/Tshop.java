package com.taxation.bureau.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tshop")
public class Tshop {
	private Integer id;
	
	private String lessor;   //出租人
	private String user;    //使用人
	private String businessSign;  //营业牌照
	private String measure;     //商铺占用面积
	private String taxYear;     //年应交税额
	private String taxHasPay;    //已交税额
	private String shopName;     //商铺名称
	

	//以下是地理位置信息
	private String lng;          //精度
	private String lat;          //维度
	private String province;     //省
	private String city;         //市
	private String district;     //区
	private String street;       //街道
	private String streetNumber;  //街道号码
	
	@Id
	@Column(name = "ID", nullable = false, length = 36)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "SHOP_NAME", nullable = false, length = 36)
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
	@Column(name = "LNG", nullable = false, length = 15)
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	@Column(name = "LAT", nullable = false, length = 15)
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	@Column(name = "PROVINCE", nullable = true, length = 36)
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Column(name = "CITY", nullable = true, length = 36)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "DISTRICT", nullable = true, length = 36)
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@Column(name = "STREET", nullable = true, length = 36)
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Column(name = "STREETNUMBER", nullable = true, length = 36)
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	
	
}
