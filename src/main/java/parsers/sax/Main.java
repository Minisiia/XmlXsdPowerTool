package parsers.sax;

import org.xml.sax.SAXException;
import entity.PowerTool;
import sort_comparator.Sorted;
import xsl_transformer_from_xml_to_xml.XslTransformer;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        HandlerSax handler = new HandlerSax();

        File file = new File("src/main/java/xml_power_tool/powertool.xml");

        if (file.exists()) {
            parser.parse(file, handler);

            List<PowerTool> tools = handler.getTools();

            System.out.println((char) 27 + "[34m" + "\nAll tools: " + (char) 27 + "[38m");
            Sorted.showAllTools(tools);
            Sorted.getSortedByToolsName(tools);
            Sorted.getSortedByToolsOrigin(tools);
            Sorted.getSortedByToolsProductivity(tools);
            XslTransformer.xslTransform();
        }
    }
}
