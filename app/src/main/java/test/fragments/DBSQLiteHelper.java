package test.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

import test.practice.student;

/**
 * Created by obaro on 26/09/2016.
 */

// This sets up the database,columns, and tables, also known as the DBHandler
public class DBSQLiteHelper extends SQLiteOpenHelper {

    // All static variables
    // Database Version
    private static final int DATABASE_VERSION = 2;

    //Database Name
    private static final String DATABASE_NAME = "student";

    //Contacts table name
    private static final String TABLE_STUDENT_DETAIL = "studentDetails";

    //Contacts Table Columns names
    private static final String KEY_ID="id";
    private static final String KEY_ENROLL_NO="enroll_no";
    private static final String KEY_NAME="name";
    private static final String KEY_PHONE_NO="phone_number";

    public DBSQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    //creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENT_DETAIL_TABLE = "CREATE TABLE IF NOT EXISTS  " + TABLE_STUDENT_DETAIL +
                "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_ENROLL_NO + " TEXT,"
                + KEY_NAME + " TEXT unique,"
                + KEY_PHONE_NO + " TEXT " + ")";

        db.execSQL(CREATE_STUDENT_DETAIL_TABLE);


    }

    //drops the database then recreates it using onCreate()
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT_DETAIL);

        //creates tables abgain
        onCreate(db);
    }

    public String getTables() {


        SQLiteDatabase database = this.getWritableDatabase();
        Cursor c = database.rawQuery(
                "SELECT name FROM TABLE_STUDENT_DETAIL WHERE type='table'", null);
        Assert.assertNotNull(c);

        String actual = "";
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                actual += c.getString(0) + ",";
                c.moveToNext();
            }
        }

        c.close();
        return actual;

    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_STUDENT_DETAIL,null);
        return res;
    }

    public void addNewStudent(student newStud) {

        SQLiteDatabase db = this.getWritableDatabase();



        //ContentValues is used to put in raw data into database, think of it as a way to
        // transition from different planes of systems.
        ContentValues values = new ContentValues();

        values.put(KEY_ENROLL_NO, newStud.get_enroll_no());
        values.put(KEY_NAME, newStud.get_name());
        values.put(KEY_PHONE_NO, newStud.get_phone_number());


        Log.i("In student/table maker", String.valueOf(newStud.get_name()));

        // Inserting Row
        db.insert(TABLE_STUDENT_DETAIL, null, values);
        db.close(); // Closing database connection
    }

    public void deleteStudentByEnrolNo(int s)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        int enrolNo=s;

        values.put(KEY_ENROLL_NO, enrolNo);



        db.execSQL("DELETE FROM " + TABLE_STUDENT_DETAIL + " WHERE enroll_no ="+ enrolNo);

    }

    public void deleteAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_STUDENT_DETAIL);

    }

    public List<student> getAllStudentList() {


        List<student> studentList = new ArrayList<student>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_STUDENT_DETAIL;

        SQLiteDatabase db = this.getWritableDatabase();

        //Cursor Temporarily stores data from the database into the buffer so that in can lateer
        // be put into database by the ContentValues() class.
        Cursor cursor = db.rawQuery(selectQuery, null);



        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                student stdnt = new student();
                stdnt.set_id(Integer.parseInt(cursor.getString(0)));
                stdnt.set_enroll_no(Integer.parseInt(cursor.getString(1)));
                stdnt.set_name(cursor.getString(2));
                stdnt.set_phone_number(cursor.getString(3));

                // Adding contact to list
                studentList.add(stdnt);

            } while (cursor.moveToNext());
        }
        if(studentList==null){
            studentList.add(null);
        }

        // return contact list
        return studentList;
    }

}
