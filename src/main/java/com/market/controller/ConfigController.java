package com.market.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.market.entity.MarketConfigure;
import com.market.entity.MarketData;
import com.market.entity.Result;
import com.market.services.ConfigService;
import com.market.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/config")
public class ConfigController {

	@Autowired
	private ConfigService configService;

	/**
	 * 单纯的页面跳转
	 *
	 * 页面名称，即jsp文件名
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Result page(Integer page, Integer limit, MarketConfigure marketConfigure) {

		Page pageBean = new Page(page,limit);
		List<MarketConfigure> marketConfigures= configService.selectList(marketConfigure);
		PageInfo<MarketConfigure> pageInfo = new PageInfo<>(marketConfigures);

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
	public Result save(MarketConfigure marketConfigure) {

		if(marketConfigure.getConfigureId() == null){
			configService.insertSelective(marketConfigure);
		}else{
			configService.updateByPrimaryKeySelective(marketConfigure);
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

		configService.deleteByPrimaryKey(id);

		Result result = new Result();
		result.setSuccess("成功");
		return result;
	}


}
