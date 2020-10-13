package com.bitrix24.util;

public class GlobalDataUtil {

    private String tabName;


    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {

        this.tabName = tabName.toLowerCase();
    }
}
