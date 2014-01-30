package plugin;

import callbacks.AuthenticationCallback;
import com.dcsquare.hivemq.spi.PluginEntryPoint;
import com.dcsquare.hivemq.spi.callback.registry.CallbackRegistry;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class RESTAuthMainClass extends PluginEntryPoint {


    private final AuthenticationCallback authCallback;

    @Inject
    public RESTAuthMainClass(final AuthenticationCallback authCallback) {
        this.authCallback = authCallback;
    }

    @PostConstruct
    public void postConstruct() {

        final CallbackRegistry callbackRegistry = getCallbackRegistry();
        callbackRegistry.addCallback(authCallback);
    }
}
