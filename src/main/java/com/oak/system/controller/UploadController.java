package com.oak.system.controller;

import com.oak.system.service.UploadService;
import com.oak.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    UploadService uploadService;

    @PostMapping("/img")
    public ResultVO uploadImage(MultipartFile file) {
        return ResultVO.success(uploadService.uploadImage(file));
    }
}
