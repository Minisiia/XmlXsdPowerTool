package parsers.jaxb.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "power")
public class Power {

    private List<PowerTool> powerTools;

    public Power() {
        powerTools = new ArrayList<>();
    }

    public List<PowerTool> getPowerTools() {
        return powerTools;
    }
    @XmlElement(name = "power_tool")
    public void setPowerTools(List<PowerTool> powerTools) {
        this.powerTools = powerTools;
    }


    @Override
    public String toString() {
        return Arrays.deepToString(powerTools.toArray());
    }

}
