package com.app.arunaj.marketplace_dankotuwa.models.db;

import com.app.arunaj.marketplace_dankotuwa.models.BaseModel;
import com.orm.SugarRecord;
import com.orm.util.NamingHelper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by arunaj on 12/15/17.
 */

public class SugarModel extends BaseModel {
    public SugarModel() {}

    public Long save() {
        return SugarRecord.save(this);
    }

    public boolean delete() {
        return SugarRecord.delete(this);
    }

    public static int deleteAll(Class<?> classToDelete) {
        try {
            return SugarRecord.deleteAll(classToDelete);
        }catch (Exception ignored) {

        }
        return 0;
    }

    public static <T> T first(Class<T> type) {
        return SugarRecord.first(type);
    }

    public static <T> T last(Class<T> type) {
        return SugarRecord.last(type);
    }

    public static <T> int deleteAll(Class<T> type, String whereClause, String... whereArgs) {
        return SugarRecord.deleteAll(type, whereClause, whereArgs);
    }

    public static <T> Iterator<T> findAll(Class<T> type) {
        return SugarRecord.findAll(type);
    }

    public static <T> long count(Class<T> type) {
        return SugarRecord.count(type);
    }

    public static <T> long count(Class<T> type, String whereClause, String[] whereArgs) {
        return SugarRecord.count(type, whereClause, whereArgs, null, null, null);
    }

    public static <T> List<T> find(Class<T> type, String whereClause, String... whereArgs) {
        return SugarRecord.find(type, whereClause, whereArgs);
    }

    public static <T> List<T> find(Class<T> type, String whereClause, String[] whereArgs, String groupBy, String orderBy, String limit) {
        return SugarRecord.find(type, whereClause, whereArgs, groupBy, orderBy, limit);
    }

    public static <T> T findById(Class<T> type, Long id) {
        return SugarRecord.findById(type, id);
    }

    public static <T> void saveInTx(Collection<T> objects) {
        SugarRecord.saveInTx(objects);
    }

    public static <T> List<T> listAll(Class<T> type) {
        return SugarRecord.listAll(type);
    }

    public static <T> List<T> listAll(Class<T> type, String orderBy) {
        return SugarRecord.listAll(type, orderBy);
    }


    public static <T> T first(Class<T>type, String colOrderBy) {
        return getQuery(type,colOrderBy,"ASC");
    }

    public static <T> T last(Class<T>type, String colOrderBy) {
        return getQuery(type,colOrderBy,"DESC");
    }

    private static <T> T getQuery(Class<T>type, String colOrderBy,String order) {
        List<T> list = SugarRecord.findWithQuery(type,
                "SELECT * FROM " + NamingHelper.toSQLName(type) + " ORDER BY "+ colOrderBy +" "+ order+ " "+ "LIMIT 1");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> List<T> findWithQuery(Class<T> type, String query, String... arguments) {
        return SugarRecord.findWithQuery(type, query, arguments);
    }

    public static <T>  T first(Class<T> type, String whereClause,String... whereArg) {
        List<T> items = find(type, whereClause, whereArg);
        if (items != null && items.size() > 0) {
            return items.get(0);
        }
        return null;
    }

    public static void executeQuery(String query, String... arguments) {
        SugarRecord.executeQuery(query, arguments);
    }
}
