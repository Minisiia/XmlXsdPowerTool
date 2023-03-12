package parsers.jaxb.entity;

import parsers.jaxb.enums.PowerConsumption;
import parsers.jaxb.enums.adapters.BooleanAdapter;
import parsers.jaxb.enums.adapters.PowerConsumptionAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "tc")
@XmlAccessorType(XmlAccessType.FIELD)
public class TechnicalCharacteristic {
    @XmlElement(name = "power_consumption")
    @XmlJavaTypeAdapter(PowerConsumptionAdapter.class)
    private PowerConsumption powerConsumption;
    @XmlElement(name = "productivity")
    private int productivity;
    @XmlElement(name = "autonomy")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean autonomy;

    public TechnicalCharacteristic() {
    }

    public TechnicalCharacteristic(PowerConsumption powerConsumption, int productivity, boolean autonomy) {
        this.powerConsumption = powerConsumption;
        this.productivity = productivity;
        this.autonomy = autonomy;
    }

    public PowerConsumption getPowerConsumption() {
        return powerConsumption;
    }


    public void setPowerConsumption(PowerConsumption powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getProductivity() {
        return productivity;
    }


    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }

    public Boolean isAutonomy() {
        return autonomy;
    }


    public void setAutonomy(Boolean autonomy) {
        this.autonomy = autonomy;
    }

    @Override
    public String toString() {
        return "TechnicalCharacteristic{" +
                "powerConsumption=" + powerConsumption +
                ", productivity=" + productivity +
                ", autonomy=" + autonomy +
                '}';
    }
}
