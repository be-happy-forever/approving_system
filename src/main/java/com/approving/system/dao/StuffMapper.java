package com.approving.system.dao;
import com.approving.system.domain.Stuff;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
@Component
public interface StuffMapper extends Mapper<Stuff> {
    // 保存用户信息
    void saveAllStuffs(List<Stuff> list);
}


