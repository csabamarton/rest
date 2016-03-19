import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import endpoint.EventStatisticsEndpoint;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Map;
import java.util.Set;

@ApplicationPath("/rest")
public class RestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = Sets.newHashSet();

        s.add(EventStatisticsEndpoint.class);

        return s;
    }

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> props = Maps.newHashMap();

        props.put(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        return props;
    }
}