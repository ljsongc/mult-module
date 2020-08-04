package com.song.api.controller;

import com.github.pagehelper.PageInfo;
import com.song.api.dto.AuditPageListReqDTO;
import com.song.api.entity.Audit;
import com.song.api.service.AuditService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class AuditController {
    @Resource
    private AuditService auditService;

    @GetMapping(value = "/audits", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageInfo<Audit> pageList( @RequestBody AuditPageListReqDTO pageListReqDTO) {
        PageInfo<Audit> pageInfo = auditService.pageList(pageListReqDTO);
        return pageInfo;
    }
    @GetMapping(value = "/allAudit", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Audit> allAudit() {
        List<Audit> pageInfo = auditService.allAudit();
        return pageInfo;
    }
}
