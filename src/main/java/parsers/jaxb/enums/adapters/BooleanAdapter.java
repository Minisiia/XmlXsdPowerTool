package parsers.jaxb.enums.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BooleanAdapter extends XmlAdapter<String, Boolean> {

    @Override
    public Boolean unmarshal(String v) throws Exception {
        return "Yes".equals(v);
    }

    @Override
    public String marshal(Boolean v) throws Exception {
        return v ? "Yes" : "No";
    }
}

