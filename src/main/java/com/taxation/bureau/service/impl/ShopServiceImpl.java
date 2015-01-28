package com.taxation.bureau.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.taxation.bureau.dao.ShopDaoI;
import com.taxation.bureau.exception.ServiceException;
import com.taxation.bureau.model.Tshop;
import com.taxation.bureau.po.Shop;
import com.taxation.bureau.service.ShopServiceI;

@Service("shopService")
public class ShopServiceImpl extends BaseService implements ShopServiceI {
	
	@Autowired
	@Qualifier("shopDao")
	private ShopDaoI shopDao;

	public Shop save(Shop shop) throws ServiceException {
		logger.debug("进入ShopServiceImpl.save()...");
		Tshop ts = new Tshop();
		BeanUtils.copyProperties(shop,ts);
		Tshop t = null;
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("businessSign", shop.getBusinessSign());
			String hql = "from Tshop t where t.businessSign = :businessSign";
			t = shopDao.get(hql, params);
		} catch (Exception e) {
			logger.error("查询数据库出错",e);
			throw new ServiceException("查询数据库错误");
		}
		if (t != null) {
			throw new ServiceException("营业牌照已经存在...");
		}
		
		try {
			shopDao.save(ts);
		} catch (Exception e) {
			logger.error("增加商铺失败",e);
			throw new ServiceException("增加商铺失败");
		}
		return shop;
	}
	
	public List<Shop> list(Shop shop) throws ServiceException {
		logger.debug("进入ShopServiceImpl.list()...");
		String hql = "from Tshop t where 1=1 ";
		Map<String, Object> params = new HashMap<String, Object>();
		hql = addWhere(shop, hql, params);
		List<Shop> nl = null;
		try {
			List<Tshop> l = shopDao.find(hql, params);
			nl = new ArrayList<Shop>();
			changeModel(l, nl);
		} catch (Exception e) {
			logger.error("操作数据库错误",e);
			throw new ServiceException("操作数据库错误");
		}
		return nl;
		
	}
	
	private String addWhere(Shop shop, String hql, Map<String, Object> params) {
		if (StringUtils.isNotBlank(shop.getStreet())) {
			hql += " and t.street = :street and t.district = :district and t.city = :city and t.province = :province";
			params.put("street", shop.getStreet());
			params.put("district", shop.getDistrict());
			params.put("city", shop.getCity());
			params.put("province", shop.getProvince());
		}
		return hql;
	}
	
	private void changeModel(List<Tshop> l, List<Shop> nl) {
		if (l != null && l.size() > 0) {
			for (Tshop t : l) {
				Shop u = new Shop();
				BeanUtils.copyProperties(t, u);
				nl.add(u);
			}
		}
	}

}
