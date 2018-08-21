package com.mvp.waino.utils;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.DiskLogAdapter;

import java.util.logging.Logger;

/**
 * @author waino
 * @date 2018/8/21
 * @desc todo
 */
public class WLog {
    private static boolean ISDEBUG = true;

    static {
        if (ISDEBUG) {
            com.orhanobut.logger.Logger.addLogAdapter(new AndroidLogAdapter());
            com.orhanobut.logger.Logger.addLogAdapter(new DiskLogAdapter());
        }
    }

    public static void json(String json) {
        if (ISDEBUG) {
            com.orhanobut.logger.Logger.json(json);
        }
    }

    public static void i(String tag, String msg) {
        if (ISDEBUG) {
            com.orhanobut.logger.Logger.i(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (ISDEBUG) {
            com.orhanobut.logger.Logger.d(tag, msg);
        }
    }

    public static void d(Object obj) {
        if (ISDEBUG) {
            com.orhanobut.logger.Logger.d(obj);
        }
    }

    public static void v(String tag, String msg) {
        if (ISDEBUG) {
            com.orhanobut.logger.Logger.v(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (ISDEBUG) {
            com.orhanobut.logger.Logger.w(tag, msg);
        }
    }

    public static void w(String tag, String msg, Throwable throwable) {
        if (ISDEBUG) {
            com.orhanobut.logger.Logger.w(tag, msg, throwable);
        }
    }

    public static void e(String tag, String msg) {
        if (ISDEBUG) {
            com.orhanobut.logger.Logger.e(tag, msg);
        }
    }

    public static void e(String tag, String msg, Throwable throwable) {
        if (ISDEBUG) {
            com.orhanobut.logger.Logger.e(tag, msg, throwable);
        }
    }
}
