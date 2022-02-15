package com.example.projet_zili;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";
    public static final String id_fil = "id_fil";
    public static final String id_etu = "id_etu";
    public static final String CNE = "CNE";

    public DBHelper( Context context) {

        super(context, "Login.db", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        //MyDB.execSQL("create table etudiant(_id INTEGER primary key autoincrement, cne TEXT, nom TEXT, prenom TEXT)");
        MyDB.execSQL("CREATE TABLE Filiere (id_fil INTEGER NOT NULL PRIMARY KEY autoIncrement,intitule TEXT NOT NULL);");


        MyDB.execSQL("INSERT INTO Filiere(intitule) VALUES('MBD'),('SIM'),('LSI');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        //MyDB.execSQL("drop Table if exists etudiant");
        //onCreate(MyDB);
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }




    public int getIdFiliere(String nom) throws SQLException {
        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor getNoteId = myDB.rawQuery("select id_fil from Filiere where intitule = '" + nom + "'", null);
        if (getNoteId != null && getNoteId.moveToFirst()) {
            Log.i("id", String.valueOf(getNoteId.getInt(0)));
            return getNoteId.getInt(0);
        } else {
            return -1;  // because you have to return something
        }
    }




}
