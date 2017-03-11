package jti46.ider.engine;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import jti46.ider.R;

/**
 * Created by yunhasnawa on 11/03/17.
 */

public class VendorListAdapter extends BaseAdapter implements View.OnClickListener
{

    public interface VendorListAdapterActionListener
    {
        void OnPengenButtonClicked(Vendor selectedVendor);
        void OnPesenButtonClicked(Vendor selectedVendor);
    }

    private static LayoutInflater inflater;

    private VendorListAdapterActionListener actionListener;
    private AppCompatActivity hostActivity;
    private Context context;
    private ArrayList<Vendor> data;

    private TextView txvVendorUsername;
    private TextView txvVendorCategoryDisplayName;
    private TextView txvVendorStatus;
    private TextView txvVendorLocationDistance;
    private Button btnPengen;
    private Button btnPesen;

    public VendorListAdapter(AppCompatActivity hostActivity, ArrayList<Vendor> data)
    {
        this.hostActivity = hostActivity;
        this.data = data;

        if(this.hostActivity instanceof VendorListAdapterActionListener)
            this.actionListener = (VendorListAdapterActionListener) this.hostActivity;

        this.context = this.hostActivity.getApplicationContext();

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
        {
            view = VendorListAdapter.inflater.inflate(R.layout.adapter_vendor_list, null);
        }

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
        this.btnPengen = (Button) view.findViewById(R.id.btn_pengen);
        this.btnPesen = (Button) view.findViewById(R.id.btn_pesen);

        this.btnPengen.setOnClickListener(this);
        this.btnPesen.setOnClickListener(this);
    }

    private void fillComponents(int position)
    {
        Vendor vendor = this.getItem(position);

        this.txvVendorUsername.setText(vendor.getUsername());
        this.txvVendorCategoryDisplayName.setText(vendor.getCategoryDisplayName());
        this.txvVendorStatus.setText(vendor.getStatus());
        this.txvVendorLocationDistance.setText(vendor.getLocationDistance());

        String viewTag = String.valueOf(position);

        this.btnPengen.setTag(viewTag);
        this.btnPesen.setTag(viewTag);
    }

    @Override
    public void onClick(View v)
    {
        int currentPosition = Integer.parseInt((String)v.getTag());

        //Toast.makeText(this.context, "Position: " + currentPosition, Toast.LENGTH_SHORT).show();

        Button b = (Button) v;

        //Log.d("Tes", "B: " + b.toString());
        //Log.d("Tes", "btnPengen: " + this.btnPengen.toString());

        if(b.getText().equals(this.btnPengen.getText()))
        {
            this.actionListener.OnPengenButtonClicked(this.getItem(currentPosition));
        }
        else
        {
            this.actionListener.OnPesenButtonClicked(this.getItem(currentPosition));
        }
    }
}
