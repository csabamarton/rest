package dto;

public enum EventType {
    BIRTHDAY, NAMEDAY, WEDDING, ALL;

    EventType() {
    }

    public String getLabel() {
        return this.name().toLowerCase();
    }

    public static EventType fromLabel(String label) {
        for (EventType eventType : EventType.values()) {
            if (eventType.getLabel().equals(label)) {
                return eventType;
            }
        }
        throw new IllegalArgumentException("EventType with label " + label + " not found");
    }
}
