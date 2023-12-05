package com.oak.system.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.oak.config.ImageProperties;
import com.oak.exception.ParamException;
import com.oak.system.service.UploadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    ImageProperties imageProperties;

    @Override
    public String uploadImage(MultipartFile file) {

        /* 判断文件是否为空 */
        if(ObjectUtil.isEmpty(file) || file.isEmpty() ) {
            throw new ParamException("文件不能为空！");
        }

        /* 判断文件的类型 */
        List<String> typeList = imageProperties.getTypes();
        String type = file.getContentType();
        if(!typeList.contains(type)) {
            String resultTypes = typeList.stream()
                    .map(v -> v.substring(v.lastIndexOf("/") + 1))
                    .collect(Collectors.joining(";"));
            throw new ParamException(StringUtils.join("只支持",resultTypes," 的类型图片"));
        }

        /* 3 创建上传图片的文件夹及文件名 */
        String directory = imageProperties.getDirectory();
        File parent = new File(directory);
        if(!parent.exists()) {
            parent.mkdirs();
        }

        String originalFilename = file.getOriginalFilename();
        String endFix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = StringUtils.join(IdUtil.simpleUUID(),endFix);

        File target = new File(parent,fileName);

        /* 上传 */
        try {
            file.transferTo(target);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* 返回数据 */
        String result = imageProperties.getPrefix().endsWith("/")
                ? StringUtils.join(imageProperties.getPrefix(),fileName)
                : StringUtils.join(imageProperties.getPrefix(),"/",fileName);


        return result;
    }
}
