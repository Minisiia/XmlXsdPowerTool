package parsers.xpath;

import entity.PowerTool;
import entity.TechnicalCharacteristic;
import enums.Handy;
import enums.PowerConsumption;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class HandlerXpath {

    private InputSource source;
    private XPathExpression expression;
    private PowerTool powerTool;
    private TechnicalCharacteristic tc;

    public HandlerXpath() throws XPathExpressionException, FileNotFoundException {

        XPathFactory factory = XPathFactory.newInstance();
        XPath path = factory.newXPath();
        expression = path.compile("//power_tool | //power_tool/model | //power_tool/handy | //power_tool/origin | //power_tool/material | //power_tool/tc/power_consumption | //power_tool/tc/productivity | //power_tool/tc/autonomy");
        File xml = new File("src/main/java/xml_power_tool/powertool.xml");
        source = new InputSource(new FileInputStream(xml));
        powerTool = new PowerTool();
        tc = new TechnicalCharacteristic();
    }

    public List<PowerTool> getAll() throws XMLStreamException, XPathExpressionException {

        List<PowerTool> powerTools = new ArrayList<>();

        Object result = expression.evaluate(source, XPathConstants.NODESET);

        NodeList list = (NodeList) result;

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            System.out.println("Node name: " + node.getNodeName());
            System.out.println("Node value: " + node.getFirstChild().getNodeValue());
            System.out.print("\n");

            switch (node.getNodeName()) {
                case "power_tool": {
                    if (powerTool.getModel() != null) {
                        powerTools.add(powerTool);
                        powerTool = new PowerTool();
                        tc = new TechnicalCharacteristic();
                        break;
                    }
                }
                case "model":
                    powerTool.setModel(node.getFirstChild().getNodeValue());
                    break;

                case "handy": {
                    if (node.getFirstChild().getNodeValue().equals("Single-hand"))
                        powerTool.setHandy(Handy.SINGLE_HAND);
                    else powerTool.setHandy(Handy.DOUBLE_HAND);
                    break;
                }
                case "origin":
                    powerTool.setOrigin(node.getFirstChild().getNodeValue());
                    break;

                case "material":
                    powerTool.setMaterial(node.getFirstChild().getNodeValue());
                    break;

                case "power_consumption": {
                    if (node.getFirstChild().getNodeValue().equals("Low")) {
                        tc.setPowerConsumption(PowerConsumption.LOW);
                        powerTool.setTc(tc);
                    } else if (node.getFirstChild().getNodeValue().equals("Medium")) {
                        tc.setPowerConsumption(PowerConsumption.MEDIUM);
                        powerTool.setTc(tc);
                    } else {
                        tc.setPowerConsumption(PowerConsumption.HIGH);
                        powerTool.setTc(tc);
                    }
                    break;

                }
                case "productivity": {
                    tc.setProductivity(Integer.parseInt(node.getFirstChild().getNodeValue()));
                    powerTool.setTc(tc);
                }

                case "autonomy": {
                    if (node.getFirstChild().getNodeValue().equals("Yes")) {
                        tc.setAutonomy(true);
                        powerTool.setTc(tc);
                    } else {
                        tc.setAutonomy(false);
                        powerTool.setTc(tc);
                    }
                    break;
                }
            }
        }

        return powerTools;
    }

}
