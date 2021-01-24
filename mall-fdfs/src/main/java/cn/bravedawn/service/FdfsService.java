package cn.bravedawn.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author : depers
 * @program : mall
 * @description: service接口
 * @date : Created in 2021/1/24 16:23
 */
public interface FdfsService {

    public String upload(MultipartFile file, String fileExtName) throws Exception;
}
