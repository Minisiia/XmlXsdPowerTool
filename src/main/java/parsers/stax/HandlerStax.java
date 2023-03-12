package parsers.stax;

import entity.PowerTool;
import entity.TechnicalCharacteristic;
import enums.Handy;
import enums.PowerConsumption;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class HandlerStax {
    private Reader reader;
    private XMLStreamReader xmlStreamReader;

    public HandlerStax() throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();

        reader = new FileReader("src/main/java/xml_power_tool/powertool.xml");
        xmlStreamReader = factory.createXMLStreamReader(reader);

    }

    public List<PowerTool> getAll() throws XMLStreamException {
        List<PowerTool> powerTools = new ArrayList<>();
        String handyString;
        String model = null;
        Handy handy = Handy.SINGLE_HAND;
        String origin = null;
        String material = null;
        String powerConsumptionString = null;
        PowerConsumption powerConsumption = null;
        int productivity = 0;
        String autonomyString = null;
        boolean autonomy = false;

        while (xmlStreamReader.hasNext()) {

            switch (xmlStreamReader.next()) {
                case XMLStreamReader.START_ELEMENT:

                    String elem = xmlStreamReader.getName().toString();

                    switch (elem) {
                        case "model": {
                            model = xmlStreamReader.getElementText();
                            System.out.println("model: " + model);
                            break;
                        }

                        case "handy": {
                            handyString = xmlStreamReader.getElementText();
                            if (handyString.equals("Double-hand")) handy = Handy.DOUBLE_HAND;
                            System.out.println("handy: " + handy);
                            break;
                        }
                        case "origin": {
                            origin = xmlStreamReader.getElementText();
                            System.out.println("origin: " + origin);
                            break;
                        }
                        case "material": {
                            material = xmlStreamReader.getElementText();
                            System.out.println("material: " + material);
                            break;
                        }

                        case "tc":
                            break;
                        case "power_consumption": {
                            powerConsumptionString = xmlStreamReader.getElementText();
                            System.out.println("power_consumption: " + powerConsumptionString);
                            switch (powerConsumptionString) {
                                case "Low": {
                                    powerConsumption = PowerConsumption.LOW;
                                    break;
                                }
                                case "Medium": {
                                    powerConsumption = PowerConsumption.MEDIUM;
                                    break;
                                }
                                case "High": {
                                    powerConsumption = PowerConsumption.HIGH;
                                    break;
                                }
                            }
                            break;
                        }

                        case "productivity": {
                            productivity = Integer.parseInt(xmlStreamReader.getElementText());
                            System.out.println("productivity: " + productivity);
                            break;
                        }
                        case "autonomy": {
                            autonomyString = xmlStreamReader.getElementText();
                            if (autonomyString.equals("Yes")) autonomy = true;
                            System.out.println("autonomy: " + autonomyString);
                            break;
                        }
                    }
                    break;

                case XMLStreamReader.END_ELEMENT: {
                    String s = String.valueOf(xmlStreamReader.getName());
                    if (s.equals("power_tool")) {
                        TechnicalCharacteristic tc = new TechnicalCharacteristic(powerConsumption, productivity, autonomy);
                        PowerTool powerTool = new PowerTool(model, handy, origin, tc, material);
                        powerTools.add(powerTool);
                        System.out.println();
                    }
                    break;
                }
            }
        }
        return powerTools;
    }
}
