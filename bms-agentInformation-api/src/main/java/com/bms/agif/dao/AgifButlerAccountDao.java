/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.dao;

import com.bms.agif.bean.entity.AgifButlerAccount;
import com.bms.agif.bean.param.BaseBean;
import com.framework.boot.base.BaseDao;

/**
 * <p>AgifButlerAccountDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface AgifButlerAccountDao extends BaseDao {
    int delete(AgifButlerAccount butlerAccount);
    int updateAccount(BaseBean<AgifButlerAccount,AgifButlerAccount> butlerAccountAgifButlerAccountBaseBean);
}