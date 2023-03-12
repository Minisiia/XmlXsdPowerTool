package parsers.jaxb.enums.adapters;


import parsers.jaxb.enums.PowerConsumption;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PowerConsumptionAdapter extends XmlAdapter<String, PowerConsumption> {

        @Override
        public PowerConsumption unmarshal(String v) throws Exception {
            return PowerConsumption.valueOf(v.toUpperCase());
        }

        @Override
        public String marshal(PowerConsumption v) throws Exception {
            return v.name().toLowerCase();
        }
    }
