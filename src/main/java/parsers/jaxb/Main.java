package parsers.jaxb;

import parsers.jaxb.entity.PowerTool;
import parsers.xpath.HandlerXpath;
import sort_comparator.Sorted;
import xsl_transformer_from_xml_to_xml.XslTransformer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HandlerJaxb handlerJaxb = new HandlerJaxb();
        List<PowerTool> tools = handlerJaxb.getAll();
        System.out.println((char) 27 + "[34m" + "\nAll tools: " + (char) 27 + "[38m");
        for (PowerTool powerTool : tools) {
            System.out.println(powerTool.getModel() + " " + powerTool.getHandy() + " "
                    + powerTool.getOrigin() + " " + powerTool.getMaterial() + " "
                    + powerTool.getTc().getPowerConsumption() + " "
                    + powerTool.getTc().getProductivity() + " "
                    + powerTool.getTc().isAutonomy()
            );
        }



    }
}
