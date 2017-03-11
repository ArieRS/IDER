package jti46.ider.engine;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import jti46.ider.R;

/**
 * Created by yunhasnawa on 11/03/17.
 */

public class VendorListAdapter extends BaseAdapter
{
    private static LayoutInflater inflater;

    private Context context;
    private ArrayList<Vendor> data;

    private TextView txvVendorUsername;
    private TextView txvVendorCategoryDisplayName;
    private TextView txvVendorStatus;
    private TextView txvVendorLocationDistance;

    public VendorListAdapter(Context context, ArrayList<Vendor> data)
    {
        this.context = context;
        this.data = data;

        VendorListAdapter.inflater = (LayoutInflater) this.context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return this.data.size();
    }

    @Override
    public Vendor getItem(int position)
    {
        return this.data.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;

        if(view == null)
            view = VendorListAdapter.inflater.inflate(R.layout.adapter_vendor_list, null);

        this.initComponents(view);
        this.fillComponents(position);

        return view;
    }

    private void initComponents(View view)
    {
        this.txvVendorUsername = (TextView) view.findViewById(R.id.txv_vendor_username);
        this.txvVendorCategoryDisplayName = (TextView) view.findViewById(R.id.txv_vendor_category_display_name);
        this.txvVendorStatus = (TextView) view.findViewById(R.id.txv_vendor_status);
        this.txvVendorLocationDistance = (TextView) view.findViewById(R.id.txv_vendor_location_distance);
    }

    private void fillComponents(int position)
    {
        Vendor vendor = this.getItem(position);

        this.txvVendorUsername.setText(vendor.getUsername());
        this.txvVendorCategoryDisplayName.setText(vendor.getCategoryDisplayName());
        this.txvVendorStatus.setText(vendor.getStatus());
        this.txvVendorLocationDistance.setText(vendor.getLocationDistance());
    }
}
