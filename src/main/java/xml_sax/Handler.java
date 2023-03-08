package xml_sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import xml_sax.entity.PowerTool;
import xml_sax.entity.TechnicalCharacteristic;
import xml_sax.enums.Handy;
import xml_sax.enums.PowerConsumption;

import java.util.ArrayList;
import java.util.List;

public class Handler extends DefaultHandler {
    private String currentQName;
    private List<PowerTool> tools;
    private PowerTool currentTool;
    private TechnicalCharacteristic tc;

    public Handler() {
        tools = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
        currentQName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        System.out.println("Characters: " + value);

        switch (currentQName) {
            case "power_tool": {
                currentTool = new PowerTool();
                tc = new TechnicalCharacteristic();
                break;
            }
            case "model":
                currentTool.setModel(value);
                break;
            case "handy": {
                if (value.equals("Single-hand"))
                    currentTool.setHandy(Handy.SINGLE_HAND);
                else currentTool.setHandy(Handy.DOUBLE_HAND);
                break;
            }
            case "origin":
                currentTool.setOrigin(value);
                break;
            case "material":
                currentTool.setMaterial(value);
                break;
            case "power_consumption": {
                if (value.equals("Low")) {
                    tc.setPowerConsumption(PowerConsumption.LOW);
                    currentTool.setTc(tc);
                } else if (value.equals("Medium")) {
                    tc.setPowerConsumption(PowerConsumption.MEDIUM);
                    currentTool.setTc(tc);
                } else {
                    tc.setPowerConsumption(PowerConsumption.HIGH);
                    currentTool.setTc(tc);
                }
                break;
            }
            case "productivity": {
                tc.setProductivity(Integer.parseInt(value));
                currentTool.setTc(tc);
            }
            case "autonomy": {
                if (value.equals("Yes")) {
                    tc.setAutonomy(true);
                    currentTool.setTc(tc);
                } else {
                    tc.setAutonomy(false);
                    currentTool.setTc(tc);
                }
                break;
            }
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
        currentQName = "";

        if (qName.equals("power_tool")) {
            tools.add(currentTool);
        }
    }

    public List<PowerTool> getTools() {
        return tools;
    }

    @Override
    public void endDocument() throws SAXException {
        currentTool = null;
    }
}
