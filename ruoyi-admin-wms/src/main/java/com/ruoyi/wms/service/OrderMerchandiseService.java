package com.ruoyi.wms.service;

import com.ruoyi.common.core.utils.MapstructUtils;
import com.ruoyi.wms.domain.bo.businessorder.BusinessOrderMerchandiseBo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ruoyi.wms.domain.entity.OrderMerchandise;
import com.ruoyi.wms.mapper.OrderMerchandiseMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 订单商品关系Service业务层处理
 *
 * @author hw
 * @date 2024-11-15
 */
@RequiredArgsConstructor
@Service
public class OrderMerchandiseService {

    private final OrderMerchandiseMapper orderMerchandiseMapper;

    /**
     * 新增订单商品关系
     */
    public void insertByBo(BusinessOrderMerchandiseBo bo) {
        OrderMerchandise add = MapstructUtils.convert(bo, OrderMerchandise.class);
        orderMerchandiseMapper.insert(add);
    }

    /**
     * 修改订单商品关系
     */
    public void updateByBo(BusinessOrderMerchandiseBo bo) {
        OrderMerchandise update = MapstructUtils.convert(bo, OrderMerchandise.class);
        orderMerchandiseMapper.updateById(update);
    }

    /**
     * 批量删除订单商品关系
     */
    public void deleteByIds(Collection<String> ids) {
        List<OrderMerchandise> orderMerchandises = new ArrayList<>();
        ids.forEach(id -> {
            OrderMerchandise orderMerchandise = new OrderMerchandise();
            orderMerchandise.setId(id);
            orderMerchandise.setIsDelete(true);
            orderMerchandises.add(orderMerchandise);
        });
        orderMerchandiseMapper.updateBatchById(orderMerchandises);

    }
}
