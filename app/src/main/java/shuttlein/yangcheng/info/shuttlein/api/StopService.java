package shuttlein.yangcheng.info.shuttlein.api;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;
import shuttlein.yangcheng.info.shuttlein.model.Stop;

/**
 * Created by cheyang on 9/22/14.
 */
public interface StopService {
    @GET("/route/{id}/direction/0/stops")
    Observable<List<Stop>> listStops(@Path("id") long routeId);

}
