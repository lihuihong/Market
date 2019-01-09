package com.market.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.market.entity.MarketConfigure;
import com.market.entity.MarketProduction;
import com.market.entity.Result;
import com.market.services.ConfigService;
import com.market.services.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/production")
public class ProductionController {

	@Autowired
	private ProductionService productionService;

	/**
	 * 单纯的页面跳转
	 *
	 * 页面名称，即jsp文件名
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Result page(Integer page, Integer limit, MarketProduction marketProduction) {

		Page pageBean = new Page(page,limit);
		List<MarketProduction> marketProductions= productionService.selectList(marketProduction);
		PageInfo<MarketProduction> pageInfo = new PageInfo<>(marketProductions);

		Result result = new Result();

		result.setSuccess("成功");
		result.setData(pageInfo.getList());
		result.setCount((int) pageInfo.getTotal());
		return result;
	}


	/**
	 * 单纯的页面跳转
	 *
	 *            页面名称，即jsp文件名
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public Result save(MarketProduction marketProduction) {

		if(marketProduction.getProductionId() == null){
			productionService.insertSelective(marketProduction);
		}else{
			productionService.updateByPrimaryKeySelective(marketProduction);
		}

		Result result = new Result();
		result.setSuccess("成功");
		return result;
	}

	/**
	 * 单纯的页面跳转
	 *
	 *            页面名称，即jsp文件名
	 * @return
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Result del(Integer id) {

		productionService.deleteByPrimaryKey(id);

		Result result = new Result();
		result.setSuccess("成功");
		return result;
	}


}
