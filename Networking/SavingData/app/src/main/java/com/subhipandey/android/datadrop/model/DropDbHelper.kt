package com.subhipandey.android.datadrop.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.subhipandey.android.datadrop.model.DropDbSchema.DropTable

class DropDbHelper (context: Context)
    : SQLiteOpenHelper(context, DropDbSchema.DB_NAME, null, DropDbSchema.VERSION){
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table " + DropTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                DropTable.Columns.ID + " text, " +
                DropTable.Columns.LATITUDE + " real, " +
                DropTable.Columns.LONGITUDE + " real, " +
                DropTable.Columns.DROP_MESSAGE + " text, " +
                DropTable.Columns.MARKER_COLOR + "integer" + ");"

        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if(oldVersion < 2) {
            db.execSQL("alter table" +
            DropTable.NAME + "add column" +
                    DropTable.Columns.MARKER_COLOR+ "integer;"
            )
        }
    }

}

