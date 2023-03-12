package parsers.jaxb.enums.adapters;

import parsers.jaxb.enums.Handy;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class HandyAdapter extends XmlAdapter<String, Handy> {

    @Override
    public Handy unmarshal(String v) throws Exception {
        Handy handy = Handy.SINGLE_HAND;
        if (v.equals("Double-hand")) handy = Handy.DOUBLE_HAND;
        return handy;
    }

    @Override
    public String marshal(Handy v) throws Exception {
        String s = "Single-hand";
        if (v.name().equals("DOUBLE_HAND")) s = "Double-hand";
        return s;
    }
}

