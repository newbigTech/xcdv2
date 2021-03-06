package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0234IResult", description = "新增生产商实验室接口出参")
public class SLIM0234IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "返回消息")
    private String[] message;
    @ApiModelProperty(value = "新增生产商实验室数量")
    private Integer count;
    @ApiModelProperty(value = "新增生产商实验室ID结果集")
    private List<Long> laboratoryIds;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Long> getLaboratoryIds() {
        return laboratoryIds;
    }

    public void setLaboratoryIds(List<Long> laboratoryIds) {
        this.laboratoryIds = laboratoryIds;
    }
}
