package com.ruoyi.wms.domain.vo.shipmentnotice;

import com.ruoyi.common.mybatis.core.domain.BaseVo;
import com.ruoyi.wms.domain.entity.ShipmentNotice;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.excel.annotation.ExcelDictFormat;
import com.ruoyi.common.excel.convert.ExcelDictConvert;
import com.ruoyi.wms.domain.vo.merchandise.MerchandiseNoticeVo;
import com.ruoyi.wms.domain.vo.merchandise.MerchandiseVo;
import lombok.Data;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.List;

/**
 * 发货请求通知单视图对象 shipment_notice
 *
 * @author huiwei
 * @date 2024-11-18
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ShipmentNotice.class)
@EqualsAndHashCode(callSuper = true)
public class ShipmentNoticeVo extends BaseVo {

    @Serial
    private static final long serialVersionUID = 1L;

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
     *
     */
    @ExcelProperty(value = "")
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
    @ExcelProperty(value = "配送方式", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "物=流渠道")
    private String deliveryMethod;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    private List<MerchandiseNoticeVo> merchandises;
}
