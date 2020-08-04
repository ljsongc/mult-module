package com.song.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Create By IntelliJ IDEA
 *
 * @author XieHua
 * @date 2020-03-16
 */
@Setter
@Getter
public class AuditPageListReqDTO implements Serializable {
    private Integer pageNum;
    private Integer pageSize;
    private Integer businessId;
    private List<Short> typeList;
    private Short status;
}
