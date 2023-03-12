package parsers.stax;

import entity.PowerTool;
import sort_comparator.Sorted;
import xsl_transformer_from_xml_to_xml.XslTransformer;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
       HandlerStax handlerStax = new HandlerStax();
       List<PowerTool> powerTools = handlerStax.getAll();

        System.out.println((char) 27 + "[34m" + "\nAll tools: " + (char) 27 + "[38m");
        Sorted.showAllTools(powerTools);
        Sorted.getSortedByToolsName(powerTools);
        Sorted.getSortedByToolsOrigin(powerTools);
        Sorted.getSortedByToolsProductivity(powerTools);
        XslTransformer.xslTransform();
    }
}
