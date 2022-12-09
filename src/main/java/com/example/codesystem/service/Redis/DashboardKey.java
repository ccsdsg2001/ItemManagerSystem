package com.example.codesystem.service.Redis;

/**
 * @author cc
 * @date 2022年12月09日 17:47
 */
public class DashboardKey extends BasePrefix{
    public static final int BOARD_EXPIRE = 3600*24 *2;//默认两天

    /**
     * 防止被外面实例化
     */
    private DashboardKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 需要缓存的字段
     */
    public static DashboardKey board = new DashboardKey(BOARD_EXPIRE,"board");


}
