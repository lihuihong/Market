package com.market.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.market.entity.MarketData;
import com.market.entity.MarketVehicle;
import com.market.entity.Result;
import com.market.services.DataService;
import com.market.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/data")
public class DataController {

	@Autowired
	private DataService dataService;

	/**
	 * 单纯的页面跳转
	 *
	 * 页面名称，即jsp文件名
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Result page(Integer page, Integer limit, MarketData marketData) {

		Page pageBean = new Page(page,limit);
		List<MarketData> marketDatas= dataService.selectList(marketData);
		PageInfo<MarketData> pageInfo = new PageInfo<>(marketDatas);


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
	public Result save(MarketData marketData) {

		if(marketData.getVehicleId() == null){
			dataService.insertSelective(marketData);
		}else{
			dataService.updateByPrimaryKeySelective(marketData);
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

		dataService.deleteByPrimaryKey(id);

		Result result = new Result();
		result.setSuccess("成功");
		return result;
	}


}
