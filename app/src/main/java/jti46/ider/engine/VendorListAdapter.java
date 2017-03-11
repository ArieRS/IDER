package jti46.ider.engine;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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

    }

    private void fillComponents(int position)
    {

    }
}
