 package com.ruoyi.wms.domain.bo.shipment;

 import com.ruoyi.common.core.validate.AddGroup;
 import com.ruoyi.common.core.validate.EditGroup;
 import com.ruoyi.wms.domain.entity.ShipmentMerchandise;
 import io.github.linpeilie.annotations.AutoMapper;
 import jakarta.validation.constraints.NotBlank;
 import lombok.Data;
 import lombok.EqualsAndHashCode;

 import java.io.Serial;
 import java.io.Serializable;


 /**
  * 订单商品关系业务对象 order_merchandise
  *
  * @author hw
  * @date 2024-11-15
  */

 @Data
 @EqualsAndHashCode(callSuper=false)
 @AutoMapper(target = ShipmentMerchandise.class, reverseConvertGenerate = false)
 public class ShipmentMerchandiseBo implements Serializable {

     @Serial
     private static final long serialVersionUID = 1L;

     /**
      * 发货通知单id
      */
     private String shipmentNoticeId;

     /**
      * 商品id
      */
     @NotBlank(message = "商品id不能为空", groups = { AddGroup.class, EditGroup.class })
     private String merchandiseId;

     /**
      * 发货单id
      */
     private String shipmentId;

     /**
      * 需求数量
      */
     @NotBlank(message = "请求通知数量不能为空", groups = { AddGroup.class, EditGroup.class })
     private int quantityShipped;
 }
