package com.oak.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oak.dto.InfoDTO;
import com.oak.system.entity.InfoEmp;

import java.util.List;

public interface InfoEmpMapper extends BaseMapper<InfoEmp> {


    List<InfoEmp> getInfoList(InfoDTO dto);
}
