package com.oak.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oak.dto.InfoDTO;
import com.oak.system.entity.InfoEmp;
import com.oak.vo.PageVO;

import java.util.List;

public interface InfoEmpService extends IService<InfoEmp> {


    PageVO getInfoList(int pageNumber, int pageSize, InfoDTO dto);

    boolean addInfo(InfoEmp infoEmp);

    boolean updateInfo(int id, InfoEmp infoEmp);

    boolean deleteInfo(int id);


    List<InfoEmp> getList();

}
