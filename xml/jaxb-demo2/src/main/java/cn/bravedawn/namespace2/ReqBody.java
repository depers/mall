package cn.bravedawn.namespace2;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "ReqBody")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqBody {

    @XmlElement(name = "ReqBodyHeader")
    private ReqBodyHeader reqBodyHeader;


    @Data
    @XmlRootElement(name = "ReqHeader")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ReqBodyHeader{

        @XmlElement(name = "BranchId")
        private String branchId;

        @XmlElement(name = "ConsumerId", namespace = "http://bravedawn.cn/services/ConsumerId")
        private String consumerId;

        @XmlElement(name = "SourceSysId", namespace = "http://bravedawn.cn/services/SourceSysId")
        private String sourceSysId;
    }

}
