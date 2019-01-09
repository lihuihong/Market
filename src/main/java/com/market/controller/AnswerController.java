package com.market.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.market.entity.MarketAnswer;
import com.market.entity.MarketQuestion;
import com.market.entity.Result;
import com.market.services.AnswerService;
import com.market.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	/**
	 * 单纯的页面跳转
	 *
	 *            页面名称，即jsp文件名
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Result page(Integer page, Integer limit, MarketAnswer marketAnswer) {

		Page pageBean = new Page(page,limit);
		List<MarketAnswer> answers= answerService.selectList(marketAnswer);
		PageInfo<MarketAnswer> pageInfo = new PageInfo<>(answers);

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
	public Result save(MarketAnswer marketAnswer) {

		if(marketAnswer.getQuestionId() == null){

			marketAnswer.setAnswerTime(new Date());

			answerService.insertSelective(marketAnswer);
		}else{
			answerService.updateByPrimaryKeySelective(marketAnswer);
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

		answerService.deleteByPrimaryKey(id);

		Result result = new Result();
		result.setSuccess("成功");
		return result;
	}


}
