package com.ruoyi.wms.domain.vo.shipmentnotice;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.mybatis.core.domain.BaseVo;
import com.ruoyi.wms.domain.vo.MerchandiseVo;
import com.ruoyi.wms.domain.vo.OptionItemVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@ExcelIgnoreUnannotated
@EqualsAndHashCode(callSuper = true)
public class ShipmentNoticeOrderDetailVo extends BaseVo {
    /**
     *
     */
    @ExcelProperty(value = "")
    private String id;

    /**
     *
     */
    @ExcelProperty(value = "")
    private String orderId;

    /**
     * 所属客户
     */
    private String userId;

    /**
     * 标签种类
     */
    @ExcelProperty(value = "标签种类")
    private String tag;

    /**
     * 通知单状态
     */
    @ExcelProperty(value = "通知单状态")
    private String status;

    /**
     * 配送方式（物流渠道）
     */
    private String deliveryMethod;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    private List<MerchandiseVo> merchandises;
}
