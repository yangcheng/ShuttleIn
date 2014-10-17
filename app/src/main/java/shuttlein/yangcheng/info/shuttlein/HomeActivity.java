package shuttlein.yangcheng.info.shuttlein;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import retrofit.RestAdapter;
import rx.android.schedulers.AndroidSchedulers;
import shuttlein.yangcheng.info.shuttlein.api.RouteService;
import shuttlein.yangcheng.info.shuttlein.api.StopService;
import shuttlein.yangcheng.info.shuttlein.model.Route;
import shuttlein.yangcheng.info.shuttlein.model.Stop;


public class HomeActivity extends Activity {


    ArrayAdapter<Route> mRouteSpinnerAdapter;

    ArrayAdapter<Stop> mStopSpinnerAdapter;
    Spinner mRoutesSpinner;
    Spinner mStopsSpinner;
    Route mCurrentRoute;

    LongSparseArray<List<Stop>> mStops = new LongSparseArray<List<Stop>>();
    @Inject
    RestAdapter restAdapter;
    @Inject
    RouteService routeService;
    @Inject
    StopService stopService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShuttleApp.get(this).inject(this);
        setContentView(R.layout.activity_home);

        getActionBar().setDisplayShowTitleEnabled(false);
        getActionBar().setDisplayShowCustomEnabled(true);

        getActionBar().setCustomView(R.layout.actionbar_item);


        mRoutesSpinner = (Spinner) getActionBar().getCustomView().findViewById(R.id.spinner1);
        mStopsSpinner = (Spinner) getActionBar().getCustomView().findViewById(R.id.spinner2);
        mRouteSpinnerAdapter = new ArrayAdapter<Route>(this, android.R.layout.simple_spinner_dropdown_item);

        mStopSpinnerAdapter = new ArrayAdapter<Stop>(this, android.R.layout.simple_spinner_dropdown_item);

        mRoutesSpinner.setAdapter(mRouteSpinnerAdapter);
        mRoutesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                     @Override
                                                     public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                                         mCurrentRoute = mRouteSpinnerAdapter.getItem(i);
                                                         updateInfo(mCurrentRoute);
                                                     }

                                                     @Override
                                                     public void onNothingSelected(AdapterView<?> adapterView) {

                                                     }
                                                 }
        );

        mStopsSpinner.setAdapter(mStopSpinnerAdapter);

        restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);

        routeService.listRoutes()
                .observeOn(AndroidSchedulers.mainThread()).subscribe(routes -> updateRoutes(routes),
                error -> Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT));

    }

    void updateRoutes(List<Route> routes) {
        mRouteSpinnerAdapter.clear();
        mRouteSpinnerAdapter.addAll(routes);
        if (mRouteSpinnerAdapter.getCount() > 0) {
            mRoutesSpinner.setVisibility(View.VISIBLE);
        }
        int index = mRoutesSpinner.getSelectedItemPosition();
        if (index == -1) {
            index = 0;
        }
        mCurrentRoute = mRouteSpinnerAdapter.getItem(index);
        updateInfo(mCurrentRoute);
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

    void updateInfo(final Route route) {
        if (route.getRouteId() != mCurrentRoute.getRouteId()) {
            mStopSpinnerAdapter.clear();
        }

        List<Stop> stopList = mStops.get(route.getRouteId());

        if (stopList == null) {
            stopService.listStops(route.getRouteId())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(
                    stops -> {
                        mStops.put(route.getRouteId(), stops);
                        updateInfo(route);
                    },
                    error -> Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT));
        } else {
            mStopSpinnerAdapter.clear();
            mStopSpinnerAdapter.addAll(stopList);
            if (mStopSpinnerAdapter.getCount() > 0) {
                mStopsSpinner.setVisibility(View.VISIBLE);
            }
            //TODO update
        }
        mStopSpinnerAdapter.notifyDataSetChanged();

    }
}
