package parsers.jaxb;

import parsers.jaxb.entity.Power;
import parsers.jaxb.entity.PowerTool;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HandlerJaxb {

    public List<PowerTool> getAll() {
        List<PowerTool> powerTools = new ArrayList<>();
        Power power = new Power();
        try {
            URL url = HandlerJaxb.class.getResource("/xml_power_tool/powertool.xml");
            if (url == null) {
                System.out.println("File not found. Program completed.");
                System.exit(0);
            }
            JAXBContext jaxbContext = JAXBContext.newInstance(Power.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            power = (Power) unmarshaller.unmarshal(url);
            powerTools = power.getPowerTools();
            for (PowerTool powerTool : powerTools)
                System.out.println(powerTool);
        } catch (
                JAXBException e) {
            e.printStackTrace();
        }
        return powerTools;
    }
}
