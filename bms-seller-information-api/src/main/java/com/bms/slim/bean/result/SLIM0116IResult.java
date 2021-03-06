package com.bms.slim.bean.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0116IResult", description = "批量新增卖家合同信息准入API的返回对象")
public class SLIM0116IResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "提示信息")
    private String[] messages;
    @ApiModelProperty(value = "新增成功条数")
    private int count;
    @ApiModelProperty(value = "卖家合同信息ID集合")
    private List<Long> scpIds;

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getScpIds() {
        return scpIds;
    }

    public void setScpIds(List<Long> scpIds) {
        this.scpIds = scpIds;
    }
}
