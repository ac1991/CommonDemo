package com.commondemo.xiaoyu.commondemo.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Xiaoyu on 2018/8/2.
 */
@Entity(tableName = "student")
public class StudentEntity {

    @PrimaryKey
    public long id;

    public String name;
}
