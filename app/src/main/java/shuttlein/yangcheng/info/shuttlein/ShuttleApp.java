package shuttlein.yangcheng.info.shuttlein;

import android.app.Application;
import android.content.Context;

import dagger.ObjectGraph;

/**
 * Created by cheyang on 9/19/14.
 */
public class ShuttleApp extends Application{
    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        buildObjectGraphAndInject();
    }

    public void buildObjectGraphAndInject(){
        objectGraph = ObjectGraph.create(Modules.list(this));
        objectGraph.inject(this);
    }

    public static ShuttleApp get(Context context) {
        return (ShuttleApp) context.getApplicationContext();
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }
}
