package shuttlein.yangcheng.info.shuttlein;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.JacksonConverter;
import shuttlein.yangcheng.info.shuttlein.api.RouteService;
import shuttlein.yangcheng.info.shuttlein.model.Route;


public class MyActivity extends Activity implements ActionBar.OnNavigationListener {


    public static final String ENDPOINT = "http://dhuang-ld1.linkedin.biz:3000/shuttle/";
    ArrayAdapter<Route> mShuttleSpinnerAdapter;

    Route mCurrentRoute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my2);
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        mShuttleSpinnerAdapter = new ArrayAdapter<Route>(this,android.R.layout.simple_spinner_dropdown_item);
        getActionBar().setListNavigationCallbacks(mShuttleSpinnerAdapter,this);


        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT).setConverter(new JacksonConverter())
                .build();
        restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);

        RouteService service = restAdapter.create(RouteService.class);


        service.listRoutes(new Callback<List<Route>>() {
            @Override
            public void success(List<Route> routes, Response response) {
                mShuttleSpinnerAdapter.addAll(routes);
                getActionBar().setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(int i, long l) {
        mCurrentRoute =  mShuttleSpinnerAdapter.getItem(i);
        updateInfo();
        return true;
    }

    void updateInfo() {
        //TODO
    }
}
