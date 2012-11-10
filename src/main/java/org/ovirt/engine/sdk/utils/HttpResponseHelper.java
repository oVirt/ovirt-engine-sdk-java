package org.ovirt.engine.sdk.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

public class HttpResponseHelper {
    public static synchronized String getEntity(HttpEntity entity) throws ParseException, IOException {
        if (entity != null) {
            return EntityUtils.toString(entity);
        } else {
            return null;
        }
    }
}
