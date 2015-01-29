package com.taxation.bureau.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taxation.bureau.exception.ServiceException;
import com.taxation.bureau.po.AjaxPo;
import com.taxation.bureau.po.Shop;
import com.taxation.bureau.service.ShopServiceI;

@Controller
@RequestMapping("/shops/shopsController")
public class ShopsController extends BaseController{
	
	@Autowired
	@Qualifier("shopService")
	private ShopServiceI shopService;
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public String test() {
		return "hello";
	}
	
	@RequestMapping(value = "/addShop")
	@ResponseBody
	public AjaxPo addShop(Shop shop,HttpServletRequest request ,HttpServletResponse response) {
		logger.debug("进入ShopsController.addShop()......参数为:" + shop);
		AjaxPo ret = new AjaxPo(true, "成功");
		Integer id = shop.getId();
		if (id != null) {
			//修改
			shopService.update(shop);
			return ret;
		}
		Shop s = null;
		try {
			s = shopService.save(shop);
			ret.setObj(s);
		} catch (ServiceException e) {
			logger.error(e.getMessage());
			ret.setSuccess(false);
			ret.setMsg(e.getMessage());
			return ret;
		}
		return ret;
	}
	
	@RequestMapping(value = "/list")
	@ResponseBody
	public AjaxPo list(Shop shop, HttpServletRequest request ,HttpServletResponse response) {
		logger.debug("进入ShopsController.list()......");
		AjaxPo ret = new AjaxPo(true, "成功");
		List<Shop> list = null;
		try {
			list = shopService.list(shop);
			ret.setObj(list);
		} catch (ServiceException e) {
			logger.error(e.getMessage());
			ret.setSuccess(false);
			ret.setMsg(e.getMessage());
			return ret;
		}
		return ret;
	}

}
