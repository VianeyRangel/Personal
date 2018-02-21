package com.utng.vgutierrez.personal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Person[] persons = {
            new Person(R.drawable.jefe, "Mario Patiño", "Jefe", "Lic. Turismo"),
            new Person(R.drawable.guia, "Luis Quevedo", "Gerente", "Lic. Turismo"),
            new Person(R.drawable.ayudante, "Carla Maldonado", "Trabajador", "Estudiante"),
            new Person(R.drawable.guiamujer, "Itzhel Vázquez", "Guía Turista", "Lic. Turismo"),

    };
    private ListView lsvPerson;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lsvPerson = (ListView) findViewById(R.id.lsv_person);
        PersonAdapter adapter = new PersonAdapter(
                this, persons);
        lsvPerson.setAdapter(adapter);

        lsvPerson.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedOption = ((Person) parent.getItemAtPosition(position)).getName();

        //String.selectedOption = ((TextView)view.findViewById(R.id.txv_name)).getText().toString();
        Toast.makeText(this, "You Selected: " + selectedOption, Toast.LENGTH_SHORT).show();
    }

    static class ViewHolder {
        TextView txvName;
        TextView txvStation;
        TextView txvScholarship;
        ImageView imvPhoto;
    }

    class PersonAdapter extends ArrayAdapter<Person> {
        public PersonAdapter(@NonNull Context context, Person[] data) {
            super(context, R.layout.activity_person, data);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View cell = convertView;
            ViewHolder holder;
            if (cell == null) {
                LayoutInflater inflater =
                        LayoutInflater.from(getContext());
                cell = inflater.inflate(R.layout.activity_person, null);

                holder = new ViewHolder();
                holder.imvPhoto = (ImageView) cell.findViewById(R.id.imv_photo);
                holder.txvName = (TextView) cell.findViewById(R.id.txv_name);
                holder.txvStation = (TextView) cell.findViewById(R.id.txv_station);
                holder.txvScholarship = (TextView) cell.findViewById(R.id.txv_scholarship);

                cell.setTag(holder);
            } else {
                holder = (ViewHolder) cell.getTag();
            }
            holder.imvPhoto.setImageResource(persons[position].getImageId());
            holder.txvName.setText(persons[position].getName());
            holder.txvStation.setText(persons[position].getStation());
            holder.txvScholarship.setText(persons[position].getScholarship());
            return cell;
        }
    }
}
