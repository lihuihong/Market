package com.market.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.market.entity.MarketConfigure;
import com.market.entity.MarketData;
import com.market.entity.MarketVehicle;
import com.market.entity.Result;
import com.market.services.ConfigService;
import com.market.services.DataService;
import com.market.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/more")
public class MoreController {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private DataService dataService;

	@Autowired
	private ConfigService configService;

	/**
	 * 单纯的页面跳转
	 *
	 *            页面名称，即jsp文件名
	 * @return
	 */
	@RequestMapping(value = "/addCompare")
	@ResponseBody
	public Result page(Integer vehicleId) {

		MarketVehicle vehicle = vehicleService.selectById(vehicleId);
		MarketData data = dataService.selectByVehicleId(vehicleId);
		MarketConfigure configure = configService.selectByVehicleId(vehicleId);

		Map<String,Object> map = new HashMap<>();

		map.put("vehicle",vehicle);
		map.put("data",data);
		map.put("configure",configure);

		Result result = new Result();

		result.setSuccess("成功");
		result.setData(map);
		result.setCount(1);
		return result;
	}


}
