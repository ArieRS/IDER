package jti46.ider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import jti46.ider.engine.Commodity;
import jti46.ider.engine.CommodityListAdapter;

public class VendorDetailActivity extends AppCompatActivity
{
    private ListView lstCommodities;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_detail);

        this.initComponents();
    }

    private void initComponents()
    {
        this.lstCommodities = (ListView) this.findViewById(R.id.lst_commodities);

        this.setupListView();
    }

    private void setupListView()
    {
        CommodityListAdapter adapter = new CommodityListAdapter(this, this.commodityList());

        this.lstCommodities.setAdapter(adapter);
    }

    private ArrayList<Commodity> commodityList()
    {
        ArrayList<Commodity> commodities = new ArrayList<>();

        commodities.add(new Commodity(1, "Bakso Campur Lengkap", 15000, 0));
        commodities.add(new Commodity(2, "Pentol Kasar Besar", 5000, 0));
        commodities.add(new Commodity(3, "Goreng Bunder", 500, 0));
        commodities.add(new Commodity(4, "Mie Kuning", 500, 0));
        commodities.add(new Commodity(5, "Siomay", 1000, 0));

        return commodities;
    }
}
