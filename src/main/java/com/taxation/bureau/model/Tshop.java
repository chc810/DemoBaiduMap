package com.taxation.bureau.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "tshop")
public class Tshop extends Tbase{
	
	private String lessor;   //出租人
	private String user;    //使用人
	private String businessSign;  //营业牌照
	private String measure;     //商铺占用面积
	private String taxYear;     //年应交税额
	private String taxHasPay;    //已交税额
	
	
	
}
