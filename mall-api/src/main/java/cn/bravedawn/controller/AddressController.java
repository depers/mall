package cn.bravedawn.controller;

import cn.bravedawn.bo.AddressBO;
import cn.bravedawn.pojo.UserAddress;
import cn.bravedawn.service.AddressService;
import cn.bravedawn.utils.JsonResult;
import cn.bravedawn.utils.MobileEmailUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 冯晓
 * @Date 2020/1/16 18:37
 */

@Api(value = "地址相关", tags = {"地址相关的api接口"})
@RequestMapping("address")
@RestController
public class AddressController {

    /**
     * 用户在确认订单页面，可以针对收货地址做如下操作：
     * 1. 查询用户的所有收货地址列表
     * 2. 新增收货地址
     * 3. 删除收货地址
     * 4. 修改收货地址
     * 5. 设置默认地址
     */

    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "根据用户id查询收货地址列表", notes = "根据用户id查询收货地址列表", httpMethod = "POST")
    @PostMapping("/list")
    public JsonResult list(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId) {

        if (StringUtils.isBlank(userId)) {
            return JsonResult.errorMsg("");
        }

        List<UserAddress> list = addressService.queryAll(userId);
        return JsonResult.ok(list);
    }


    @ApiOperation(value = "用户新增地址", notes = "用户新增地址", httpMethod = "POST")
    @PostMapping("/add")
    public JsonResult add(@RequestBody AddressBO addressBO) {

        JsonResult checkRes = checkAddress(addressBO);
        if (checkRes.getStatus() != 200) {
            return checkRes;
        }

        addressService.addNewUserAddress(addressBO);

        return JsonResult.ok();
    }

    /**
     * 新增地址格式校验
     * @param addressBO
     * @return
     */
    private JsonResult checkAddress(AddressBO addressBO) {
        String receiver = addressBO.getReceiver();
        if (StringUtils.isBlank(receiver)) {
            return JsonResult.errorMsg("收货人不能为空");
        }
        if (receiver.length() > 12) {
            return JsonResult.errorMsg("收货人姓名不能太长");
        }

        String mobile = addressBO.getMobile();
        if (StringUtils.isBlank(mobile)) {
            return JsonResult.errorMsg("收货人手机号不能为空");
        }
        if (mobile.length() != 11) {
            return JsonResult.errorMsg("收货人手机号长度不正确");
        }
        boolean isMobileOk = MobileEmailUtils.checkMobileIsOk(mobile);
        if (!isMobileOk) {
            return JsonResult.errorMsg("收货人手机号格式不正确");
        }

        String province = addressBO.getProvince();
        String city = addressBO.getCity();
        String district = addressBO.getDistrict();
        String detail = addressBO.getDetail();
        if (StringUtils.isBlank(province) ||
                StringUtils.isBlank(city) ||
                StringUtils.isBlank(district) ||
                StringUtils.isBlank(detail)) {
            return JsonResult.errorMsg("收货地址信息不能为空");
        }

        return JsonResult.ok();
    }

    @ApiOperation(value = "用户修改地址", notes = "用户修改地址", httpMethod = "POST")
    @PostMapping("/update")
    public JsonResult update(@RequestBody AddressBO addressBO) {

        if (StringUtils.isBlank(addressBO.getAddressId())) {
            return JsonResult.errorMsg("修改地址错误：addressId不能为空");
        }

        JsonResult checkRes = checkAddress(addressBO);
        if (checkRes.getStatus() != 200) {
            return checkRes;
        }

        addressService.updateUserAddress(addressBO);

        return JsonResult.ok();
    }

    @ApiOperation(value = "用户删除地址", notes = "用户删除地址", httpMethod = "POST")
    @PostMapping("/delete")
    public JsonResult delete(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "addressId", value = "地址id", required = true)
            @RequestParam String addressId) {

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return JsonResult.errorMsg("");
        }

        addressService.deleteUserAddress(userId, addressId);
        return JsonResult.ok();
    }
}
