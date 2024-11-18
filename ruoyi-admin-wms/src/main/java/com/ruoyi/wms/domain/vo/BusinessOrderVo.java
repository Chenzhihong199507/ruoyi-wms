package com.ruoyi.wms.domain.vo;

import com.ruoyi.wms.domain.entity.BusinessOrder;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import io.github.linpeilie.annotations.AutoMapper;
import com.ruoyi.common.excel.annotation.ExcelDictFormat;
import com.ruoyi.common.excel.convert.ExcelDictConvert;
import java.io.Serializable;
import java.io.Serial;
import java.util.List;

/**
 * 订单表视图对象 order
 *
 * @author zcc
 * @date 2024-11-11
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BusinessOrder.class)
public class BusinessOrderVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ExcelProperty(value = "")
    private String id;

    /**
     * 所属客户
     */
    @ExcelProperty(value = "所属客户")
    private OptionItemVo user;

    /**
     * 订单类型
     */
    @ExcelProperty(value = "订单类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "order_type")
    private String type;

    /**
     * 订单状态
     */
    @ExcelProperty(value = "订单状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "order_status")
    private String status;

    /**
     * 订单总额
     */
    @ExcelProperty(value = "订单总额")
    private String totalAmount;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

    private List<MerchandiseVo> merchandises;

}
