package com.oak.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oak.system.entity.Dict;

import java.util.List;

public interface DictService extends IService<Dict> {

    List<Dict> getList(String type);
}
