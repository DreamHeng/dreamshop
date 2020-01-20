package com.dreamshop.controller;

import com.dreamshop.pojo.UserAddress;
import com.dreamshop.pojo.bo.AddressBO;
import com.dreamshop.service.AddressService;
import com.dreamshop.util.DreamJSONResult;
import com.dreamshop.util.MobileEmailUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * function:dreamshop
 *
 * @author DreamHeng
 * @date 2020/1/20
 */
@Api(value = "地址相关", tags = {"地址相关的api接口"})
@RequestMapping("address")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "根据用户id查询收货地址列表", notes = "根据用户id查询收货地址列表", httpMethod = "POST")
    @PostMapping("/list")
    public DreamJSONResult list(
            @RequestParam String userId) {

        if (StringUtils.isBlank(userId)) {
            return DreamJSONResult.errorMsg("");
        }

        List<UserAddress> list = addressService.queryAll(userId);
        return DreamJSONResult.ok(list);
    }

    @ApiOperation(value = "用户新增地址", notes = "用户新增地址", httpMethod = "POST")
    @PostMapping("/add")
    public DreamJSONResult add(@RequestBody AddressBO addressBO) {

        DreamJSONResult checkRes = checkAddress(addressBO);
        if (checkRes.getStatus() != 200) {
            return checkRes;
        }

        addressService.addNewUserAddress(addressBO);

        return DreamJSONResult.ok();
    }

    @ApiOperation(value = "用户修改地址", notes = "用户修改地址", httpMethod = "POST")
    @PostMapping("/update")
    public DreamJSONResult update(@RequestBody AddressBO addressBO) {

        if (StringUtils.isBlank(addressBO.getAddressId())) {
            return DreamJSONResult.errorMsg("修改地址错误：addressId不能为空");
        }

        DreamJSONResult checkRes = checkAddress(addressBO);
        if (checkRes.getStatus() != 200) {
            return checkRes;
        }

        addressService.updateUserAddress(addressBO);

        return DreamJSONResult.ok();
    }

    @ApiOperation(value = "用户删除地址", notes = "用户删除地址", httpMethod = "POST")
    @PostMapping("/delete")
    public DreamJSONResult delete(
            @RequestParam String userId,
            @RequestParam String addressId) {

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return DreamJSONResult.errorMsg("");
        }

        addressService.deleteUserAddress(userId, addressId);
        return DreamJSONResult.ok();
    }

    @ApiOperation(value = "用户设置默认地址", notes = "用户设置默认地址", httpMethod = "POST")
    @PostMapping("/setDefalut")
    public DreamJSONResult setDefalut(
            @RequestParam String userId,
            @RequestParam String addressId) {

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return DreamJSONResult.errorMsg("");
        }

        UserAddress userAddress = addressService.queryUserAddres(userId, addressId);
        if (userAddress == null){
            return DreamJSONResult.errorMsg("addressId错误");
        }

        addressService.updateUserAddressToBeDefault(userId, addressId);
        return DreamJSONResult.ok();
    }

    private DreamJSONResult checkAddress(AddressBO addressBO) {
        String receiver = addressBO.getReceiver();
        if (StringUtils.isBlank(receiver)) {
            return DreamJSONResult.errorMsg("收货人不能为空");
        }
        if (receiver.length() > 12) {
            return DreamJSONResult.errorMsg("收货人姓名不能太长");
        }

        String mobile = addressBO.getMobile();
        if (StringUtils.isBlank(mobile)) {
            return DreamJSONResult.errorMsg("收货人手机号不能为空");
        }
        if (mobile.length() != 11) {
            return DreamJSONResult.errorMsg("收货人手机号长度不正确");
        }
        boolean isMobileOk = MobileEmailUtils.checkMobileIsOk(mobile);
        if (!isMobileOk) {
            return DreamJSONResult.errorMsg("收货人手机号格式不正确");
        }

        String province = addressBO.getProvince();
        String city = addressBO.getCity();
        String district = addressBO.getDistrict();
        String detail = addressBO.getDetail();
        if (StringUtils.isBlank(province) ||
                StringUtils.isBlank(city) ||
                StringUtils.isBlank(district) ||
                StringUtils.isBlank(detail)) {
            return DreamJSONResult.errorMsg("收货地址信息不能为空");
        }

        return DreamJSONResult.ok();
    }
}
