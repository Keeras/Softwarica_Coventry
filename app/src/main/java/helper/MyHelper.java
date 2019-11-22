package helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import model.Student;

public class MyHelper extends SQLiteOpenHelper {

    private static final String databaseName = "SoftwaricaDB";
    private static final int dbVersion = 1;
    private static final String tblStudent = "tblStudent";
    public MyHelper(Context context) {
        super(context, databaseName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        String query = "CREATE TABLE " + tblStudent + "(studentID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, age TEXT, address TEXT, gender TEXT  )";
        db.execSQL(query);
    }

    public boolean InsertData(String name, String age, String address, String gender, SQLiteDatabase db){
        try{
            String query = "insert into tblStudent(name, age, address, gender) values('"+name+"','"+age+"','"+address+"','"+gender+"')";
            db.execSQL(query);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public List<Student> GetAllStudent(SQLiteDatabase db){
        List<Student> studentList = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from tblStudent",null);

        if (cursor.getCount() > 0){
            while (cursor.moveToNext()){
                studentList.add(new Student(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(0)));

            }
        }
        return studentList;
    }
    public  void deleteStudent(Student student){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(tblStudent, "studentID" + " =?",
                new String[]{String.valueOf(student.getStd_id())});
    }
}
