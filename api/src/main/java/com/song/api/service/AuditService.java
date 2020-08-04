package com.song.api.service;


import com.github.pagehelper.PageInfo;
import com.song.api.dto.AuditPageListReqDTO;
import com.song.api.entity.Audit;

import java.util.List;

/**
 * Create By IntelliJ IDEA
 *
 * @author XieHua
 * @date 2020-03-05
 */
public interface AuditService {
    boolean insert(Audit audit, String deptName, String position);

    PageInfo<Audit> pageList(AuditPageListReqDTO pageListReqDTO);

    List<Audit> allAudit();

}
