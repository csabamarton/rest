package dto;

import com.google.common.base.MoreObjects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EventStatisticsResponse {
    @XmlElement(required = false)
    protected boolean successful;
    @XmlElement(required = false)
    protected String errorMessage;

    public EventStatisticsResponse() {
    }

    public EventStatisticsResponse(boolean successful, String errorMessage) {
        this.errorMessage = errorMessage;
        this.successful = successful;
    }

    Event birthDay;
    Event nameDay;
    Event wedding;

    public Event getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Event birthDay) {
        this.birthDay = birthDay;
    }

    public Event getNameDay() {
        return nameDay;
    }

    public void setNameDay(Event nameDay) {
        this.nameDay = nameDay;
    }

    public Event getWedding() {
        return wedding;
    }

    public void setWedding(Event wedding) {
        this.wedding = wedding;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @XmlRootElement
    public static class Event {
        private String eventName;
        private Integer count;

        public Event() {
        }

        public Event(String eventName, Integer count) {
            this.eventName = eventName;
            this.count = count;
        }

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        /* @formatter:off */
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("errorMessage", errorMessage)
                .add("successful", successful);
        /* @formatter:on */
    }

}