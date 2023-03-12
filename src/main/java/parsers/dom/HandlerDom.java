package parsers.dom;

import enums.Handy;
import enums.PowerConsumption;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import entity.PowerTool;
import entity.TechnicalCharacteristic;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HandlerDom extends DefaultHandler {
    private Document document;

    public HandlerDom() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);

        DocumentBuilder db = dbf.newDocumentBuilder();

        document = db.parse("src/main/java/xml_power_tool/powertool.xml");
    }

    public List<PowerTool> getAll() {
        List<PowerTool> powerTools = new ArrayList<>();

        Element root = document.getDocumentElement();


        NodeList list = root.getElementsByTagName("power_tool");

        for (int i = 0; i < list.getLength(); i++) {

            String model = root.getElementsByTagName("model").item(i).getFirstChild().getTextContent();
            String handyString = root.getElementsByTagName("handy").item(i).getFirstChild().getTextContent();
            Handy handy = Handy.SINGLE_HAND;
            if (handyString.equals("Double-hand")) handy = Handy.DOUBLE_HAND;
            String origin = root.getElementsByTagName("origin").item(i).getFirstChild().getTextContent();
            String material = root.getElementsByTagName("material").item(i).getFirstChild().getTextContent();
            String powerConsumptionString = root.getElementsByTagName("power_consumption").item(i).getFirstChild().getTextContent();
            PowerConsumption powerConsumption = null;
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
            int productivity = Integer.parseInt(root.getElementsByTagName("productivity").item(i).getFirstChild().getTextContent());
            String autonomyString = root.getElementsByTagName("autonomy").item(i).getFirstChild().getTextContent();
            boolean autonomy = false;
            if (autonomyString.equals("Yes")) autonomy = true;
            TechnicalCharacteristic tc = new TechnicalCharacteristic(powerConsumption, productivity, autonomy);
            PowerTool powerTool = new PowerTool(model, handy, origin, tc, material);
            powerTools.add(powerTool);
        }

        return powerTools;
    }



}
