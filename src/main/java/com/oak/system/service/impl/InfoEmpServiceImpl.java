package com.oak.system.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oak.dto.InfoDTO;
import com.oak.exception.ParamException;
import com.oak.system.entity.Dict;
import com.oak.system.entity.InfoEmp;
import com.oak.system.mapper.InfoEmpMapper;
import com.oak.system.service.InfoEmpService;
import com.oak.vo.PageVO;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InfoEmpServiceImpl extends ServiceImpl<InfoEmpMapper, InfoEmp> implements InfoEmpService {

    @Resource
    InfoEmpMapper infoEmpMapper;


    @Override
    public PageVO getInfoList(int pageNumber, int pageSize, InfoDTO dto) {

        PageHelper.startPage(pageNumber, pageSize);

        List<InfoEmp> list = infoEmpMapper.getInfoList(dto);

        PageInfo<InfoEmp> PageInfo = new PageInfo<>(list);

        PageVO<InfoEmp> vo = new PageVO<>(
                PageInfo.getPageNum(),
                PageInfo.getPageSize(),
                PageInfo.getTotal(),
                list
        );
        return vo;
    }

    @Override
    public boolean addInfo(InfoEmp infoEmp) {

        return this.save(infoEmp);
    }

    @Override
    public boolean updateInfo(int id, InfoEmp infoEmp) {
        infoEmp.setId(id);
        return this.updateById(infoEmp);
    }

    @Override
    public boolean deleteInfo(int id) {
        return this.removeById(id);
    }

    @Override
    public List<InfoEmp> getList() {

        return this.list();
    }


}
