package com.example.projet_zili;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DBNAME = "inscription.db";
    public static final String Table_name = "etudiant";
    public static final String Table_name2 = "filiere";
    public static final String Table_name3 = "module";

    public static final String Column_id_filiere = "_idFiliere";
    public static final String Column_intitule = "intitule";

    public static final String Column_id_module = "_idModule";
    public static final String Column_nom_module = "nom module";

    public static final String Column_id = "_id";
    public static final String Column_cne = "cne";
    public static final String Column_nom = "nom";
    public static final String Column_prenom = "prenom";
    public static final String Column_idd1 = "_idd1";


    MyDatabaseHelper(Context context) {
        super(context, DBNAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        String query = "CREATE TABLE "+ Table_name +
                        " (" + Column_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        Column_cne + " TEXT, " +
                        Column_nom + " TEXT, " +
                        Column_idd1 + " INTEGER, "+
                        Column_prenom + " TEXT, " + " FOREIGN KEY ("+Column_idd1+") REFERENCES "+Table_name2+"("+Column_id_filiere+"));";
        MyDB.execSQL(query);

        String myquery = "CREATE TABLE "+ Table_name2 +
                " (" + Column_id_filiere + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Column_intitule + " TEXT) ;";


       MyDB.execSQL(myquery);

        //String query2 = "CREATE TABLE "+ Table_name3 +
                //" (" + Column_id_module + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                //Column_nom_module + " TEXT) ;";
        //MyDB.execSQL(query2);
        //MyDB.execSQL("CREATE TABLE filiere (_idFiliere INTEGER NOT NULL PRIMARY KEY autoIncrement,intitule TEXT NOT NULL);");


        //MyDB.execSQL("INSERT INTO Filiere(intitule) VALUES('MBD'),('SIM'),('LSI');");



    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(MyDB);

        MyDB.execSQL("DROP TABLE IF EXISTS " + Table_name2);
        onCreate(MyDB);
    }

    void ajouteretudiant( String cne, String nom , String prenom, int idFiliere){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Column_cne, cne);
        contentValues.put(Column_nom, nom);
        contentValues.put(Column_prenom, prenom);
        contentValues.put(Column_idd1, idFiliere);
        long resultat = MyDB.insert(Table_name, null, contentValues);

        if(resultat==-1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + Table_name;
        String myquery = "SELECT * FROM " + Table_name2;
        SQLiteDatabase MyDB = this.getReadableDatabase();

        Cursor cursor = null;
        Cursor cursor1 = null;
        if(MyDB != null){
            cursor = MyDB.rawQuery(query, null);
        }
        return cursor;

    }

    Cursor readAllDataa(){
        String myquery = "SELECT * FROM " + Table_name2;
        SQLiteDatabase MyDB = this.getReadableDatabase();

        Cursor cursor1 = null;
        if(MyDB != null){
            cursor1 = MyDB.rawQuery(myquery, null);
        }
        return cursor1;

    }

    void updatedata(String row_id, String cne, String nom, String prenom){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Column_cne, cne);
        cv.put(Column_nom, nom);
        cv.put(Column_prenom, prenom);

        long result = MyDB.update(Table_name, cv, "_id=?", new String[]{row_id});
        if (result == -1){
            Toast.makeText(context, "Failed to Update!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Updated!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        long result = MyDB.delete(Table_name, "_id=?", new String[]{row_id});
        if (result == -1){
            Toast.makeText(context, "Failed to Delete!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("DELETE FROM " + Table_name);
        MyDB.execSQL("DELETE FROM " + Table_name2);
    }


    public SimpleCursorAdapter populateListViewFromDB(){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String columns[] = {MyDatabaseHelper.Column_id, MyDatabaseHelper.Column_cne, MyDatabaseHelper.Column_nom, MyDatabaseHelper.Column_prenom};
        Cursor cursor = MyDB.query(MyDatabaseHelper.Table_name, columns,null, null,null, null, null, null);
        String[] fromFieldNames = new String[]{
                MyDatabaseHelper.Column_id, MyDatabaseHelper.Column_cne, MyDatabaseHelper.Column_nom, MyDatabaseHelper.Column_prenom
        };
        int[] toViewIDs = new int[]{R.id.item_id, R.id.item_cne, R.id.item_nom, R.id.item_prenom};
        SimpleCursorAdapter etudiantAdapter = new SimpleCursorAdapter(
                context,
                R.layout.single_item,
                cursor,
                fromFieldNames,
                toViewIDs
        );
        return etudiantAdapter;
    }

}
