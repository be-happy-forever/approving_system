package com.approving.system.service.impl;

import com.approving.system.dao.StuffMapper;
import com.approving.system.domain.Stuff;
import com.approving.system.service.StuffService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class StuffServiceImpl implements StuffService {

    @Autowired
    private StuffMapper stuffMapper;

    @Override
    public List<Stuff> findAll() {
        List<Stuff> stuffs = stuffMapper.selectAll();
        return stuffs;
    }

    @Override
    public Page<Stuff> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Stuff.class);//指定查询的表tb_STUFF
        //1.初始化分页条件
        int pageNum = 1;
        int pageSize = 2;
        if(searchMap != null){
            Example.Criteria criteria = example.createCriteria();//创建查询条件
            //时间区间
            if(StringUtil.isNotEmpty((String) searchMap.get("startTime"))){
                criteria.andGreaterThanOrEqualTo("createTime",searchMap.get("startTime"));
            }
            if(StringUtil.isNotEmpty((String) searchMap.get("endTime"))){
                criteria.andLessThanOrEqualTo("createTime",searchMap.get("endTime"));
                criteria.andLessThanOrEqualTo("createTime",searchMap.get("endTime"));
            }
            //名称模糊搜索
            if(StringUtil.isNotEmpty((String) searchMap.get("name"))){
                criteria.andLike("name", "%"+(String) searchMap.get("name")+"%");
            }
            //分页
            /*if(StringUtil.isNotEmpty((String) searchMap.get("pageNum"))){
                pageNum = Integer.parseInt((String) searchMap.get("pageNum"));
            }
            if(StringUtil.isNotEmpty((String) searchMap.get("pageSize"))){
                pageSize = Integer.parseInt((String) searchMap.get("pageSize"));
            }*/
            if((Integer) searchMap.get("pageNum") !=null){
                pageNum = (Integer) searchMap.get("pageNum");
            }
            if((Integer) searchMap.get("pageSize") !=null){
                pageSize = (Integer) searchMap.get("pageSize");
            }
        }
        PageHelper.startPage(pageNum,pageSize);//使用PageHelper插件完成分页
        Page<Stuff> stuffs = (Page<Stuff>) stuffMapper.selectByExample(example);
        return stuffs;
    }

    @Override
    public Boolean add(Stuff stuff) {
        int row = stuffMapper.insert(stuff);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Stuff findById(Integer id) {
        return stuffMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(Stuff stuff) {
        int row = stuffMapper.updateByPrimaryKeySelective(stuff);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id:ids) {
            stuffMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    public void saveAllStuffs(List<Stuff> list) {
        stuffMapper.saveAllStuffs(list);
    }


}
