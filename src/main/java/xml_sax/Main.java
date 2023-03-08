package xml_sax;

import org.xml.sax.SAXException;
import xml_sax.entity.PowerTool;
import xml_sax.entity.TechnicalCharacteristic;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        Handler handler = new Handler();

        File file = new File("src/main/java/power_tool/powertool.xml");

        if (file.exists()) {
            parser.parse(file, handler);

            List<PowerTool> tools = handler.getTools();

            System.out.println((char) 27 + "[34m" + "\nAll tools: " + (char) 27 + "[38m");

            for (PowerTool powerTool : tools) {
                System.out.println(powerTool.getModel() + " " + powerTool.getHandy() + " "
                        + powerTool.getOrigin() + " " + powerTool.getMaterial() + " "
                        + powerTool.getTc().getPowerConsumption() + " "
                        + powerTool.getTc().getProductivity() + " "
                        + powerTool.getTc().isAutonomy()
                );
            }

            System.out.println((char) 27 + "[34m" + "\nSorted by tools name: " + (char) 27 + "[38m");
            tools.sort(Comparator.comparing(PowerTool::getModel));
            for (PowerTool powerTool : tools) {
                System.out.println(powerTool.getModel() + " " + powerTool.getHandy() + " "
                        + powerTool.getOrigin() + " " + powerTool.getMaterial() + " "
                        + powerTool.getTc().getPowerConsumption() + " "
                        + powerTool.getTc().getProductivity() + " "
                        + powerTool.getTc().isAutonomy()
                );
            }

            System.out.println((char) 27 + "[34m" + "\nSorted by tools origin: " + (char) 27 + "[38m");
            tools.sort(Comparator.comparing(PowerTool::getOrigin));
            for (PowerTool powerTool : tools) {
                System.out.println(powerTool.getModel() + " " + powerTool.getHandy() + " "
                        + powerTool.getOrigin() + " " + powerTool.getMaterial() + " "
                        + powerTool.getTc().getPowerConsumption() + " "
                        + powerTool.getTc().getProductivity() + " "
                        + powerTool.getTc().isAutonomy()
                );
            }

            System.out.println((char) 27 + "[34m" + "\nSorted by tools productivity: " + (char) 27 + "[38m");
            tools.sort(Comparator.comparingInt(o -> o.getTc().getProductivity()));
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
}
