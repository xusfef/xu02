package com.oak.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oak.system.entity.Dict;
import com.oak.system.mapper.DictMapper;
import com.oak.system.service.DictService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl extends ServiceImpl<DictMapper,Dict> implements DictService {
    @Override
    public List<Dict> getList(String type) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",type).orderByAsc("sort");
        return this.list(queryWrapper);
    }
}
