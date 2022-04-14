package com.approving.system.service;

import com.approving.system.dao.InformationMapper;
import com.approving.system.domain.Information;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface InformationService {

    public List<Information> findAll();

    public Page<Information> search(Map searchMap);

    public Boolean add(Information information);

    public Information findById(Integer id);

    public Boolean update(Information information);

    public Boolean updateStatus(String status, Integer id);

    public Boolean del(List<Integer> ids);

}
