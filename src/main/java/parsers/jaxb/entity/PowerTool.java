package parsers.jaxb.entity;

import enums.Handy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "power_tool")
public class PowerTool {
    private String model;
    private Handy handy;
    private String origin;
    private TechnicalCharacteristic tc;
    private String material;

    public PowerTool() {
    }

    public PowerTool(String model, Handy handy, String origin, TechnicalCharacteristic tc, String material) {
        this.model = model;
        this.handy = handy;
        this.origin = origin;
        this.tc = tc;
        this.material = material;
    }

    public String getModel() {
        return model;
    }

    //@XmlElement(name = "model")
    public void setModel(String model) {
        this.model = model;
    }

    public Handy getHandy() {
        return handy;
    }

    //@XmlElement(name = "handy")
    public void setHandy(Handy handy) {
        this.handy = handy;
    }

    public String getOrigin() {
        return origin;
    }
    //@XmlElement(name = "origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public TechnicalCharacteristic getTc() {
        return tc;
    }
   // @XmlElement(name = "tc")
    public void setTc(TechnicalCharacteristic tc) {
        this.tc = tc;
    }

    public String getMaterial() {
        return material;
    }
  //  @XmlElement(name = "material")
    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "PowerTool{" +
                "model='" + model + '\'' +
                ", handy=" + handy +
                ", origin='" + origin + '\'' +
                ", tc=" + tc +
                ", material='" + material + '\'' +
                '}';
    }
}
