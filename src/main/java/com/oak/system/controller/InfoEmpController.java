package com.oak.system.controller;


import cn.hutool.core.util.ObjectUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.oak.dto.InfoDTO;
import com.oak.system.entity.InfoEmp;
import com.oak.system.service.InfoEmpService;
import com.oak.vo.PageVO;
import com.oak.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/info")
public class InfoEmpController {

    public static final String  BUSINESS = "1";
    public static final String  LOGISTICS = "2";
    public static final String  PERSONNELMATTERS = "3";
    public static final String  JUNIORCOLLEGE = "4";
    public static final String  UNDERGRADUATECOURSE = "5";
    public static final String  POSTGRADUATE = "6";

    @Autowired
    InfoEmpService infoEmpService;

    @GetMapping
    public ResultVO getInfoList(@RequestParam(required = false,defaultValue = "1") int pageNumber,
                                @RequestParam(required = false,defaultValue = "5") int pageSize, InfoDTO dto){
        PageVO infoList = infoEmpService.getInfoList(pageNumber, pageSize, dto);
        return ResultVO.success(infoList);

    }

    @PostMapping
    public ResultVO addInfo(@RequestBody InfoEmp infoEmp){
        return infoEmpService.addInfo(infoEmp) ? ResultVO.success() :ResultVO.failed();
    }

    @PutMapping("/{id}")
    public ResultVO updateInfo(@PathVariable int id,@RequestBody InfoEmp infoEmp) {
        return infoEmpService.updateInfo(id, infoEmp)? ResultVO.success(): ResultVO.failed();
    }

    @DeleteMapping("/{id}")
    public ResultVO deleteInfo(@PathVariable int id) {
        infoEmpService.deleteInfo(id);
        return infoEmpService.deleteInfo(id)  ? ResultVO.success() : ResultVO.failed();
    }

    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        List<InfoEmp> list =  infoEmpService.getList();

        Map<String, String> deptMap = new HashMap<>();
        deptMap.put(BUSINESS, "业务部");
        deptMap.put(LOGISTICS, "后勤部");
        deptMap.put(PERSONNELMATTERS, "人事部");

        Map<String, String> degreeMap = new HashMap<>();
        degreeMap.put(JUNIORCOLLEGE, "办公室");
        degreeMap.put(UNDERGRADUATECOURSE, "本科");
        degreeMap.put(POSTGRADUATE, "研究生");

        for (InfoEmp emp : list) {
            emp.setDeptName(deptMap.getOrDefault(emp.getDeptName(), emp.getDeptName()));
            emp.setEmpDegreeName(degreeMap.getOrDefault(emp.getEmpDegreeName(), emp.getEmpDegreeName()));
        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("职工信息","UTF-8").replaceAll("\\+","%20");
        response.setHeader("Content-disposition","attachment;filename=" + fileName + ".xlsx");

        EasyExcel.write(response.getOutputStream())
                .head(InfoEmp.class)
                .excelType(ExcelTypeEnum.XLSX)
                .sheet("职工信息")
                .doWrite(list);

    }

}
