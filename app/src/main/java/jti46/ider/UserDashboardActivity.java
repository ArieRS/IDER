package jti46.ider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

import jti46.ider.engine.Vendor;
import jti46.ider.engine.VendorListAdapter;

public class UserDashboardActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener, VendorListAdapter.VendorListAdapterActionListener
{

    private static final String TAB_LIST_TITLE = "DAFTAR";
    private static final String TAB_LOCATION_TITLE = "LOKASI";

    private TabHost tbhMain;
    private LinearLayout lnrTabList;
    private LinearLayout lnrTabLocation;
    private Spinner spnrCategories;
    private ListView lstVendors;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        this.initComponents();
    }

    private void initComponents()
    {
        this.tbhMain = (TabHost) this.findViewById(R.id.tbh_main);
        this.lnrTabList = (LinearLayout) this.findViewById(R.id.lnr_tab_list);
        this.lnrTabLocation = (LinearLayout) this.findViewById(R.id.lnr_tab_location);
        this.spnrCategories = (Spinner) this.findViewById(R.id.spnr_categories);
        this.lstVendors = (ListView) this.findViewById(R.id.lst_vendors);

        this.setupListView();
        this.setupSpinner();
        this.setupTabs();
    }

    private void setupListView()
    {
        VendorListAdapter adapter = new VendorListAdapter(this, this.vendorList());

        this.lstVendors.setAdapter(adapter);

        this.lstVendors.setOnItemClickListener(this);
    }

    private void setupSpinner()
    {
        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, this.categoryList());

        this.spnrCategories.setAdapter(categoriesAdapter);
    }

    private void setupTabs()
    {
        this.tbhMain.setup();

        TabHost.TabSpec listSpec = this.tbhMain.newTabSpec(UserDashboardActivity.TAB_LIST_TITLE);
        listSpec.setContent(R.id.lnr_tab_list);
        listSpec.setIndicator(UserDashboardActivity.TAB_LIST_TITLE);

        TabHost.TabSpec locationSpec = this.tbhMain.newTabSpec(UserDashboardActivity.TAB_LOCATION_TITLE);
        locationSpec.setContent(R.id.lnr_tab_location);
        locationSpec.setIndicator(UserDashboardActivity.TAB_LOCATION_TITLE);

        this.tbhMain.addTab(listSpec);
        this.tbhMain.addTab(locationSpec);
    }

    private ArrayList<String> categoryList()
    {
        ArrayList<String> categories = new ArrayList<>();

        categories.add("Semua");
        categories.add("Bakso");
        categories.add("Sate");
        categories.add("Siomay");
        categories.add("Tahu Tek");
        categories.add("Nasi Goreng");
        categories.add("Tahu Telor");

        return categories;
    }

    private ArrayList<Vendor> vendorList()
    {
        ArrayList<Vendor> vendors = new ArrayList<>();

        vendors.add(new Vendor(1, "cakkhoir87", "Bakso", "Cakman Khoiri", "Bakso enak murah mantap nikmat", "Jl. Tombro", 600));
        vendors.add(new Vendor(2, "siomaymantap", "Siomay", "Cak Mantap", "Ayo siomaynya...", "Jl. Mujair", 233));
        vendors.add(new Vendor(3, "sateoke99", "Sate", "Cak Mandra", "Monggo satenipun diskon 50%", "Jl. Tombro", 800));

        return vendors;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void OnPengenButtonClicked(Vendor selectedVendor)
    {
        Intent i = new Intent(this, MapsActivity.class);

        this.startActivity(i);
    }

    @Override
    public void OnPesenButtonClicked(Vendor selectedVendor)
    {
        Intent i = new Intent(this, VendorDetailActivity.class);

        this.startActivity(i);
    }
}
