package com.example.databaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.databaseproject.database.EmployeesContract.EmployeesEntry;
import com.example.databaseproject.database.EmployeesDBHelper;

public class MainActivity extends AppCompatActivity {
    EditText id, name, salary;
    Button ok;
    TextView showData;
    EmployeesDBHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.editTextNumber2);
        name = (EditText) findViewById(R.id.editTextTextPersonName);
        salary = (EditText) findViewById(R.id.editTextNumber);
        ok = (Button) findViewById(R.id.button);
        showData = (TextView) findViewById(R.id.textView);

        mHelper = new EmployeesDBHelper(this);

        getData();

    }

    public void ok(View view) {

        setData();

        getData();

        id.getText().clear();
        name.getText().clear();
        salary.getText().clear();
    }

    public void setData() {
        int empID = Integer.parseInt(id.getText().toString());
        String empName = name.getText().toString().trim();
        int empSalary = Integer.parseInt(salary.getText().toString());

        ContentValues values = new ContentValues();
        values.put(EmployeesEntry.EMPLOYEE_ID, empID);
        values.put(EmployeesEntry.EMPLOYEE_NAME, empName);
        values.put(EmployeesEntry.EMPLOYEE_SALARY, empSalary);

        SQLiteDatabase db = mHelper.getWritableDatabase();

        db.insert(EmployeesEntry.TABLE_NAME, null, values);
    }

    public void getData() {
        SQLiteDatabase db = mHelper.getReadableDatabase();

        String[] selectedColumns = {EmployeesEntry.EMPLOYEE_ID,
                EmployeesEntry.EMPLOYEE_NAME,
                EmployeesEntry.EMPLOYEE_SALARY};

        Cursor cursor = db.query(EmployeesEntry.TABLE_NAME, selectedColumns, null, null, null, null, null);
        int idColumnIndex = cursor.getColumnIndex(EmployeesEntry.EMPLOYEE_ID);
        int nameColumnIndex = cursor.getColumnIndex(EmployeesEntry.EMPLOYEE_NAME);
        int salaryColumnIndex = cursor.getColumnIndex(EmployeesEntry.EMPLOYEE_SALARY);

        showData.setText("");

        while (cursor.moveToNext()) {
            int empID = cursor.getInt(idColumnIndex);
            String empName = cursor.getString(nameColumnIndex);
            int empSalary = cursor.getInt(salaryColumnIndex);

            showData.append(empID + "\t" + empName + "\t" + empSalary + "\n");
        }
    }
}