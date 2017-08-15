package com.bms.slpd.bean.result;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0609IResult",
        description = "修改加工技术标准指标接口出参")
public class SLPD0609IResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "更新数量")
    private Integer count;
    @ApiModelProperty(value = "更新加工技术标准指标Id列表")
    private List<Long> mctStdIds;
    @ApiModelProperty(value = "返回消息")
    private String[] message;

    public List<Long> getMctStdIds() {
        return mctStdIds;
    }

    public void setMctStdIds(List<Long> mctStdIds) {
        this.mctStdIds = mctStdIds;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
