package parsers.dom;

import entity.PowerTool;
import org.xml.sax.SAXException;
import sort_comparator.Sorted;
import xsl_transformer_from_xml_to_xml.XslTransformer;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        HandlerDom handlerDom = new HandlerDom();
        List<PowerTool> powerTools = handlerDom.getAll();

        System.out.println((char) 27 + "[34m" + "\nAll tools: " + (char) 27 + "[38m");
        Sorted.showAllTools(powerTools);
        Sorted.getSortedByToolsName(powerTools);
        Sorted.getSortedByToolsOrigin(powerTools);
        Sorted.getSortedByToolsProductivity(powerTools);
        XslTransformer.xslTransform();
    }
}
