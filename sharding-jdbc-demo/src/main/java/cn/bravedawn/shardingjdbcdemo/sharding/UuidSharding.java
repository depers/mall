package cn.bravedawn.shardingjdbcdemo.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author : depers
 * @program : sharding-jdbc-demo
 * @description: 自定义UUID分片策略
 * @date : Created in 2021/8/30 21:28
 */
public class UuidSharding implements PreciseShardingAlgorithm<String> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        String uuid = preciseShardingValue.getValue();
        int mode = uuid.hashCode() % collection.size();

        String[] strs = collection.toArray(new String[0]);
        mode = Math.abs(mode);

        System.out.println("分片表：" + strs[0] + ", " + strs[1]);
        System.out.println("mode = " + mode);
        return strs[mode];
    }
}
