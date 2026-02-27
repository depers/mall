package cn.bravedawn.namespace2;

import java.util.HashMap;
import java.util.Map;

public class MultiNamespacePrefixMapper extends com.sun.xml.bind.marshaller.NamespacePrefixMapper {


    private static final Map<String, String> NS_MAP = new HashMap<>();

    static {
        NS_MAP.put("http://bravedawn.cn/services/ConsumerId",  "s");
        NS_MAP.put("http://bravedawn.cn/services/SourceSysId", "d");
    }

    @Override
    public String getPreferredPrefix(
            String namespaceUri,
            String suggestion,
            boolean requirePrefix) {

        return NS_MAP.getOrDefault(namespaceUri, suggestion);
    }
}
