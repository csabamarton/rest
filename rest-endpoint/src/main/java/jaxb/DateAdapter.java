package jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {

    @Override
    public String marshal(Date value) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (value == null) {
            return null;
        }

        return dateFormat.format(value);
    }

    @Override
    public Date unmarshal(String value) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (value == null) {
            return null;
        }

        return dateFormat.parse(value);
    }

}

