package com.song.api.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.song.api.dto.AuditPageListReqDTO;
import com.song.api.entity.Audit;
import com.song.api.mapper.AuditMapper;
import com.song.api.service.AuditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Create By IntelliJ IDEA
 *
 * @author XieHua
 * @date 2020-03-05
 */
@Slf4j
@Service
public class AuditServiceImpl implements AuditService {
    @Resource
    private AuditMapper auditMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(Audit audit, String deptName, String position) {
        audit.setCreateTime(new Date());
        audit.setStatus((short) 1);
        auditMapper.insertSelective(audit);
        return true;
    }

    @Override
    public PageInfo<Audit> pageList(AuditPageListReqDTO pageListReqDTO) {
        PageHelper.startPage(pageListReqDTO.getPageNum(), pageListReqDTO.getPageSize());
        Example example = new Example(Audit.class);
        example.setOrderByClause("create_time DESC");
        Example.Criteria criteria = example.createCriteria();
        if (pageListReqDTO.getBusinessId() != null) {
            criteria.andEqualTo("businessId", pageListReqDTO.getBusinessId());
        }
        if (pageListReqDTO.getTypeList() != null && !pageListReqDTO.getTypeList().isEmpty()) {
            criteria.andIn("type", pageListReqDTO.getTypeList());
        }
        if (pageListReqDTO.getStatus() != null) {
            criteria.andEqualTo("status", pageListReqDTO.getStatus());
        }
        List<Audit> auditList = auditMapper.selectByExample(example);
        PageInfo<Audit> pageInfo = new PageInfo<>(auditList);
        return pageInfo;
    }

    @Override
    public List<Audit> allAudit() {
        return auditMapper.selectAll();
    }
}
