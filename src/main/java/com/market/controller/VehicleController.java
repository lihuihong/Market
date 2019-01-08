package com.market.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.market.entity.MarketVehicle;
import com.market.entity.Result;
import com.market.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	/**
	 * 单纯的页面跳转
	 *
	 *            页面名称，即jsp文件名
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Result page(Integer page,Integer limit,MarketVehicle marketvehicle) {

		Page pageBean = new Page(page,limit);
		List<MarketVehicle> marketvehicles= vehicleService.selectList(marketvehicle);
		PageInfo<MarketVehicle> pageInfo = new PageInfo<>(marketvehicles);


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
	@RequestMapping(value = "/findAll")
	@ResponseBody
	public Result page(MarketVehicle marketvehicle) {

		List<MarketVehicle> marketvehicles= vehicleService.selectList(marketvehicle);

		Result result = new Result();

		result.setSuccess("成功");
		result.setData(marketvehicles);
		result.setCount(marketvehicles.size());
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
	public Result save(MarketVehicle marketvehicle) {

		if(marketvehicle.getVehicleId() == null){
			vehicleService.insertSelective(marketvehicle);
		}else{
			vehicleService.updateByPrimaryKeySelective(marketvehicle);
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

		vehicleService.deleteByPrimaryKey(id);

		Result result = new Result();
		result.setSuccess("成功");
		return result;
	}


}
