package com.taxation.bureau.service;

import com.taxation.bureau.exception.ServiceException;
import com.taxation.bureau.po.Shop;

public interface ShopServiceI {
	
	public Shop save(Shop agent) throws ServiceException;
	
}
