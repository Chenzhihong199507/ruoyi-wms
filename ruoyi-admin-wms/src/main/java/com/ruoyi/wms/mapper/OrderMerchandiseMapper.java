package com.ruoyi.wms.mapper;

import com.ruoyi.wms.domain.bo.NewOrderBo;
import com.ruoyi.wms.domain.bo.OrderMerchandiseBo;
import com.ruoyi.wms.domain.entity.OrderMerchandise;
import com.ruoyi.common.mybatis.core.mapper.BaseMapperPlus;

/**
 * 订单商品关系Mapper接口
 *
 * @author hw
 * @date 2024-11-15
 */
public interface OrderMerchandiseMapper extends BaseMapperPlus<OrderMerchandise, OrderMerchandiseBo> {

    void deleteByOrderId(NewOrderBo bo);
}
