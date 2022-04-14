package com.approving.system.service;
import com.approving.system.domain.Stuff;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface StuffService {

    public List<Stuff> findAll();

    public Page<Stuff> search(Map searchMap);

    public Boolean add(Stuff stuff);

    public Stuff findById(Integer id);

    public Boolean update(Stuff stuff);

    public Boolean del(List<Integer> ids);

    // 保存用户信息
    void saveAllStuffs(List<Stuff> list);

}
