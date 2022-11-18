package bobbb2912.com.spllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;


public class DatabaseHelper extends SQLiteOpenHelper {
    //database version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "svManager";

    //Table Names
    private static final String TABLE_SINHVIEN = "sinhvien";

    //Column Names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_CREATE_AT = "create_at";

    //
    private static final String CREATE_TABLE_SINHVIEN =
            "CREATE TABLE" +  TABLE_SINHVIEN + "("
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                    + KEY_NAME + " VARCHAR, "
                    + KEY_PHONE + " VARCHAR, "
                    + KEY_EMAIL + " VARCHAR, "
                    + KEY_CREATE_AT + " DATETIME" + ")";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_SINHVIEN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '"+  CREATE_TABLE_SINHVIEN + "'");

    }

    public void CreateSinhVien(SinhVien sv) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, sv.getSvid());
        values.put(KEY_NAME, sv.getSvname());
        values.put(KEY_PHONE, sv.getSvphone());
        values.put(KEY_EMAIL, sv.getSvemail());
        values.put(KEY_CREATE_AT, getDateTime());

        db.insert(TABLE_SINHVIEN, null, values);
    }

    public String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd-MM-yyy HH:mm:ss", Locale.getDefault()
        );
        Date date = new Date();
        return dateFormat.format(date);
    }
}
