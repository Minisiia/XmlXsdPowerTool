package parsers.jaxb;

import parsers.jaxb.entity.Power;
import parsers.jaxb.entity.PowerTool;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HandlerJaxb {
    private Marshaller marshal;

    public List<PowerTool> getAll() {
        List<PowerTool> powerTools = new ArrayList<>();
        Power power = new Power();
        try {
            // Создаем файл
            File file = new File("src/main/java/xml_power_tool/powertool.xml");
            // Вызываем статический метод JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Power.class);

            // Считываем из файла
            Unmarshaller unmar = jaxbContext.createUnmarshaller();
            power = (Power) unmar.unmarshal(file);
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
