package jti46.ider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TabHost;

public class UserDashboardActivity extends AppCompatActivity
{

    private static final String TAB_LIST_TITLE = "DAFTAR";
    private static final String TAB_LOCATION_TITLE = "LOKASI";

    private TabHost tbhMain;
    private LinearLayout lnrTabList;
    private LinearLayout lnrTabLocation;

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

        this.setupTabs();
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
}
