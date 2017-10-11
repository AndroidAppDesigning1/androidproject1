package com.example.t00572029.fragmentsassignment;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by T00572029 on 10/6/2017.
 */

public class CityList extends Fragment implements AdapterView.OnItemClickListener {

    String[] cityList;
    ListView listView;
    protected static final String PUT_EXTRA_KEY = "city";



        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            // arrayAdapter.addAll(cityList);

            cityList = getResources().getStringArray(R.array.cities);



            View view = inflater.inflate(R.layout.citylistframent, container, false);
           // TextView t1 = view.findViewById(R.id.listviewprops);
            ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter  <CharSequence>(getActivity(), R.layout.textviewprops, cityList);

            listView = (ListView) view.findViewById(R.id.cityList);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(this);


        return view;
    }



    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) view;

        String city = textView.getText().toString();
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.putExtra(PUT_EXTRA_KEY, city);

        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}
