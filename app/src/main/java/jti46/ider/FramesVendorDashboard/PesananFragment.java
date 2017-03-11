package jti46.ider.FramesVendorDashboard;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import jti46.ider.R;

public class PesananFragment extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    Context mContext;
    List<PesananModel> mPesananModels;

    public PesananFragment(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_pesanan, container, false);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerviewPesanan);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mPesananModels = new ArrayList<PesananModel>();
        DummyData();
        mAdapter = new PesananAdapter(mPesananModels);
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

    private void DummyData() {
        PesananModel pesananModel = new PesananModel("Arie Rachnmad","Jangan Lama-lama","Rp 50.000");
        mPesananModels.add(pesananModel);

        pesananModel = new PesananModel("Rachnmad","Lontongnya Sisain ya","Rp 10.000");
        mPesananModels.add(pesananModel);

        pesananModel = new PesananModel("Ronaldo","Bakso halusnya jangan sampai lupa","Rp 100.000");
        mPesananModels.add(pesananModel);
    }
}
