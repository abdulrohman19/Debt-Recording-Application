package com.example.projectfix;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

import static io.realm.Realm.init;

public class RealmHelper {
    private Context context;
    private Realm realm;

    public RealmHelper(Context context){
        this.context = context;
        realm.init(context);
        realm =Realm.getDefaultInstance();
    }
    //insert

    public void insertData(CatatanModel catatan) {
        realm.beginTransaction();
        realm.copyToRealm(catatan);
        realm.commitTransaction();
        realm.addChangeListener(new RealmChangeListener<Realm>() {
            @Override
            public void onChange(Realm realm) {
                Toast.makeText(context, "Data Berhasil di tambahkan", Toast.LENGTH_SHORT).show();
            }
        });
        realm.close();
    }
    //Next id
    public long getNextid(){
        if (realm.where(CatatanModel.class).count() != 0){
            long id = realm.where(CatatanModel.class).max("id").longValue();
            return id +1;
        } else{
            return 1;
        }
    }

    //menampilkan data
    public List<CatatanModel> showData(){
        RealmResults<CatatanModel> datahasil=realm.where(CatatanModel.class).findAll();
        List<CatatanModel> datalist = new ArrayList<>();
        datalist.addAll(realm.copyFromRealm(datahasil));
        realm.commitTransaction();
        return datalist;

    }
}
