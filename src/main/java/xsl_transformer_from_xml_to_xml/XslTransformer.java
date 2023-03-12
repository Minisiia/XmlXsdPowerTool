package xsl_transformer_from_xml_to_xml;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XslTransformer {

    public static void xslTransform() {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = tf.newTransformer(new StreamSource("src/main/java/xml_power_tool/powertool.xslt"));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource("src/main/java/xml_power_tool/powertool.xml"),
                    new StreamResult("src/main/java/xml_power_tool/new_origin_root.xml"));
            System.out.println("\nTransform complete");
        } catch (
                TransformerException e) {
            System.err.println("Impossible transform file: " + e);
        }
    }
}
