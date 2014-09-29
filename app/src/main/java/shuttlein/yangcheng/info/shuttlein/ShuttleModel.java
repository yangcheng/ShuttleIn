package shuttlein.yangcheng.info.shuttlein;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.JacksonConverter;
import shuttlein.yangcheng.info.shuttlein.api.RouteService;
import shuttlein.yangcheng.info.shuttlein.api.StopService;

/**
 * Created by cheyang on 9/24/14.
 */
@Module(
        injects = {
                ShuttleApp.class,
        HomeActivity.class},
        library = true
)
public final class ShuttleModel {
    public static final String ENDPOINT = "http://www.shuttlein.dihuang.me/shuttle";

    private final ShuttleApp app;
    public ShuttleModel(ShuttleApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    RestAdapter provideRestAdapter() {
        return new RestAdapter.Builder() //
                .setClient(new OkClient(new OkHttpClient()))
                .setEndpoint(ENDPOINT) //
                .setConverter(new JacksonConverter())
                .build();
    }

    @Provides
    @Singleton
    RouteService provideRouteService(RestAdapter restAdapter) {
        return restAdapter.create(RouteService.class);
    }

    @Provides
    @Singleton
    StopService provideStopService(RestAdapter restAdapter) {
        return restAdapter.create(StopService.class);
    }
}
