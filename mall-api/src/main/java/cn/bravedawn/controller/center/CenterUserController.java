package cn.bravedawn.controller.center;

import cn.bravedawn.bo.center.CenterUserBO;
import cn.bravedawn.controller.BaseController;
import cn.bravedawn.pojo.Users;
import cn.bravedawn.resource.FdfsFileResource;
import cn.bravedawn.resource.FileUpload;
import cn.bravedawn.service.FdfsService;
import cn.bravedawn.service.center.CenterUserService;
import cn.bravedawn.utils.CookieUtils;
import cn.bravedawn.utils.DateUtil;
import cn.bravedawn.utils.JsonResult;
import cn.bravedawn.utils.JsonUtils;
import cn.bravedawn.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 冯晓
 * @Date 2020/3/25 22:12
 */
@Api(value = "用户信息接口", tags = {"用户信息相关接口"})
@RestController
@RequestMapping("userInfo")
@Slf4j
public class CenterUserController extends BaseController {

    @Autowired
    private CenterUserService centerUserService;

    @Autowired
    private FileUpload fileUpload;

    @Autowired
    private FdfsService fdfsService;

    @Autowired
    private FdfsFileResource fdfsFileResource;

    @ApiOperation(value = "用户头像修改", notes = "用户头像修改", httpMethod = "POST")
    @PostMapping("uploadFace")
    public JsonResult uploadFace(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "file", value = "用户头像", required = true)
            MultipartFile file,
            HttpServletRequest request, HttpServletResponse response) throws Exception {


        // 开始文件上传
        String path = "";
        if (file != null) {
            // 获得文件上传的文件名称
            String fileName = file.getOriginalFilename();
            if (StringUtils.isNotBlank(fileName)) {
                String fileNameArr[] = fileName.split("\\.");
                // 获取文件的后缀名
                String suffix = fileNameArr[fileNameArr.length - 1];

                if (!suffix.equalsIgnoreCase("png") &&
                        !suffix.equalsIgnoreCase("jpg") &&
                        !suffix.equalsIgnoreCase("jpeg") ) {
                    return JsonResult.errorMsg("图片格式不正确！");
                }

                // 上传文件到fastDFS
                path = fdfsService.upload(file, suffix);
            }
        } else {
            return JsonResult.errorMsg("文件不能为空！");
        }

        if (StringUtils.isNotBlank(path)) {
            String finalUserFaceUrl = fdfsFileResource.getHost() + path;
            // 更新用户头像到数据库
            Users userResult = centerUserService.updateUserFace(userId, finalUserFaceUrl);

            // 增加令牌token，会整合进redis，分布式会话
            UserVO userVO = conventUser(userResult);

            // userResult = setNullProperty(userResult);
            CookieUtils.setCookie(request, response, "user",
                    JsonUtils.objectToJson(userVO), true);

            return JsonResult.ok();
        }else {
            return JsonResult.errorMsg("上传头像失败");
        }
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息", httpMethod = "POST")
    @PostMapping("update")
    public JsonResult update(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @RequestBody @Valid CenterUserBO centerUserBO,
            BindingResult result,
            HttpServletRequest request, HttpServletResponse response) {

        // 判断BindingResult是否保存错误的验证信息，如果有，则直接return
        if (result.hasErrors()) {
            Map<String, String> errorMap = getErrors(result);
            return JsonResult.errorMap(errorMap);
        }

        Users userResult = centerUserService.updateUserInfo(userId, centerUserBO);

        // 增加令牌token，会整合进redis，分布式会话
        UserVO userVO = conventUser(userResult);

        // userResult = setNullProperty(userResult);
        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userVO), true);

        // 增加令牌token，会整合进redis，分布式会话

        return JsonResult.ok();
    }

    private Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<>();
        List<FieldError> errorList = result.getFieldErrors();
        for (FieldError error : errorList) {
            // 发生验证错误所对应的某一个属性
            String errorField = error.getField();
            // 验证错误的信息
            String errorMsg = error.getDefaultMessage();

            map.put(errorField, errorMsg);
        }
        return map;
    }

    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }
}
