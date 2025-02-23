package com.ruoyi.wms.controller;

import java.util.List;

import com.ruoyi.wms.domain.bo.shipment.NewShipmentBo;
import com.ruoyi.wms.domain.vo.shipment.ShipmentDetailVo;
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
import com.ruoyi.wms.domain.vo.shipment.ShipmentVo;
import com.ruoyi.wms.domain.bo.shipment.ShipmentBo;
import com.ruoyi.wms.service.ShipmentService;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;

/**
 * 发货管理
 *
 * @author zcc
 * @date 2024-11-08
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/wms/shipment")
public class ShipmentController extends BaseController {

    private final ShipmentService shipmentService;

    /**
     * 查询发货管理列表
     */
    @SaCheckPermission("wms:shipment:list")
    @GetMapping("/list")
    public TableDataInfo<ShipmentVo> list(ShipmentBo bo, PageQuery pageQuery) {
        return shipmentService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出发货管理列表
     */
    @SaCheckPermission("wms:shipment:export")
    @Log(title = "发货管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(ShipmentBo bo, HttpServletResponse response) {
        List<ShipmentVo> list = shipmentService.queryList(bo);
        ExcelUtil.exportExcel(list, "发货管理", ShipmentVo.class, response);
    }

    /**
     * 获取发货管理详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("wms:shipment:query")
    @GetMapping("/{id}")
    public R<ShipmentDetailVo> getInfoById(@NotNull(message = "id不能为空")
                                     @PathVariable String id) {
        return R.ok(shipmentService.queryById(id));
    }

    /**
     * 新增发货管理
     */
    @SaCheckPermission("wms:shipment:add")
    @Log(title = "发货管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody NewShipmentBo bo) {
        shipmentService.insertByBo(bo);
        return R.ok();
    }

    /**
     * 修改发货管理
     */
    @SaCheckPermission("wms:shipment:edit")
    @Log(title = "发货管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody ShipmentBo bo) {
        shipmentService.updateByBo(bo);
        return R.ok();
    }

    /**
     * 删除发货管理
     *
     * @param ids 主键串
     */
    @SaCheckPermission("wms:shipment:remove")
    @Log(title = "发货管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable String[] ids) {
        shipmentService.deleteByIds(List.of(ids));
        return R.ok();
    }
}
