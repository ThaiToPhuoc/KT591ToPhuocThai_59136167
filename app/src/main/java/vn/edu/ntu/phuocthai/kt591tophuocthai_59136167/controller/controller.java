package vn.edu.ntu.phuocthai.kt591tophuocthai_59136167.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.phuocthai.kt591tophuocthai_59136167.model.info;

public class controller extends Application implements Icontroller {
    List<info> infoList;

    public controller() {
        infoList = new ArrayList<>();
    }

    @Override
    public List<info> GetAllInfo() {
        return infoList;
    }

    @Override
    public void addinfo(info info) {
        infoList.add(info);
    }
}
