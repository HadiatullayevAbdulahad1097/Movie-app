package developer.abdulahad.homework221.Models

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import developer.abdulahad.homework221.Utils.Constant.ABOUT
import developer.abdulahad.homework221.Utils.Constant.AUTHORS
import developer.abdulahad.homework221.Utils.Constant.DATE
import developer.abdulahad.homework221.Utils.Constant.DB_NAME
import developer.abdulahad.homework221.Utils.Constant.DB_VERSION
import developer.abdulahad.homework221.Utils.Constant.ID
import developer.abdulahad.homework221.Utils.Constant.NAME
import developer.abdulahad.homework221.Utils.Constant.TABLE_NAME

class MyDbHelper(context: Context) : SQLiteOpenHelper(context,DB_NAME,null, DB_VERSION) ,
    DbServiceInterface {
    override fun onCreate(db: SQLiteDatabase?) {
        var query = "CREATE TABLE $TABLE_NAME ($ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, $NAME TEXT NOT NULL, $AUTHORS TEXT NOT NULL, $ABOUT TEXT NOT NULL, $DATE TEXT NOT NULL)"

        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    override fun addUser(user: User) {
        var database = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(NAME, user.name)
        contentValues.put(AUTHORS, user.authors)
        contentValues.put(ABOUT, user.about)
        contentValues.put(DATE, user.date)

        database.insert(TABLE_NAME,null,contentValues)
        database.close()
    }

    override fun getUsers(): ArrayList<User> {
        val list = ArrayList<User>()

        val query = "select * from $TABLE_NAME"
        val dataBase = this.readableDatabase

        val cursor = dataBase.rawQuery(query, null)

        if (cursor.moveToFirst()){
            do {
                val user = User(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                )

                list.add(user)

            }while (cursor.moveToNext())
        }
        return list
    }

    override fun upDateUser(user: User): Int {
        var database = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(ID,user.id)
        contentValues.put(NAME,user.name)
        contentValues.put(AUTHORS,user.authors)
        contentValues.put(ABOUT,user.about)
        contentValues.put(DATE,user.date)

        return database.update(TABLE_NAME,contentValues,"$ID = ?", arrayOf(user.id.toString()))
    }

    override fun delete(user: User) {
        val database = this.writableDatabase
        database.delete(TABLE_NAME, "$ID = ?", arrayOf("${user.id}"))
        database.close()
    }
}