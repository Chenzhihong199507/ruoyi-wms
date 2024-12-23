package com.ruoyi.wms.domain.bo.financial;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import com.ruoyi.wms.domain.entity.UserBalance;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 用户余额业务对象 user_balance
 *
 * @author Huiwei
 * @date 2024-11-29
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = UserBalance.class, reverseConvertGenerate = false)
public class NewUserBalanceBo extends BaseEntity {

    /**
     * 用户id
     */
    @NotBlank(message = "用户id不能为空", groups = { AddGroup.class, EditGroup.class })
    private String userId;

    /**
     * 充值金额
     */
    @NotBlank(message = "充值金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private String amount;

    /**
     * 事件
     */
    @Null
    private String event;

}
