package com.bms.order.bean.entity;
import org.springframework.beans.BeanUtils;public class BsOrderDetailAttachedHistoryEntity extends BsOrderDetailAttachedEntity {
private static final long serialVersionUID = 1L;
/** 履历ID */
private Long historyId;
public Long getHistoryId() {
return this.historyId;}
public void setHistoryId(Long historyId) {
this.historyId=historyId;}
public BsOrderDetailAttachedHistoryEntity() {
}
public BsOrderDetailAttachedHistoryEntity(BsOrderDetailAttachedEntity entity) {
BeanUtils.copyProperties(entity, this);
}
}
