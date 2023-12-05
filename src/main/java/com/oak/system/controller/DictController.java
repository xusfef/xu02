package com.oak.system.controller;

import com.oak.system.entity.Dict;
import com.oak.system.service.DictService;
import com.oak.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dict")
public class DictController {

    @Resource
    DictService dictService;

    @GetMapping("/list")
    public ResultVO getDictList(@RequestParam String type){
        List<Dict> dictList = dictService.getList(type);
        return dictList.size() >0 ?ResultVO.success(dictList): ResultVO.failed();
    }

}
