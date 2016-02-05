package aidl.meizu.com.trafficstats;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import aidl.meizu.com.trafficstats.adapter.AppListViewAdapter;
import aidl.meizu.com.trafficstats.common.Constants;
import aidl.meizu.com.trafficstats.model.AppInfo;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<AppInfo> mAppList = new ArrayList<>();;
    private ListView mAppListview;
    private AppListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initial();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void initial() {
        initView();
        initVars();
    }

    private void initVars() {
        List<PackageInfo> packages = getPackageManager().getInstalledPackages(0);

        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = packages.get(i);
            AppInfo tmpInfo = new AppInfo();
            tmpInfo.appName = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
            tmpInfo.packageName = packageInfo.packageName;
            tmpInfo.versionName = packageInfo.versionName;
            tmpInfo.versionCode = packageInfo.versionCode;
            tmpInfo.uid = packageInfo.applicationInfo.uid;
            tmpInfo.appIcon = packageInfo.applicationInfo.loadIcon(getPackageManager());
            if (tmpInfo.appName.equalsIgnoreCase("资讯")){
                mAppList.add(0, tmpInfo);
            }else {
                mAppList.add(tmpInfo);
            }
            mAdapter.notifyDataSetChanged();
            Log.d("LSY", "TMPINFO == " + tmpInfo);

        }//好啦 这下手机上安装的应用数据都存在appList里了。
    }

    private void initView() {
        mAdapter = new AppListViewAdapter(this, mAppList);

        mAppListview = (ListView)findViewById(R.id.packageList);
        mAppListview.setAdapter(mAdapter);
        mAppListview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, TrafficStatsActivity.class);
        intent.putExtra(Constants.APP_NAME, mAppList.get(position).appName);
        intent.putExtra(Constants.APP_UID, mAppList.get(position).uid);
        startActivity(intent);
    }
}
