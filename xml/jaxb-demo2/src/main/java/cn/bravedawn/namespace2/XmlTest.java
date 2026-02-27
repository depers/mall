package cn.bravedawn.namespace2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class XmlTest {

    public static void main(String[] args) throws JAXBException {

        ReqBody reqBody = new ReqBody();
        ReqBody.ReqBodyHeader reqBodyHeader = new ReqBody.ReqBodyHeader();
        reqBodyHeader.setBranchId("1");
        reqBodyHeader.setConsumerId("2");
        reqBodyHeader.setSourceSysId("3");
        reqBody.setReqBodyHeader(reqBodyHeader);

        JAXBContext context = JAXBContext.newInstance(ReqBody.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(
                "com.sun.xml.bind.namespacePrefixMapper",
                new MultiNamespacePrefixMapper()
        );
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // 将对象转为xml
        StringWriter sw = new StringWriter();
        marshaller.marshal(reqBody, sw);
        System.out.println(sw);
    }
}
