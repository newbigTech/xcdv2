package com.bms.slpd.bean.result;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0616IResult",
        description = "新增安全标准指标接口出参")
public class SLPD0616IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "新增数量")
    private Integer count;
    @ApiModelProperty(value = "新增安全标准指标Id列表")
    private List<Long> sftStdIds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Long> getSftStdIds() {
        return sftStdIds;
    }

    public void setSftStdIds(List<Long> sftStdIds) {
        this.sftStdIds = sftStdIds;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
