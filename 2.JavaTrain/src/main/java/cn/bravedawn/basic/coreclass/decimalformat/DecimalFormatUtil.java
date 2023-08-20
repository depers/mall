package cn.bravedawn.basic.coreclass.decimalformat;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/4/26 17:39
 */
public class DecimalFormatUtil {


    /**
     * 用DecimalFormat 格式化String类型的数据
     */


    /**
     * @param str 需要格式化的字符串
     * @return 格式化后的double型数值
     */
    public static double stringToDouble(String str) {
        if (StringUtils.isEmpty(str)) {
            return 0;
        }
        DecimalFormat format = new DecimalFormat("#.##");
        //提供 RoundingMode 中定义的舍入模式进行格式化。默认情况下，它使用 RoundingMode.HALF_EVEN。
        format.setRoundingMode(RoundingMode.DOWN);
        //使用BigDecimal对象来将String类型转换为DecimalFormat可以格式化的类型。
        String formatStr = format.format(new BigDecimal(str));
        //将格式化后的类型，转换为double类型（当然，也可以转换为float或int，视需求而定）。
        BigDecimal bigDecimal = new BigDecimal(formatStr);
        return bigDecimal.doubleValue();
    }
}
