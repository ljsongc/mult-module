package com.song.api.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@Table(name = "pe_audit")
public class Audit {
    @GeneratedValue(generator = "JDBC")
    @Id
    private Integer id;

    /**
     * 审核描述
     */
    private String remark;

    /**
     * 审核类型 1产品上架
     */
    private Short type;

    /**
     * 状态 1审核中 2通过 3驳回
     */
    private Short status;

    /**
     * 业务id
     */
    @Column(name = "business_id")
    private Integer businessId;

    /**
     * 钉钉审批流id
     */
    @Column(name = "process_id")
    private String processId;

    /**
     * 参数json串
     */
    @Column(name = "param_json")
    private String paramJson;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否删除
     */
    @Column(name = "is_delete")
    private Short isDelete;
}