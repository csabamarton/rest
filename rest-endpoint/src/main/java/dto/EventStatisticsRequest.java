package dto;

import jaxb.DateAdapter;
import jaxb.EventTypeAdapter;
import validator.EventStatisticsConstraint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@EventStatisticsConstraint
public class EventStatisticsRequest {

    public EventStatisticsRequest() {
    }

    @XmlJavaTypeAdapter(value = DateAdapter.class, type = Date.class)
    private Date startDate;

    @XmlJavaTypeAdapter(value = DateAdapter.class, type = Date.class)
    private Date endDate;

    @XmlJavaTypeAdapter(value = EventTypeAdapter.class, type = EventType.class)
    private EventType eventType;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

}
