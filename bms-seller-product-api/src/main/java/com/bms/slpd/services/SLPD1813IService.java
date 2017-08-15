package com.bms.slpd.services;

import com.bms.slpd.bean.param.SLPD1813IParam;
import com.bms.slpd.bean.result.field.SLPD1805IProductProducerResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

public interface SLPD1813IService extends BaseService {

    /**
     * 批量查询单品品牌规格生产商
     */
    @Transactional(readOnly = true)
    BaseRestPaginationResult<SLPD1805IProductProducerResult> findProductProducers(SLPD1813IParam slpd1805iParam);

}