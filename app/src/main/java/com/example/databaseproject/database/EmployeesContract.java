package com.example.databaseproject.database;

import android.provider.BaseColumns;

public final class EmployeesContract {
    public EmployeesContract() {
    }

    public static final class EmployeesEntry implements BaseColumns {
        public static final String TABLE_NAME = "Employees";
        public static final String EMPLOYEE_ID = BaseColumns._ID;
        public static final String EMPLOYEE_NAME = "name";
        public static final String EMPLOYEE_SALARY = "salary";
    }
}
