package com.bms.agif.validator;

import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.PartnerAccountRsParam;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * Created by tao_zhifa on 2017/3/21.
 */
public class PartnerAccountModifyValidator extends DefaultCustomValidator<BaseBean<PartnerAccountRsParam,PartnerAccountRsParam>> {

    @Override
    public void validator(BaseBean<PartnerAccountRsParam, PartnerAccountRsParam> baseBean) {
        if (baseBean != null) {

            this.validatorLong("AGIF.L01013",baseBean.getTarget().getAccountId(), true, 9223372036854775806L,0L, 5);
            if(!StringUtils.isEmpty(baseBean.getTarget().getPartnerId())){
                this.validatorMaxLength("AGIF.L01000", baseBean.getTarget().getPartnerId(), true, 36);
            }
            if(!StringUtils.isEmpty(baseBean.getTarget().getAccountName())){
                this.validatorMaxLength("AGIF.L03003", baseBean.getTarget().getAccountName(), true, 16);
            }
            if(!StringUtils.isEmpty(baseBean.getTarget().getTelNo())){
                this.validatorMaxLength("AGIF.L03005", baseBean.getTarget().getTelNo(), true, 16);
            }
            if(!StringUtils.isEmpty(baseBean.getTarget().getPassword())){
                this.validatorMaxLength("AGIF.L03004", baseBean.getTarget().getPassword(), true, 16);
            }
            if(!StringUtils.isEmpty(baseBean.getTarget().getMailAddr())){
                this.validatorMaxLength("AGIF.L03006", baseBean.getTarget().getMailAddr(), true, 32);
            }


        } else {
            this.validatorRequired("error.20002", null);
        }
    }
}
