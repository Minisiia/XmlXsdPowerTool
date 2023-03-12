package parsers.jaxb.entity;

import parsers.jaxb.enums.Handy;
import parsers.jaxb.enums.adapters.HandyAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "power_tool")
@XmlAccessorType(XmlAccessType.FIELD)
public class PowerTool {
    @XmlElement(name = "model")
    private String model;
    @XmlElement(name = "handy")
    @XmlJavaTypeAdapter(HandyAdapter.class)
    private Handy handy;
    @XmlElement(name = "origin")
    private String origin;
    @XmlElement(name = "tc")
    private TechnicalCharacteristic tc;
    @XmlElement(name = "material")
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


    public void setModel(String model) {
        this.model = model;
    }

    public Handy getHandy() {
        return handy;
    }


    public void setHandy(Handy handy) {
        this.handy = handy;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public TechnicalCharacteristic getTc() {
        return tc;
    }

    public void setTc(TechnicalCharacteristic tc) {
        this.tc = tc;
    }

    public String getMaterial() {
        return material;
    }

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
