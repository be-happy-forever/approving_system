package com.approving.system.controller;

import com.alibaba.excel.EasyExcel;
import com.approving.system.common.MessageConstant;
import com.approving.system.common.PageResult;
import com.approving.system.common.Result;
import com.approving.system.common.StatusCode;
import com.approving.system.domain.Stuff;
import com.approving.system.listener.StuffDataListener;
import com.approving.system.service.StuffService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Desc：职工信息管理控制层
 */
@RestController
@RequestMapping("/stuff")
public class StuffController {
    @Autowired
    private StuffService stuffService;


    @RequestMapping("/find")
    public Result find(){
        List<Stuff> all = stuffService.findAll();
        return new Result(false,200,"请求成功",all);
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Stuff> page = stuffService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.STUFF_SEARCH_SUCCESS,page.getResult(),page.getTotal());

    }

    @RequestMapping("/add")
    public Result add(@RequestBody Stuff stuff){
        Boolean add = stuffService.add(stuff);  //前端传过来的数据 调用service中的add方法
        return new Result(true,StatusCode.OK,MessageConstant.STUFF_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Stuff stuff = stuffService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.STUFF_FIND_BY_ID_SUCCESS,stuff);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Stuff stuff){
        Boolean add = stuffService.update(stuff);
        return new Result(true,StatusCode.OK,MessageConstant.STUFF_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = stuffService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.STUFF_DELETE_SUCCESS);
    }
    // easyexcel上传文件
    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Stuff.class, new StuffDataListener(stuffService)).sheet().doRead();
        return "上传成功";
    }
    //跳转到手机表上传页面
    @RequestMapping("/toUploadPage")
    public String toUploadPage() {
        return "/tostuffupload";
    }

}
