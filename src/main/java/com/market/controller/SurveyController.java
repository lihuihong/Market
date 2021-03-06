package com.market.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.market.entity.MarketSurvey;
import com.market.entity.Result;
import com.market.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/survey")
public class SurveyController {

	@Autowired
	private SurveyService surveyService;

	/**
	 *
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Result page(Integer page,Integer limit,MarketSurvey marketSurvey) {

		Page pageBean = new Page(page,limit);
		List<MarketSurvey> marketSurveys= surveyService.selectList(marketSurvey);
		PageInfo<MarketSurvey> pageInfo = new PageInfo<>(marketSurveys);

		Result result = new Result();
		result.setSuccess("成功");
		result.setData(pageInfo.getList());
		result.setCount((int) pageInfo.getTotal());

		return result;
	}


	@RequestMapping(value = "/findAll")
	@ResponseBody
	public Result page(MarketSurvey marketSurvey) {

		List<MarketSurvey> marketSurveys= surveyService.selectList(marketSurvey);

		Result result = new Result();
		result.setSuccess("成功");
		result.setData(marketSurveys);
		result.setCount(marketSurveys.size());

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
	public Result save(MarketSurvey marketSurvey) {

		if(marketSurvey.getSurveyId() == null){

			marketSurvey.setSurveyTime(new Date());

			surveyService.insertSelective(marketSurvey);
		}else{
			surveyService.updateByPrimaryKeySelective(marketSurvey);
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

		surveyService.deleteByPrimaryKey(id);

		Result result = new Result();
		result.setSuccess("成功");
		return result;
	}


}
