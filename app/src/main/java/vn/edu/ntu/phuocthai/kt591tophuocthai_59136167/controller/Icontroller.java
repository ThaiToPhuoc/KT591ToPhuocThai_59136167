package vn.edu.ntu.phuocthai.kt591tophuocthai_59136167.controller;

import java.util.List;

import vn.edu.ntu.phuocthai.kt591tophuocthai_59136167.model.info;

public interface Icontroller {
    public List<info> GetAllInfo();
    public void addinfo(info info);
}
