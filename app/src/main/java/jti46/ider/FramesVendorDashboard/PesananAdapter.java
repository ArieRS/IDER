package jti46.ider.FramesVendorDashboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jti46.ider.R;

/**
 * Created by alhamdulillah on 3/12/17.
 */
public class PesananAdapter extends RecyclerView.Adapter<PesananAdapter.MyHolder> {
    List<PesananModel> listPesananModel = new ArrayList<PesananModel>();
    public PesananAdapter(List<PesananModel> pesananModels) {
        listPesananModel = pesananModels;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext().getApplicationContext()).inflate(R.layout.layout_pesanan,parent,false);
        MyHolder holder = new MyHolder(mView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
            holder.tvNama.setText(listPesananModel.get(position).getNama());
            holder.tvCatatan.setText(listPesananModel.get(position).getCatatan());
            holder.tvTotalHarga.setText(listPesananModel.get(position).getTotalHarga());
    }

    @Override
    public int getItemCount() {
        return listPesananModel.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvCatatan, tvTotalHarga;
        public MyHolder(View itemView) {
            super(itemView);
            tvNama = (TextView) itemView.findViewById(R.id.tvNamaPelanggan);
            tvCatatan = (TextView) itemView.findViewById(R.id.tvCatatanPelanggan);
            tvTotalHarga = (TextView) itemView.findViewById(R.id.tvTotalHarga);
        }
    }
}
