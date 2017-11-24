package ru.kfu.itis.util;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kfu.itis.servlet.AddPostServlet;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

public class MultipartRequestUtil {
    private final static Logger LOG = LoggerFactory.getLogger(AddPostServlet.class);

    public static String getStringFromReqPart(Part part) {
        String str = "";
        if (part != null) {
            try {
                InputStream in = part.getInputStream();
                str = IOUtils.toString(in);
            } catch (IOException e) {
                LOG.error("Error get string parameter from multipart request", e);
            }
        }

        return str;
    }
}
