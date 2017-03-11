package jti46.ider.engine;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import jti46.ider.R;

/**
 * Created by yunhasnawa on 11/03/17.
 */

public class CommodityListAdapter extends BaseAdapter
{

    private static LayoutInflater inflater;

    private AppCompatActivity hostActivity;
    private Context context;
    private ArrayList<Commodity> data;

    public CommodityListAdapter(AppCompatActivity hostActivity, ArrayList<Commodity> data)
    {
        this.hostActivity = hostActivity;
        this.data = data;

        this.context = this.hostActivity.getApplicationContext();

        CommodityListAdapter.inflater = (LayoutInflater) this.context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int position) {
        return this.data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;

        if(view == null)
        {
            view = CommodityListAdapter.inflater.inflate(R.layout.adapter_commodity_list, null);
        }

        this.initComponents(view);
        this.fillComponents(position);

        return view;
    }

    private void initComponents(View view)
    {

    }

    private void fillComponents(int position)
    {
        Commodity commodity = (Commodity) this.getItem(position);
        String viewTag = String.valueOf(position);
    }
}
