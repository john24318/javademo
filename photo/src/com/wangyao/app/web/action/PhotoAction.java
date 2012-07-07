package com.wangyao.app.web.action;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;

import com.wangyao.app.persistence.dao.PhotoDao;
import com.wangyao.app.persistence.model.Photo;
import com.wangyao.base.persistence.Page;
import com.wangyao.base.web.action.BaseAction;

public class PhotoAction extends BaseAction {

    public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm df = (DynaActionForm) form;
        Page pageInfo = (Page) df.get("pageInfo");
        PhotoDao photoDao = new PhotoDao();

        // if (null != pageInfo) {
        // pageInfo.setPageSize(Constants.PAGE_SIZE);
        // }

        List photoList = photoDao.list(pageInfo);

        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("photoList", photoList);
        return mapping.findForward("photoList");
    }

    public ActionForward image(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm df = (DynaActionForm) form;
        Integer id = (Integer) df.get("id");
        Photo photo = null;
        PhotoDao photoDao = new PhotoDao();

        if (null != id && id.intValue() > 0) {
            photo = photoDao.get(id);
        }

        if (null != photo) {
            // 设置页面不缓存
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", -1);
            // 设置响应类型
            String type = photo.getType();
            if ("jpe".equals(type) || "jpeg".equals(type) || "jpg".equals(type)) {
                response.setContentType("image/jpeg");
            } else if ("dib".equals(type) || "bmp".equals(type)) {
                response.setContentType("image/bmp");
            } else {
                response.setContentType("image/" + photo.getType());
            }

            InputStream is = photo.getImage().getBinaryStream();
            OutputStream os = response.getOutputStream();
            int length = 0;
            int bufferSize = 8192;
            byte[] buffer = new byte[bufferSize];
            while ((length = is.read(buffer, 0, bufferSize)) != -1) {
                os.write(buffer, 0, length);
            }
        }

        return null;
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm df = (DynaActionForm) form;
        Integer id = (Integer) df.get("id");
        Photo photo = null;
        PhotoDao photoDao = new PhotoDao();

        if (null != id && id.intValue() > 0) {
            photo = photoDao.get(id);
        }

        request.setAttribute("photo", photo);
        return mapping.findForward("photoEdit");
    }

    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm df = (DynaActionForm) form;
        Integer id = (Integer) df.get("id");
        FormFile image = (FormFile) df.get("image");
        String netImage = df.getString("netImage").trim();
        Photo photo = null;
        boolean result = false;
        String msg = null;
        PhotoDao photoDao = new PhotoDao();

        if (null != id && id.intValue() > 0) {
            photo = photoDao.get(id);
            if (null != photo) {
                photo.setName(df.getString("name"));

                if (null != image && !"".equals(image.getFileName())) {
                    // 使用SWFUpload时，Flash Player上传所有文件的MIME Type都是application/octet-stream
                    // String contentType = image.getContentType();
                    // photo.setType(contentType.substring(contentType.lastIndexOf('/') + 1));
                    String contentType = image.getFileName().toLowerCase();
                    photo.setType(contentType.substring(contentType.lastIndexOf('.') + 1));
                    photo.setSize(Integer.valueOf(image.getFileSize()));
                    result = photoDao.update(photo, image.getInputStream(), image.getFileSize());
                } else if (null != netImage && !"".equals(netImage)) {
                    URL url = new URL(netImage);
                    HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                    if (HttpURLConnection.HTTP_OK == connect.getResponseCode()) {
                        int length = connect.getHeaderFieldInt("Content-Length", 0);
                        String contentType = connect.getHeaderField("Content-Type");
                        photo.setType(contentType.substring(contentType.lastIndexOf('/') + 1));
                        photo.setSize(Integer.valueOf(length));
                        result = photoDao.update(photo, connect.getInputStream(), length);
                    }
                } else {
                    result = photoDao.update(photo, null, 0);
                }
            }

            msg = result ? "修改图片成功！" : "修改图片失败！";
        } else {
            photo = new Photo();
            photo.setName(df.getString("name"));
            photo.setCreateTime(new Date());

            if (null != image && !"".equals(image.getFileName())) {
                // 使用SWFUpload时，Flash Player上传所有文件的MIME Type都是application/octet-stream
                // String contentType = image.getContentType();
                // photo.setType(contentType.substring(contentType.lastIndexOf('/') + 1));
                String contentType = image.getFileName().toLowerCase();
                photo.setType(contentType.substring(contentType.lastIndexOf('.') + 1));
                photo.setSize(Integer.valueOf(image.getFileSize()));
                result = photoDao.add(photo, image.getInputStream(), image.getFileSize());
            } else if (null != netImage && !"".equals(netImage.trim())) {
                URL url = new URL(netImage);
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                if (HttpURLConnection.HTTP_OK == connect.getResponseCode()) {
                    int length = connect.getHeaderFieldInt("Content-Length", 0);
                    String contentType = connect.getHeaderField("Content-Type");
                    contentType = contentType.split(";")[0];
                    contentType = contentType.substring(contentType.lastIndexOf('/') + 1);
                    photo.setType(contentType);
                    photo.setSize(Integer.valueOf(length));
                    result = photoDao.add(photo, connect.getInputStream(), connect.getHeaderFieldInt("Content-Length", 0));
                }
            }

            msg = result ? "新增图片成功！" : "新增图片失败！";
        }

        request.setAttribute("msg", msg);
        //return list(mapping, form, request, response);
        return mapping.findForward("list");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm df = (DynaActionForm) form;
        Integer[] ids = (Integer[]) df.get("ids");
        PhotoDao photoDao = new PhotoDao();
        boolean result = false;
        String msg = null;

        if (null != ids && ids.length > 0) {
            result = photoDao.delete(ids);
        }

        msg = result ? "删除图片成功！" : "删除图片失败！";

        request.setAttribute("msg", msg);
        //return list(mapping, form, request, response);
        return mapping.findForward("list");
    }
}
