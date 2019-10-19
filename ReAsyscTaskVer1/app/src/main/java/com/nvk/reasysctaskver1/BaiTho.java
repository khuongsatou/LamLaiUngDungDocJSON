package com.nvk.reasysctaskver1;

public class BaiTho {
    private String tacGia;
    private String title;

    public BaiTho() {
    }

    public BaiTho(String tacGia, String title) {
        this.tacGia = tacGia;
        this.title = title;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
