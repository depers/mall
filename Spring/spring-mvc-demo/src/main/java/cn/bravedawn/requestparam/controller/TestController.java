package cn.bravedawn.requestparam.controller;

import cn.bravedawn.requestparam.dto.User;
import cn.bravedawn.requestparam.dto.UserQueryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : depers
 * @program : spring-mvc-demo
 * @date : Created in 2024/7/31 17:05
 */

@RestController
@Slf4j
public class TestController {


    @GetMapping("/getInfo/{id}")
    public User getInfo(@PathVariable(name = "id") Integer id) {
        log.info("获取用户信息");
        return new User("冯晓", 18,"男");
    }
    @GetMapping("/queryInfo")
    public User query(UserQueryDTO queryDTO) {
        log.info("查询用户信息, req={}", queryDTO);
        return new User("冯晓", 18,"男");
    }

    @PostMapping("/addUser")
    public String addUser(User user) {
        log.info("新增用户信息, user={}", user);
        return "success";
    }


    @PutMapping("/updateUser")
    public String updateUser(User user) {
        log.info("更新用户信息, user={}", user);
        return "success";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Integer id) {
        log.info("删除用户信息, id={}", id);
        return "success";
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file) {

        log.info("文件上传, file={}", file.getOriginalFilename());
        return "success";
    }
}
