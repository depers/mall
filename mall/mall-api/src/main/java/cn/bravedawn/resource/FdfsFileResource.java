package cn.bravedawn.resource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : mall
 * @description: fastDFS配置
 * @date : Created in 2021/1/25 15:29
 */
@Component
@ConfigurationProperties(prefix = "file.fdfs")
@PropertySource("classpath:file-upload-dev.properties")
@Data
public class FdfsFileResource {

    private String host;


}
