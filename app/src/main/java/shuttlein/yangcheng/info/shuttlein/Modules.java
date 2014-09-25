package shuttlein.yangcheng.info.shuttlein;

/**
 * Created by cheyang on 9/24/14.
 */
public class Modules {
    static Object[] list(ShuttleApp app) {
        return new Object[]{
                new ShuttleModel(app)
        };
    }
}
