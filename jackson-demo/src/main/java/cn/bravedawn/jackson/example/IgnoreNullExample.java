package cn.bravedawn.jackson.example;

import cn.bravedawn.jackson.dto.MyDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author : depers
 * @program : jackson-demo
 * @description: 忽略null
 * @date : Created in 2021/11/6 10:36
 */
public class IgnoreNullExample {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        MyDto dtoObject = new MyDto();

        String dtoAsString = mapper.writeValueAsString(dtoObject);

        System.out.println(dtoAsString);

    }
}
