package cn.bravedawn.chapter18.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/11 10:54
 */
@Data
@AllArgsConstructor
public class Session {
    private String userId;
    private String userName;
}
