package endpoint;

import dto.EventStatisticsRequest;
import dto.EventStatisticsResponse;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Path("/eventStatistics")
public class EventStatisticsEndpoint {

    @GET
    @Path("/test")
    public String testEndPoint(){
        return "It works";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getBetweenDateAndEventType")
    public EventStatisticsResponse getUsageStatistics(
            @Valid EventStatisticsRequest eventStatisticsRequest)
    {
        EventStatisticsResponse eventStatisticsResponse = new EventStatisticsResponse();

        EventStatisticsResponse.Event bDay = new EventStatisticsResponse.Event("birthDay", 3);
        eventStatisticsResponse.setBirthDay(bDay);
        EventStatisticsResponse.Event nDay = new EventStatisticsResponse.Event("nameDay", 2);
        eventStatisticsResponse.setNameDay(nDay);
        EventStatisticsResponse.Event wedding = new EventStatisticsResponse.Event("wedding", 6);
        eventStatisticsResponse.setWedding(wedding);

        eventStatisticsResponse.setSuccessful(true);

        return eventStatisticsResponse;
    }
}
