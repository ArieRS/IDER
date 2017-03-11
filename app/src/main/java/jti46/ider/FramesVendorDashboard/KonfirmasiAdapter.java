package jti46.ider.FramesVendorDashboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jti46.ider.R;

/**
 * Created by alhamdulillah on 3/12/17.
 */
public class KonfirmasiAdapter extends RecyclerView.Adapter<KonfirmasiAdapter.MyHolder> {
    List<KonfirmasiModel> konfirmasiList =  new ArrayList<KonfirmasiModel>();

    public KonfirmasiAdapter(List<KonfirmasiModel> konfirmasiModels) {
        konfirmasiList = konfirmasiModels;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext().getApplicationContext()).inflate(R.layout.layout_konfirmasi_pesanan,parent,false);
        MyHolder holder = new MyHolder(mView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tvNama.setText(konfirmasiList.get(position).getNama());
        holder.tvAlamat.setText(konfirmasiList.get(position).getAlamat());
        holder.tvTotalHarga.setText(konfirmasiList.get(position).getTotalHarga());
        holder.buttonTerima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.buttonTolak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return konfirmasiList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvAlamat, tvTotalHarga;
        Button buttonTerima, buttonTolak;
        public MyHolder(View itemView) {
            super(itemView);
            tvNama = (TextView) itemView.findViewById(R.id.tvNamaKonfirmasi);
            tvAlamat = (TextView) itemView.findViewById(R.id.tvAlamatKonfirmasi);
            tvTotalHarga = (TextView) itemView.findViewById(R.id.tvTotalHargaKonfirmasi);
            buttonTerima = (Button) itemView.findViewById(R.id.buttonTerimaKonfirmasi);
            buttonTolak = (Button) itemView.findViewById(R.id.buttonTolakKonfirmasi);
        }
    }
}
