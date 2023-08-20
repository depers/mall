package cn.bravedawn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : depers
 * @program : openfeign-demo
 * @description:
 * @date : Created in 2023/1/6 15:46
 */
@RestController
public class FileUploadController {


    @PostMapping("/upload")
    public String updateFile(@RequestPart MultipartFile file) {
        return "success";
    }
}
