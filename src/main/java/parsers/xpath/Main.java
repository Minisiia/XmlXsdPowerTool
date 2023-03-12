package parsers.xpath;

import entity.PowerTool;
import sort_comparator.Sorted;
import xsl_transformer_from_xml_to_xml.XslTransformer;

import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPathExpressionException;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException, XMLStreamException {
        HandlerXpath handlerXpath = new HandlerXpath();
        List<PowerTool> powerTools = handlerXpath.getAll();

        System.out.println((char) 27 + "[34m" + "\nAll tools: " + (char) 27 + "[38m");
        Sorted.showAllTools(powerTools);
        Sorted.getSortedByToolsName(powerTools);
        Sorted.getSortedByToolsOrigin(powerTools);
        Sorted.getSortedByToolsProductivity(powerTools);
        XslTransformer.xslTransform();
    }
}
