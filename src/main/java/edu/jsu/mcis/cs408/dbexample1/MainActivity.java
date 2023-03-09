package edu.jsu.mcis.cs408.dbexample1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import edu.jsu.mcis.cs408.dbexample1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        db = new DatabaseHandler(this, null, null, 1);

        binding.getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllContacts();
            }
        });

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExampleContacts();
            }
        });

        binding.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAllContacts();
            }
        });

    }

    public void getAllContacts() {

        String contacts = db.getAllContacts();
        binding.output.setText(contacts);

    }

    public void addExampleContacts() {

        String result = db.addExampleContacts();
        binding.output.setText(result);

    }

    public void deleteAllContacts() {

        String result = db.deleteAllContacts();
        binding.output.setText(result);

    }

}