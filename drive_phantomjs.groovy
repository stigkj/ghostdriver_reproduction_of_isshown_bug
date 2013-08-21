@Grapes([
    @Grab("org.gebish:geb-core:0.9.1"),
    @Grab("com.google.guava:guava:14.0.1"),
    @Grab("com.github.detro.ghostdriver:phantomjsdriver:1.0.4"),
])
import geb.Browser
import geb.Configuration

import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableMap

def c = new Configuration()
c.driver = new PhantomJSDriver(new ExternallyStartedPhantomJsService(), new DesiredCapabilities())

class ExternallyStartedPhantomJsService extends org.openqa.selenium.remote.service.DriverService {
    ExternallyStartedPhantomJsService() throws IOException {
        super(new File('.'), 8910, ImmutableList.of(), ImmutableMap.of());
    }

    @Override
    public URL getUrl() {
        return new URL('http://localhost:8910')
    }

    @Override
    public boolean isRunning() {
        return true;
    }

    @Override
    public void start() throws IOException {
    }

    @Override
    public void stop() {
    }
}


Browser.drive(c) {
  go "http://localhost:4567"

  println $("*[data-automation-id='get_this']").text()
}