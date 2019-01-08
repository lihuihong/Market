package com.market.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.market.entity.MarketQuestion;
import com.market.entity.MarketSurvey;
import com.market.entity.Result;
import com.market.services.QuestionService;
import com.market.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	/**
	 * 单纯的页面跳转
	 *
	 *            页面名称，即jsp文件名
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Result page(Integer page, Integer limit,MarketQuestion marketQuestion) {

		Page pageBean = new Page(page,limit);
		List<MarketQuestion> questions= questionService.selectList(marketQuestion);
		PageInfo<MarketQuestion> pageInfo = new PageInfo<>(questions);

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
	public Result save(MarketQuestion marketQuestio) {

		if(marketQuestio.getQuestionId() == null){

			marketQuestio.setQuestionTime(new Date());

			questionService.insertSelective(marketQuestio);
		}else{
			questionService.updateByPrimaryKeySelective(marketQuestio);
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

		questionService.deleteByPrimaryKey(id);

		Result result = new Result();
		result.setSuccess("成功");
		return result;
	}


}
