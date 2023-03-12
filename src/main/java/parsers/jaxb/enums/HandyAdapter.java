package parsers.jaxb.enums;

import javax.xml.bind.annotation.adapters.XmlAdapter;

    public class HandyAdapter extends XmlAdapter<String, Handy> {

        @Override
        public Handy unmarshal(String v) throws Exception {
            return Handy.valueOf(v.toUpperCase());
        }

        @Override
        public String marshal(Handy v) throws Exception {
            return v.name().toLowerCase();
        }
    }

