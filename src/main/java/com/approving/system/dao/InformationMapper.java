package com.approving.system.dao;

import com.approving.system.domain.Information;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface InformationMapper extends Mapper<Information> {
}
