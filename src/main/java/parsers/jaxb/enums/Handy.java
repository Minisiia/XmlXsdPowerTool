package parsers.jaxb.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


//@XmlEnum()
public enum Handy {
    @XmlEnumValue("Single-hand")
    SINGLE_HAND,
    @XmlEnumValue("Double-hand")
    DOUBLE_HAND


}
