package com.wen.factory.simplefactory;

public class PhonFactory {
    public static final String TYPE_IOS = "ios";
    public static final String TYPE_ANDROID = "android";
    private static Phone phone;

    public static Phone productionPhone(String type) {
        switch (type) {
            case TYPE_ANDROID:
                phone = new AndroidPhon();
                break;
            case TYPE_IOS:
                phone = new ApplePhon();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return phone;
    }
}
