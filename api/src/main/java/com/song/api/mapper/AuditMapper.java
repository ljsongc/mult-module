package com.song.api.mapper;

import com.song.api.entity.Audit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AuditMapper extends Mapper<Audit> {
    /**
     * 获取某个业务的最近一次审核
     *
     * @param type       业务类型
     * @param businessId 业务id
     */
    Audit getBusinessLastAudit(@Param("type") Short type,
                               @Param("businessId") Integer businessId);
}