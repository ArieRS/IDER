package jti46.ider.RetrofiApi;

import jti46.ider.ModeLogin.Login;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by alhamdulillah on 10/23/16.
 */

public interface ApiInterface {
    @GET("ider_user/login")
    Call<Login> getPembelian();

//    @GET("pembelian/user")
//    Call<GetPembelian> getPembelian();
//
//    @FormUrlEncoded
//    @POST("pembelian/user")
//    Call<PostPutDelPembelian> postPembelian(@Field("id_pembelian") String idPembelian, @Field("id_pembeli") String idPembeli,
//                                            @Field("tanggal_beli") String tanggalBeli, @Field("total_harga") String totalHarga,
//                                            @Field("id_tiket") String idTiket);
//
//    @FormUrlEncoded
//    @PUT("pembelian/user")
//    Call<PostPutDelPembelian> putPembelian(@Field("id_pembelian") String idPembelian, @Field("id_pembeli") String idPembeli,
//                                           @Field("tanggal_beli") String tanggalBeli, @Field("total_harga") String totalHarga,
//                                           @Field("id_tiket") String idTiket);
//
//    @FormUrlEncoded
//    @HTTP(method = "DELETE", path = "pembelian/user", hasBody = true)
//    Call<PostPutDelPembelian> deletePembelian(@Field("id_pembelian") String idPembelian);
}
