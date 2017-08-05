package com.prateek.shopperslove.dao;

import com.prateek.shopperslove.model.AppInfo;

import java.util.List;

/**
 * Created by user on 8/5/2017.
 */

public interface AppInfoDao {
    public List<AppInfo> fetchApplicationsInfo();
}
