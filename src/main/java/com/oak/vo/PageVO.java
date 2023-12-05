package com.oak.vo;

import com.oak.system.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVO<T> {

    private Integer pageNumber;

    private Integer pageSize;

    private Long total;

    private List<T> rows;
}
