package com.ruoyi.wms.domain.bo.shipmentnotice;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import com.ruoyi.wms.domain.entity.ShipmentNotice;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


/**
 * 发货请求通知单业务对象 shipment_notice
 *
 * @author huiwei
 * @date 2024-11-18
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ShipmentNotice.class, reverseConvertGenerate = false)
public class UpdateShipmentNoticeStatusBo extends BaseEntity {

    /**
     *
     */
    @NotBlank(message = "不能为空", groups = { EditGroup.class })
    private String id;

    @NotBlank(message = "状态不能为空", groups = { EditGroup.class })
    private String status;
}
