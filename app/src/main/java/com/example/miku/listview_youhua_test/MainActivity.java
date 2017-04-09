package com.example.miku.listview_youhua_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyAdapter adapter;
    private List<Moule> mouleList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_item);
        Button add = (Button) findViewById(R.id.add_item);
        Button del = (Button) findViewById(R.id.del_item);
        add.setOnClickListener(this);
        del.setOnClickListener(this);
        adapter = new MyAdapter(MainActivity.this, R.layout.moule_layout, getMouleList());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Moule moule = mouleList.get(position);
                String ID = moule.getData();
                Toast.makeText(MainActivity.this, ID, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_item:
                Add_Item();
                break;
            case R.id.del_item:
                Del_Item();
                break;
        }
    }

    private void Add_Item() {
        int length = mouleList.size();//获取moulelist的长度。
        Moule moule = new Moule(R.mipmap.ic_launcher, "i = " + length);
        mouleList.add(moule);
        adapter.notifyDataSetChanged();
        listView.setSelection(mouleList.size() - 1);
    }

    private void Del_Item() {
        int size = mouleList.size();
        if (size > 0) {
            mouleList.remove(size - 1);
            adapter.notifyDataSetChanged();
            listView.setSelection(size - 1);
        } else {
            Toast.makeText(MainActivity.this, "不能再删除了", Toast.LENGTH_SHORT).show();
        }
    }

    public List<Moule> getMouleList() {
        mouleList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Moule moule = new Moule(R.mipmap.ic_launcher, "i = " + i);
            mouleList.add(moule);
        }
        return mouleList;
    }
}
