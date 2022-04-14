package com.approving.system.service.impl;

import com.approving.system.dao.InformationMapper;
import com.approving.system.domain.Information;
import com.approving.system.service.InformationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationMapper informationMapper;

    @Override
    public List<Information> findAll() {
        List<Information> informations = informationMapper.selectAll();
        return informations;
    }

    @Override
    public Page<Information> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Information.class);//指定查询的表tb_info
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
        Page<Information> informations = (Page<Information>) informationMapper.selectByExample(example);
        return informations;
    }

    @Override
    public Boolean add(Information information) {
        int row = informationMapper.insert(information);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Information findById(Integer id) {
        return informationMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(Information information) {
        int row = informationMapper.updateByPrimaryKeySelective(information);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean updateStatus(String status, Integer id) {
        Information information = new Information();
        information.setId(id);
        information.setStatus(status);
        int row = informationMapper.updateByPrimaryKeySelective(information);
        if(row>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id:ids) {
            informationMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
