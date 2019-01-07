package com.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	/**
	 * 单纯的页面跳转
	 * 
	 * @param name
	 *            页面名称，即jsp文件名
	 * @return
	 */
	@RequestMapping(value = "/page/{name}", method = RequestMethod.GET)
	public String page(@PathVariable String name) {
		return name;
	}

	/**
	 * 单纯的页面跳转
	 *
	 * 页面名称，即jsp文件名
	 *
	 * @return
	 */
	@RequestMapping(value = "/page/{model}/{fun}", method = RequestMethod.GET)
	public String page(@PathVariable String model, @PathVariable String fun) {
		return model + "/" + fun;
	}

	/**
	 * 单纯的页面跳转
	 *
	 * 页面名称，即jsp文件名
	 *
	 * @return
	 */
	@RequestMapping(value = "/page/{model}/{fun}/{file}", method = RequestMethod.GET)
	public String page(@PathVariable String model, @PathVariable String fun, @PathVariable String file) {
		return model + "/" + fun + "/" + file;
	}


	/**
	 * 跳转到主页面
	 * 
	 * @param session
	 * @param request
	 * @return
	 *//*
	@RequestMapping("/main")
	public String main(HttpSession session, HttpServletRequest request) {
		UserAdminEntity admin = (UserAdminEntity) session.getAttribute(Utils.SESSION_USER);

		Map<String, List<FunEntity>> roles = new LinkedHashMap<>();
		List<String> icons = new ArrayList<>();

		// 获取用户角色信息
		RoleEntity r = new RoleEntity();
		r.setId(admin.getrIdu());
		RspDataVo<RoleEntity> page = roleServiceImp.page(1, 1, r);
		if (page.getCount() > 0) {
			r = page.getData().get(0);
		}
		String funstr = r.getFunction();
		List<String> funs = Arrays.asList(funstr.split(","));
		// 获取所有模块和功能
		RspDataVo<FunEntity> modFun = funServiceImp.page(1, 200, new FunEntity());
		List<FunEntity> modAndFuns = modFun.getData();

		// 获取所有模块
		List<FunEntity> mods = modAndFuns.stream().filter(t -> t.getpId().equals(0)).collect(Collectors.toList());
		// 便利模块
		for (FunEntity mod : mods) {
			// 获取该模块下用户拥有的所有功能
			icons.add(mod.getIcon());
			List<FunEntity> functions = modAndFuns.stream()
					.filter(t -> t.getpId().equals(mod.getId()) && funs.contains("" + t.getId()))
					.collect(Collectors.toList());
			if (functions.size() > 0) {
				roles.put(mod.getName(), functions);
			}
		}
		request.setAttribute("roles", roles);
		request.setAttribute("icons", icons);
		request.setAttribute("admin", admin);
		return "main";
	}*/




}
