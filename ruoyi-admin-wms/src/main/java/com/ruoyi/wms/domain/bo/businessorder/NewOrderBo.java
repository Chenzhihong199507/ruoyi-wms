 package com.ruoyi.wms.domain.bo.businessorder;

 import com.ruoyi.common.core.validate.AddGroup;
 import com.ruoyi.common.core.validate.EditGroup;
 import com.ruoyi.common.mybatis.core.domain.BaseEntity;
 import com.ruoyi.wms.domain.entity.BusinessOrder;
 import com.ruoyi.wms.enums.OrderStatus;
 import io.github.linpeilie.annotations.AutoMapper;
 import jakarta.validation.constraints.NotBlank;
 import jakarta.validation.constraints.NotNull;
 import jakarta.validation.constraints.Null;
 import lombok.Data;
 import lombok.EqualsAndHashCode;

 import java.math.BigDecimal;
 import java.util.List;


 /**
  * 订单表业务对象 order
  *
  */

 @Data
 @EqualsAndHashCode(callSuper = true)
 @AutoMapper(target = BusinessOrder.class, reverseConvertGenerate = false)
 public class NewOrderBo extends BaseEntity {

     /**
      *
      */
     @NotBlank(message = "不能为空", groups = { EditGroup.class })
     private String id;

     /**
      * 所属客户
      */
     @Null
     private String userId;

     /**
      * 订单类型
      */
     @NotBlank(message = "订单类型不能为空", groups = { AddGroup.class, EditGroup.class })
     private String type;

     /**
      * 订单状态
      */
     @Null
     private String status;

     /**
      * 备注
      */
     private String remark;

     @NotBlank(message = "订单总额不能为空", groups = { AddGroup.class, EditGroup.class })
     private String totalAmount;

     @NotNull(message = "商品不能为空", groups = { AddGroup.class, EditGroup.class })
     private List<BusinessOrderMerchandiseBo> merchandises;
 }
