package com.taxation.bureau.po;

public class Shop {
	
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
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", lessor=" + lessor + ", user=" + user
				+ ", businessSign=" + businessSign + ", measure=" + measure
				+ ", taxYear=" + taxYear + ", taxHasPay=" + taxHasPay
				+ ", shopName=" + shopName + ", lng=" + lng + ", lat=" + lat
				+ ", province=" + province + ", city=" + city + ", district="
				+ district + ", street=" + street + ", streetNumber="
				+ streetNumber + "]";
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLessor() {
		return lessor;
	}
	public void setLessor(String lessor) {
		this.lessor = lessor;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getBusinessSign() {
		return businessSign;
	}
	public void setBusinessSign(String businessSign) {
		this.businessSign = businessSign;
	}
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	public String getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}
	public String getTaxHasPay() {
		return taxHasPay;
	}
	public void setTaxHasPay(String taxHasPay) {
		this.taxHasPay = taxHasPay;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

}
