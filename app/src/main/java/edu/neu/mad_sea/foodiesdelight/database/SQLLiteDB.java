package edu.neu.mad_sea.foodiesdelight.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.neu.mad_sea.foodiesdelight.MainActivity;
import edu.neu.mad_sea.foodiesdelight.beans.CartItem;

public class SQLLiteDB extends SQLiteOpenHelper {

    public SQLLiteDB(Context context){
        super(context,DBConstants.DB_NAME, null, DBConstants.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TBL_CART = "CREATE TABLE " + DBConstants.TBL_CART + "("
                + DBConstants.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + DBConstants.KEY_USER_NAME + " TEXT,"
                + DBConstants.KEY_RESTAURANT_NAME + " TEXT,"
                + DBConstants.KEY_DISH_NAME + " TEXT,"
                + DBConstants.KEY_DISH_PRICE + " REAL,"
                + DBConstants.KEY_DISH_QTY + " INTEGER"
                + ")";
        db.execSQL(CREATE_TBL_CART);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + DBConstants.TBL_CART);
        // Create tables again
        onCreate(db);
    }

    public void addItemTocart(CartItem cartItem){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cartEntities = new ContentValues();
        cartEntities.put(DBConstants.KEY_DISH_NAME, cartItem.getDishName());
        cartEntities.put(DBConstants.KEY_DISH_PRICE, cartItem.getDishPrice());
        cartEntities.put(DBConstants.KEY_DISH_QTY, cartItem.getDishQty());
        cartEntities.put(DBConstants.KEY_RESTAURANT_NAME, MainActivity.getSelectedRestaurant().getRestTitle());
        cartEntities.put(DBConstants.KEY_USER_NAME, MainActivity.getUser().getUserName());
        db.insert(DBConstants.TBL_CART,null, cartEntities);
    }

    public List<CartItem> getAllItemsFromCart(String resturantName, String userId ){
        SQLiteDatabase db = this.getWritableDatabase();
        List<CartItem> cart = new ArrayList<>();
        String query = "SELECT * FROM "+ DBConstants.TBL_CART;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            CartItem ci = new CartItem();
            ci.setDishName(cursor.getString(cursor.getColumnIndex(DBConstants.KEY_DISH_NAME)));
            ci.setDishPrice(cursor.getFloat(cursor.getColumnIndex(DBConstants.KEY_DISH_PRICE)));
            ci.setDishQty(cursor.getInt(cursor.getColumnIndex(DBConstants.KEY_DISH_QTY)));
            cart.add(ci);
        }

        cursor.close();
        return  cart;
    }

    public int updateItemInCart(CartItem ci){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cartVals = new ContentValues();
        cartVals.put(DBConstants.KEY_DISH_QTY, ci.getDishQty());
        int count = db.update(DBConstants.TBL_CART,cartVals, DBConstants.KEY_RESTAURANT_NAME+" = ? AND "+DBConstants.KEY_DISH_NAME + " =? "+ DBConstants.KEY_USER_NAME + "=? ",new String[]{MainActivity.getSelectedRestaurant().getRestTitle(),ci.getDishName(),MainActivity.getUser().getUserName()});
        return  count;
    }

    SQLiteDatabase db = this.getWritableDatabase();

    public void removeItemInCart(CartItem ci){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DBConstants.TBL_CART, DBConstants.KEY_RESTAURANT_NAME+" = ? AND "+DBConstants.KEY_DISH_NAME + " =? "+ DBConstants.KEY_USER_NAME + "=? ",new String[]{MainActivity.getSelectedRestaurant().getRestTitle(),ci.getDishName(),MainActivity.getUser().getUserName()});

    }

    public void clearCart(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DBConstants.TBL_CART, null, null);//DBConstants.KEY_RESTAURANT_NAME+" = ? AND "+ DBConstants.KEY_USER_NAME + "=? ",new String[]{MainActivity.getSelectedRestaurant().getRestTitle(),MainActivity.getUser().getUserName()});

    }


}
