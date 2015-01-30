package com.taxation.bureau.service;

import java.util.List;

import com.taxation.bureau.exception.ServiceException;
import com.taxation.bureau.po.Shop;

public interface ShopServiceI {
	
	public Shop save(Shop agent) throws ServiceException;
	
	public List<Shop> list(Shop shop) throws ServiceException;
	
	public Shop update(Shop shop) throws ServiceException;
	
	public Shop delete(Shop shop) throws ServiceException;
	
}
