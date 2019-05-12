package com.sn.mvclibrary.base.base;

public interface RequestCall1Back<T> {
    void success1(T data);

    void success1(boolean isSucessful);
}
