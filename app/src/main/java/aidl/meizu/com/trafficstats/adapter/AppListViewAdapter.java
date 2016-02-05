package aidl.meizu.com.trafficstats.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import aidl.meizu.com.trafficstats.R;
import aidl.meizu.com.trafficstats.model.AppInfo;

/**
 * Created by linshaoyou on 16/2/3.
 * app列表的adapter
 */
public class AppListViewAdapter extends BaseAdapter {

    private List<AppInfo> mAppInfoList = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public AppListViewAdapter(Context context, List<AppInfo> appInfoList){
        mContext = context;
        mAppInfoList = appInfoList;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mAppInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAppInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.app_lv_item,null);
            holder = new Holder();
            holder.appIconImg = (ImageView)convertView.findViewById(R.id.appIcon);
            holder.appTitle = (TextView)convertView.findViewById(R.id.appTitle);
            convertView.setTag(holder);
        }else {
            holder = (Holder)convertView.getTag();
        }
        holder.appIconImg.setImageDrawable(mAppInfoList.get(position).appIcon);
        holder.appTitle.setText(mAppInfoList.get(position).appName);
        return convertView;
    }

    class Holder{
        public ImageView appIconImg;
        public TextView appTitle;
    }
}
