package test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
/**
 * SoftReference,WeakReference demoTest
 * */
public class referenceDemo {
    public static void main(String[] args) {
        String str = new String("abc");
        SoftReference<String> stringSoftReference = new SoftReference<String>(str);
        str = null;
        System.gc();
        System.out.println(stringSoftReference.get());
        String abd = new String("123");
        WeakReference<String> weakReference = new WeakReference<String>(abd);
        abd = null;
        System.gc();
        System.out.println(weakReference.get());
    }
}
