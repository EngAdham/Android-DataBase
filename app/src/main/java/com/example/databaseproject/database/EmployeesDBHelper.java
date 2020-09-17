package com.example.databaseproject.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.databaseproject.database.EmployeesContract.EmployeesEntry;

import androidx.annotation.Nullable;

public class EmployeesDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "fci.db";
    private static final int DATABASE_VERSION = 1;
    public static final String SQL_CREATE_EMPLOYEES_TABLE =
            "CREATE TABLE " + EmployeesEntry.TABLE_NAME + " (" +
                    EmployeesEntry.EMPLOYEE_ID + " INTEGER PRIMARY KEY , " +
                    EmployeesEntry.EMPLOYEE_NAME + " TEXT NOT NULL, " +
                    EmployeesEntry.EMPLOYEE_SALARY + " INTEGER NOT NULL DEFAULT 0 " + ");";

    public EmployeesDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_EMPLOYEES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
