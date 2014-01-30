package plugin;

import com.dcsquare.hivemq.spi.HiveMQPluginModule;
import com.dcsquare.hivemq.spi.PluginEntryPoint;
import com.dcsquare.hivemq.spi.plugin.meta.Information;
import com.google.inject.Provider;
import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jackson.map.ObjectMapper;

import static com.dcsquare.hivemq.spi.config.Configurations.noConfigurationNeeded;


@Information(name = "REST Authentication Plugin", author = "Dominik Obermaier", version = "1.0-SNAPSHOT")
public class RESTAuthenticationPluginModule extends HiveMQPluginModule {


    @Override
    public Provider<Iterable<? extends AbstractConfiguration>> getConfigurations() {
        return noConfigurationNeeded();
    }


    @Override
    protected void configurePlugin() {

        bind(ObjectMapper.class).toInstance(new ObjectMapper());
        bind(CloseableHttpClient.class).toInstance(HttpClients.createMinimal());

    }

    @Override
    protected Class<? extends PluginEntryPoint> entryPointClass() {
        return RESTAuthMainClass.class;
    }
}

