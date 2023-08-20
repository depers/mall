package cn.bravedawn.annotation.parameterexample;

public class Controller {


    public String queryOrder(@ParameterType(type = "string") @Operation(value = "查询订单", notes = "查询订单的信息") String username,
                             @ParameterType(type = "long") long areaId) {
        return "success";
    }

}
