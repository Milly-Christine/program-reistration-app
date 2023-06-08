import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText idEditText;
    private EditText emailEditText;
    private Button registerButton;
    private TextView headingTextView;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        nameEditText = findViewById(R.id.nameEditText);
        idEditText = findViewById(R.id.idEditText);
        emailEditText = findViewById(R.id.emailEditText);
        registerButton = findViewById(R.id.registerButton);
        headingTextView = findViewById(R.id.headingTextView);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        // Set the program heading
        String programHeading = "Welcome to the Program!";
        headingTextView.setText(programHeading);
    }

    private void register() {
        String name = nameEditText.getText().toString().trim();
        String id = idEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();

        // Save data to database
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.RegistrationEntry.COLUMN_NAME, name);
        values.put(DatabaseContract.RegistrationEntry.COLUMN_ID, id);
        values.put(DatabaseContract.RegistrationEntry.COLUMN_EMAIL, email);
        db.insert(DatabaseContract.RegistrationEntry.TABLE_NAME, null, values);

        // Clear input fields
        nameEditText.setText("");
        idEditText.setText("");
        emailEditText.setText("");
    }
}
