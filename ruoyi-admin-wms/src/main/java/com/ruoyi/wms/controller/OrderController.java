package com.ruoyi.wms.controller;

import java.util.List;

import cn.dev33.satoken.annotation.SaIgnore;
import com.ruoyi.wms.service.MerchandiseService;
import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.ruoyi.common.idempotent.annotation.RepeatSubmit;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.web.core.BaseController;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.excel.utils.ExcelUtil;
import com.ruoyi.wms.domain.vo.OrderVo;
import com.ruoyi.wms.domain.bo.OrderBo;
import com.ruoyi.wms.service.OrderService;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;

/**
 * 订单表
 *
 * @author zcc
 * @date 2024-11-11
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/wms/order")
public class OrderController extends BaseController {

    private final OrderService orderService;

//    /**
//     * 查询订单表列表
//     */
//    @SaCheckPermission("wms:order:list")
//    @GetMapping("/list")
//    public TableDataInfo<OrderVo> list(OrderBo bo, PageQuery pageQuery) {
//        return orderService.queryPageList(bo, pageQuery);
//    }

    @SaIgnore
    @GetMapping("/list")
    public TableDataInfo<OrderVo> lists(OrderBo bo, PageQuery pageQuery) {
        return  orderService.OrderList(bo, pageQuery);
    }

    /**
     * 导出订单表列表
     */
    @SaCheckPermission("wms:order:export")
    @Log(title = "订单表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(OrderBo bo, HttpServletResponse response) {
        List<OrderVo> list = orderService.queryList(bo);
        ExcelUtil.exportExcel(list, "订单表", OrderVo.class, response);
    }

    /**
     * 获取订单表详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("wms:order:query")
    @GetMapping("/{id}")
    public R<OrderVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable String id) {
        return R.ok(orderService.queryById(id));
    }

    /**
     * 新增订单表
     */
    @SaCheckPermission("wms:order:add")
    @Log(title = "订单表", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody OrderBo bo) {
        orderService.insertByBo(bo);
        return R.ok();
    }

    /**
     * 修改订单表
     */
    @SaCheckPermission("wms:order:edit")
    @Log(title = "订单表", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody OrderBo bo) {
        orderService.updateByBo(bo);
        return R.ok();
    }

    /**
     * 删除订单表
     *
     * @param ids 主键串
     */
    @SaCheckPermission("wms:order:remove")
    @Log(title = "订单表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable String[] ids) {
        orderService.deleteByIds(List.of(ids));
        return R.ok();
    }
}
