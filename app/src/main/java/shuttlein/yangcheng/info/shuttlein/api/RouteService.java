package shuttlein.yangcheng.info.shuttlein.api;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;
import shuttlein.yangcheng.info.shuttlein.model.Route;

/**
 * Created by cheyang on 9/19/14.
 */
public interface RouteService {
    @GET("/region/0/routes")
    Observable<List<Route>> listRoutes();
}
