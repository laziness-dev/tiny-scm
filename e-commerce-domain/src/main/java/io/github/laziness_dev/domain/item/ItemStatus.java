package io.github.laziness_dev.domain.item;

public enum ItemStatus {
    판매_준비,
    판매_중,
    판매_종료;

    public static ItemStatus init() {
        return  판매_준비;
    }
}
