package com.approving.system.controller;

import com.approving.system.common.MessageConstant;
import com.approving.system.common.PageResult;
import com.approving.system.common.Result;
import com.approving.system.common.StatusCode;
import com.approving.system.domain.Information;
import com.approving.system.service.InformationService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Desc：审批信息管理控制层
 */
@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired
    private InformationService informationService;


    @RequestMapping("/find")
    public Result find(){
        List<Information> all = informationService.findAll();
        return new Result(false,200,"请求成功",all);
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Information> page = informationService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.INFORMATION_SEARCH_SUCCESS,page.getResult(),page.getTotal());

    }

    @RequestMapping("/add")
    public Result add(@RequestBody Information information){
        Boolean add = informationService.add(information);  //前端传过来的数据 调用service中的add方法
        return new Result(true,StatusCode.OK,MessageConstant.INFORMATION_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Information information = informationService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.INFORMATION_FIND_BY_ID_SUCCESS,information);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Information information){
        Boolean add = informationService.update(information);
        return new Result(true,StatusCode.OK,MessageConstant.INFORMATION_UPDATE_SUCCESS);
    }
    // /information/updateStatus/status/id
    @RequestMapping("/updateStatus/{status}/{id}")
    public Result updateStatus(@PathVariable("status") String status, @PathVariable("id") Integer id){
        Boolean flag = informationService.updateStatus(status,id);
        return new Result(true,StatusCode.OK,MessageConstant.INFORMATION_UPDATE_STATUS_SUCCESS);
    }
    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = informationService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.INFORMATION_DELETE_SUCCESS);
    }
}
