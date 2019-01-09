package com.market.controller;

import com.market.entity.Fun;
import com.market.entity.Result;
import com.market.entity.Role;
import com.market.entity.User;
import com.market.services.FunServiceImpl;
import com.market.services.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private FunServiceImpl funService;

    /**
     * 查询所有权限信息
     * @param role
     * @param response
     * @return
     */
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public Result list(Role role, HttpServletResponse response)throws Exception{

        List<Role> roleList = roleService.list(role);

        Result result = new Result();

        if(roleList.size() > 0){
            result.setSuccess("获取成功");
            result.setData(roleList);
            result.setCount(roleList.size());
        }else{
            result.setSuccess("获取失败");
            result.setCount(0);
        }

        return result;
    }

    /**
     * 获取用户权限
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/findUserFun")
    @ResponseBody
    public Result save(HttpServletRequest request, HttpServletResponse response)throws Exception{

        User user = (User) request.getSession().getAttribute("userInfo");

        Role role  = roleService.findById(user.getRoleId());
        String[] roleFuns = role.getFuns().split(",");

        List<String> list = new ArrayList<>();

        List<Fun> funs  = funService.list();

        for(String rolf : roleFuns){

            for(Fun fun : funs){
                if(Integer.parseInt(rolf) == fun.getId()){
                    list.add(fun.getName());
                }
            }
        }
        Result result = new Result();
        if(role != null){
            result.setSuccess("成功");
            result.setData(list);
        }else{
            result.setError("失败");
        }

        return result;
    }

    /**
     * 获取角色权限
     * @param id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/findFun")
    @ResponseBody
    public Result save(Integer id, HttpServletRequest request, HttpServletResponse response)throws Exception{

        Result result = new Result();

        Role role  = roleService.findById(id);

        if(role != null){
            result.setSuccess("成功");
            result.setData(role);
        }else{
            result.setError("失败");
        }

        return result;
    }

    /**
     * 获取功能菜单
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/allFun")
    @ResponseBody
    public Result allFun(HttpServletRequest request, HttpServletResponse response)throws Exception{

        Result result = new Result();

        List<Fun> funs  = funService.list();

        if(funs.size() >= 1){
            result.setSuccess("成功");
            result.setData(funs);
        }else{
            result.setError("失败");
        }

        return result;
    }


    /**
     * 保存修改功能
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public Result add(Role role, HttpServletRequest request, HttpServletResponse response)throws Exception{


        int resultTotal = 0;

        if(role.getId()==null){
            resultTotal = roleService.add(role);
        }else{
            resultTotal = roleService.update(role);
        }
        Result result=new Result();

        if(resultTotal>0){
            result.setSuccess("成功");
        }else{
            result.setError("失败");
        }
        return result;
    }

    /**
     * 删除用户
     * @param id
     * @param response
     * @return
     * @throws Exception
     *//*
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result delete(Integer id, HttpServletResponse response)throws Exception{

        Integer num = userService.delete(id);

        Result result = new Result();

        if(num>0){
            result.setSuccessMsg("成功");
        }else{
            result.setErrorMsg("失败");
        }

        return result;
    }*/

}
