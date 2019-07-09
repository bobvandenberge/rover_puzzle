package com.wearebit;

public class Bron {
    private int brandstof;
    private int kmTotVolgendeBron;

    public Bron(int brandstof, int kmTotVolgendeBron) {
        this.brandstof = brandstof;
        this.kmTotVolgendeBron = kmTotVolgendeBron;
    }

    public int getBrandstof() {
        return brandstof;
    }

    public int getKmTotVolgendeBron() {
        return kmTotVolgendeBron;
    }

    public int overheadInBrandstof() {
        return brandstof - kmTotVolgendeBron;
    }

    @Override
    public String toString() {
        return "Bron{" +
                "brandstof=" + brandstof +
                ", kmTotVolgendeBron=" + kmTotVolgendeBron +
                '}';
    }
}
