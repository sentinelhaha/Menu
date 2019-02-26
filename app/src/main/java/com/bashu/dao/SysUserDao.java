package com.bashu.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2019/2/24.
 */

public class SysUserDao {

    public int query(Context context){
        int count =0;
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        String sql="select * from user_info";
        String[] args =null;
        Cursor cursor = sqLiteDatabase.rawQuery(sql,args);
        if(cursor!=null){
            count=cursor.getCount();
        }
        cursor.close();
        databaseHelper.close();
        return count;
    }


    public long insert (Context context,String username){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        String tableName = "user_info";
        long row = sqLiteDatabase.insert(tableName,null,contentValues);
        sqLiteDatabase.close();
        databaseHelper.close();

        return row;
    }

}
