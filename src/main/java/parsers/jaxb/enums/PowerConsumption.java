package parsers.jaxb.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType()
@XmlEnum(String.class)
public enum PowerConsumption {
    @XmlEnumValue("Low")
    LOW,
    @XmlEnumValue("Medium")
    MEDIUM,
    @XmlEnumValue("High")
    HIGH

}
