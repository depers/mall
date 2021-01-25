package cn.bravedawn.controller;

import cn.bravedawn.service.FdfsService;
import cn.bravedawn.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : depers
 * @program : mall
 * @description: 文件上传
 * @date : Created in 2021/1/25 12:39
 */
@RestController
@RequestMapping("fdfs")
@Slf4j
public class FileUploadController {

    @Autowired
    private FdfsService fdfsService;

    @PostMapping("upload")
    public JsonResult uploadFace(MultipartFile file) throws Exception{

        if(file != null) {
            // 获取文件上传的文件名称
            String fileName = file.getOriginalFilename();

            if (StringUtils.isNotBlank(fileName)){
                // 文件重命名  imooc-face.png -> ["imooc-face", "png"]
                String fileNameArr[] = fileName.split("\\.");

                // 获取文件的后缀名
                String suffix = fileNameArr[fileNameArr.length - 1];

                if (!suffix.equalsIgnoreCase("png") &&
                        !suffix.equalsIgnoreCase("jpg") &&
                        !suffix.equalsIgnoreCase("jpeg") ) {
                    return JsonResult.errorMsg("图片格式不正确！");
                }

                String path = fdfsService.upload(file, suffix);
                log.info("upload file path: {}.", path);
                return JsonResult.ok(path);
            }
        }
        return JsonResult.errorMsg("error");
    }

}
