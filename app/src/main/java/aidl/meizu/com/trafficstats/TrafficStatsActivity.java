package aidl.meizu.com.trafficstats;

import android.net.TrafficStats;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import aidl.meizu.com.trafficstats.Utils.SharedPreferenceUtils;
import aidl.meizu.com.trafficstats.common.Constants;

/**
 * Created by linshaoyou on 16/2/3.
 * 应用app的流量统计页面
 */
public class TrafficStatsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mAppNameTV;
    private TextView mTrafficStatsTotalTV;
    private Button mResetTrafficStatsBtn;
    private Button mRefreshTrafficStatsBtn;
    private String mAppName;
    private int mAppUid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_stats);
        initial();
    }

    @Override
    protected void onStart() {
        super.onStart();
        refleshTrafficStats();
    }

    private void initial() {
        initVars();
        initView();
    }

    private void initVars() {
        mAppName = getIntent().getStringExtra(Constants.APP_NAME);
        mAppUid = getIntent().getIntExtra(Constants.APP_UID, 0);
    }

    private void initView() {
        initAppNameTV();
        initStatsTV();
        initStatsBtn();
    }

    private void initAppNameTV() {
        mAppNameTV = (TextView) findViewById(R.id.appName);
        mAppNameTV.setText(mAppName);
    }

    private void initStatsBtn() {
        mResetTrafficStatsBtn = (Button) findViewById(R.id.resetTrafficStatsBtn);
        mRefreshTrafficStatsBtn = (Button) findViewById(R.id.refleshTrafficStatsBtn);

        mResetTrafficStatsBtn.setOnClickListener(this);
        mRefreshTrafficStatsBtn.setOnClickListener(this);

    }

    private void initStatsTV() {
        mTrafficStatsTotalTV = (TextView) findViewById(R.id.trafficStatsTotal);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.resetTrafficStatsBtn:
                resetTrafficStats();
                break;
            case R.id.refleshTrafficStatsBtn:
                refleshTrafficStats();
                break;
            default:
                break;
        }
    }

    private void resetTrafficStats() {
        long rxBytes = TrafficStats.getUidRxBytes(mAppUid);
        long txBytes = TrafficStats.getUidTxBytes(mAppUid);
        SharedPreferenceUtils.writeSthPreference(this,
                Constants.SP_KEY_TRAFFIC_LAST_TIME, rxBytes + txBytes);
        refleshTrafficStats();
    }

    private void refleshTrafficStats() {
        long rxBytes = TrafficStats.getUidRxBytes(mAppUid);
        long txBytes = TrafficStats.getUidTxBytes(mAppUid);
        long totalBytesWhenStartStats = SharedPreferenceUtils.readSthPreferenceLong(
                this, Constants.SP_KEY_TRAFFIC_LAST_TIME);
        long bytesStatsFromStartStats = rxBytes + txBytes - totalBytesWhenStartStats;
        mTrafficStatsTotalTV.setText("目前所跑流量为：" + bytesStatsFromStartStats / 1024 + " KB");
    }
}
