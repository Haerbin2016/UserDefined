package com.example.rocky.userdefined.genericity;

/**
 * Created by Rocky on 2016/5/24.
 */
public class InfoImpl<T,K,U> implements Info<U> {
    private U mVar = null;
    private T x;
    private K y;

    public InfoImpl(U var) {
        mVar = var;
    }

    @Override
    public U getVar() {
        return mVar;
    }

    @Override
    public void setVar(U u) {
        mVar = u;
    }
    public <T,V> T parseArray(String str,Class<T> object) throws InstantiationException,IllegalAccessException{
        T t = object.newInstance();
        return t;
    }
}
