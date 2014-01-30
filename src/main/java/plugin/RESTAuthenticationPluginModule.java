/*
 * Copyright 2014 Dominik Obermaier <dominik.obermaier@dc-square.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

