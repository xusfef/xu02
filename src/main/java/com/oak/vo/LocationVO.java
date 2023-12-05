package com.oak.vo;

import com.oak.system.entity.InfoEmp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationVO extends InfoEmp {

    private List<LocationVO> locat;
}
