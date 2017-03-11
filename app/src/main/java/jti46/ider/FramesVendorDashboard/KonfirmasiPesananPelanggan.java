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

public class KonfirmasiPesananPelanggan extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    Context mContext;
    List<KonfirmasiModel> mKonfirmasiModels;

    public KonfirmasiPesananPelanggan(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_konfirmasi_pesanan_pelangga, container, false);

        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recyclerviewKonfirmasiPelanggan);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mKonfirmasiModels = new ArrayList<KonfirmasiModel>();
        DummyData();
        mAdapter = new KonfirmasiAdapter(mKonfirmasiModels);
        mRecyclerView.setAdapter(mAdapter);
        return mView;
    }

    private void DummyData() {
        KonfirmasiModel konfirmasiModel = new KonfirmasiModel("Arie Rachnmad", "Jangan Lama-lama", "Rp 50.000");
        mKonfirmasiModels.add(konfirmasiModel);

        konfirmasiModel = new KonfirmasiModel("Rachnmad", "Lontongnya Sisain ya", "Rp 10.000");
        mKonfirmasiModels.add(konfirmasiModel);

        konfirmasiModel = new KonfirmasiModel("Ronaldo", "Bakso halusnya jangan sampai lupa", "Rp 100.000");
        mKonfirmasiModels.add(konfirmasiModel);
    }
}
