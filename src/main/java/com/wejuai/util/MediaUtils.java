package com.wejuai.util;

import com.wejuai.entity.mysql.Audio;
import com.wejuai.entity.mysql.Image;
import com.wejuai.entity.mysql.Video;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ZM.Wang
 */
public class MediaUtils {

    public final static String DEF_HEAD_IMAGE = "SYS_IMAGE/defHeadImage.png";

    public static String buildUrl(Image image) {
        if (image == null) {
            return null;
        }
        return "https://media.wejuai.com/" + image.getOssKey();
    }

    public static String buildUrlHasId(Image image) {
        if (image == null) {
            return null;
        }
        return "https://media.wejuai.com/" + image.getOssKey() + "?id=" + image.getId();
    }

    public static String buildUrl(Video video) {
        if (video == null) {
            return null;
        }
        return "https://media.wejuai.com/" + video.getOssKey();
    }

    public static String buildUrlHasId(Video video) {
        if (video == null) {
            return null;
        }
        return "https://media.wejuai.com/" + video.getOssKey() + "?id=" + video.getId();
    }

    public static String buildUrl(Audio audio) {
        if (audio == null) {
            return null;
        }
        return "https://media.wejuai.com/" + audio.getOssKey();
    }

    public static String buildUrlHasId(Audio audio) {
        if (audio == null) {
            return null;
        }
        return "https://media.wejuai.com/" + audio.getOssKey() + "?id=" + audio.getId();
    }

    public static String buildUrlByOssKey(String ossKey) {
        if (StringUtils.isBlank(ossKey)) {
            return null;
        }
        return "https://media.wejuai.com/" + ossKey;
    }

}
