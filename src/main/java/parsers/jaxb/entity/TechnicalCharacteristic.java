package parsers.jaxb.entity;

import enums.PowerConsumption;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "tc")

public class TechnicalCharacteristic {
    private PowerConsumption powerConsumption;
    private int productivity;
    @XmlValue
    private boolean autonomy;

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

    //@XmlElement(name = "power_consumption")
    public void setPowerConsumption(PowerConsumption powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getProductivity() {
        return productivity;
    }

   // @XmlElement(name = "productivity")
    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }

    public boolean isAutonomy() {
        return autonomy;
    }

   // @XmlElement(name = "autonomy")
    public void setAutonomy(boolean autonomy) {
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
