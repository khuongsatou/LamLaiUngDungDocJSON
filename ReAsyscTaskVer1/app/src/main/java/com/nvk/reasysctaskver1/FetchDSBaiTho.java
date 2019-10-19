package com.nvk.reasysctaskver1;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FetchDSBaiTho extends AsyncTask<Void, Void , String> {
    private ArrayList<WeakReference<TextView>>  tacGiaListYeu,titleListYeu;

    public FetchDSBaiTho(ArrayList<TextView> tacGiaListYeu, ArrayList<TextView> titleListYeu) {
        this.tacGiaListYeu = new ArrayList<>();
        this.titleListYeu = new ArrayList<>();

        for (int i = 0; i < tacGiaListYeu.size(); i++) {
            this.tacGiaListYeu.add(new WeakReference<>(tacGiaListYeu.get(i)));
            this.titleListYeu.add(new WeakReference<>(titleListYeu.get(i)));
        }
        
    }

    @Override
    protected String doInBackground(Void... voids) {
        return NetWorkUtils.getJSONData("api.php","GET");
    }

    @Override
    protected void onPostExecute(String s) {


        try {
            JSONObject objKhoiTao = new JSONObject(s);
            JSONArray arrTapTho = objKhoiTao.getJSONArray("tap_tho");

            for (int i = 0; i <1 ; i++) {
                JSONObject objItemTapTho = arrTapTho.getJSONObject(i);
                String tieuDe = objItemTapTho.getString("tieu_de");
                String tacgia = objItemTapTho.getString("tac_gia");
                Log.d("AAAAA",tieuDe);
                Log.d("AAAAA",tacgia);

                this.tacGiaListYeu.get(i).get().setText(tieuDe);
                this.titleListYeu.get(i).get().setText(tacgia);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
