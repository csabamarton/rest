package dto;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URL;

import static com.google.common.truth.Truth.assertThat;

public class EventStatisticsRequestTest {
    private final static String JSON_FILE = "jaxb/eventStatisticsRequest.json";

    private ObjectMapper mapper;

    @Before
    public void setUp() throws Exception
    {
        mapper = new ObjectMapper();
        AnnotationIntrospector introspector = new JaxbAnnotationIntrospector(
                mapper.getTypeFactory());
        mapper.setAnnotationIntrospector(introspector);
    }

    @Test
    public void jaxbTestConvertUsageStatisticsJSONToPOJO() throws JAXBException, IOException
    {
        URL url = Resources.getResource(JSON_FILE);
        String jsonData = Resources.toString(url, Charsets.UTF_8);

        EventStatisticsRequest eventStatisticsRequest = mapper.readValue(jsonData,
                EventStatisticsRequest.class);

        assertThat(eventStatisticsRequest).isNotNull();
        assertThat(eventStatisticsRequest.getStartDate()).isNotNull();
        assertThat(eventStatisticsRequest.getEndDate()).isNotNull();
        assertThat(eventStatisticsRequest.getEventType()).isNotNull();
    }
}