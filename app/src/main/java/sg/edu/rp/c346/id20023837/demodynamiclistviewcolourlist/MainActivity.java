package sg.edu.rp.c346.id20023837.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    Button btnClear;
    Button btnUpdate;
    ListView lvColour;

    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnClear = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etIndexElement.getText().toString().isEmpty()) {

                } else {
                    String colour = etElement.getText().toString();
//                alColours.add(newColour);
                    int pos = Integer.parseInt(etIndexElement.getText().toString());
                    alColours.add(pos, colour);
                    aaColour.notifyDataSetChanged();
                    etElement.setText(null);
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etIndexElement.getText().toString().isEmpty()) {

                }
                else {
                    int pos = Integer.parseInt(etIndexElement.getText().toString());
                    String toRemove = aaColour.getItem(pos);
                    aaColour.remove(toRemove);
                    aaColour.notifyDataSetChanged();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etIndexElement.getText().toString().isEmpty()) {

                } else {
                    String replaceColour = etElement.getText().toString();
                    int pos = Integer.parseInt(etIndexElement.getText().toString());
                    alColours.set(pos, replaceColour);
                    aaColour.notifyDataSetChanged();
                }
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String colour = alColours.get(position);
                Toast toast = Toast. makeText(MainActivity.this, colour, Toast. LENGTH_SHORT);
                toast.show();
            }
        });
    }
}