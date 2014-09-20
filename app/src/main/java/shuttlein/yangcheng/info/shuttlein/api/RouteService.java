package shuttlein.yangcheng.info.shuttlein.api;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import shuttlein.yangcheng.info.shuttlein.model.Route;

/**
 * Created by cheyang on 9/19/14.
 */
public interface RouteService {
    @GET("/region/0/routes")
    void listRoutes(Callback<List<Route>> callback);
}
