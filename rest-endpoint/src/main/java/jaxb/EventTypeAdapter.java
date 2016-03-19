package jaxb;

import dto.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EventTypeAdapter extends XmlAdapter<String, EventType> {
    private static final Logger logger = LoggerFactory.getLogger(EventTypeAdapter.class);

    @Override
    public EventType unmarshal(String value)
    {
        if (value == null) {
            return null;
        }

        try {
            return EventType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e){
            logger.error("No enum constant dto.EventType.{}", value.toUpperCase());

            return null;
        }
    }

    @Override
    public String marshal(EventType value) throws IllegalArgumentException
    {
        if (value == null) {
            return null;
        }

        return value.name();
    }
}

