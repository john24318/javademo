package com.wangyao.app.persistence.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wangyao.app.persistence.model.Photo;
import com.wangyao.base.persistence.Page;
import com.wangyao.base.persistence.dao.BaseDao;

public class PhotoDao extends BaseDao {

    public boolean add(Photo photo, InputStream inputStream, int length) {
        Connection con = getConnection();
        String sql = "INSERT INTO photo (id, NAME, image, TYPE, size, create_time) VALUES (NULL, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        int rows = 0;
        boolean result = false;

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, photo.getName());
            pstmt.setBinaryStream(2, inputStream, length);
            pstmt.setString(3, photo.getType());
            pstmt.setInt(4, length);
            pstmt.setTimestamp(5, new Timestamp(photo.getCreateTime().getTime()));
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, pstmt, con);
        }

        if (rows > 0) {
            result = true;
        }

        return result;
    }

    public boolean delete(Integer id) {
        boolean result = false;
        String sql = "DELETE FROM photo WHERE id=?";

        int rows = update(sql, new Object[] { id });

        if (rows > 0) {
            result = true;
        }

        return result;
    }

    public boolean delete(Integer[] ids) {
        boolean result = false;
        StringBuffer sb = new StringBuffer();
        String sql = "DELETE FROM photo WHERE id IN (";

        for (int i = 0; i < ids.length; i++) {
            sb.append(ids[i] + ",");
        }
        sb.append("0");
        sql = sql + sb.toString() + ")";

        int rows = update(sql, null);

        if (rows > 0) {
            result = true;
        }

        return result;
    }

    public boolean update(Photo photo, InputStream inputStream, int length) {
        Connection con = getConnection();
        String sql = null;
        PreparedStatement pstmt = null;
        int rows = 0;
        boolean result = false;

        if (null != inputStream) {
            sql = "UPDATE photo SET NAME=?, image=?, TYPE=?, size=? WHERE id=?";
            try {
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, photo.getName());
                pstmt.setBinaryStream(2, inputStream, length);
                pstmt.setString(3, photo.getType());
                pstmt.setInt(4, length);
                pstmt.setInt(5, photo.getId().intValue());
                rows = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close(null, pstmt, con);
            }
        } else {
            sql = "UPDATE photo SET NAME=? WHERE id=?";
            rows = update(sql, new Object[] { photo.getId() });
        }

        if (rows > 0) {
            result = true;
        }

        return result;
    }

    public Photo get(Integer id) {
        Connection con = getConnection();
        String sql = "SELECT id, NAME, image, TYPE, size, create_time FROM photo WHERE id=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Photo photo = null;

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id.intValue());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                photo = new Photo();
                photo.setId(Integer.valueOf(rs.getInt(1)));
                photo.setName(rs.getString(2));
                photo.setImage(rs.getBlob(3));
                photo.setType(rs.getString(4));
                photo.setSize(Integer.valueOf(rs.getInt(5)));
                photo.setCreateTime(rs.getTimestamp(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }

        return photo;
    }

    public List list() {
        Connection con = getConnection();
        // String sql = "SELECT id, NAME, image, TYPE, size, create_time FROM photo ORDER BY id DESC";
        String sql = "SELECT id, NAME, TYPE, size, create_time FROM photo ORDER BY id DESC";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Photo photo = null;
        List list = new ArrayList();

        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                photo = new Photo();
                photo.setId(Integer.valueOf(rs.getInt(1)));
                photo.setName(rs.getString(2));
                // photo.setImage(rs.getBlob(3));
                // photo.setType(rs.getString(4));
                // photo.setSize(Integer.valueOf(rs.getInt(5)));
                // photo.setCreateTime(rs.getTimestamp(6));
                photo.setType(rs.getString(3));
                photo.setSize(Integer.valueOf(rs.getInt(4)));
                photo.setCreateTime(rs.getTimestamp(5));
                list.add(photo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }

        return list;
    }

    public List list(Page page) {
        // 设置总条数
        String countSql = "SELECT COUNT(*) as totalRows FROM photo";
        Map map = (Map) get(countSql, null);
        page.setTotalRows(((Long) map.get("totalRows")).longValue());

        Connection con = getConnection();
        int offset = (page.getPageNo() - 1) * page.getPageSize();
        int size = page.getPageSize();
        // String sql = "SELECT id, NAME, image, TYPE, size, create_time FROM photo ORDER BY id DESC LIMIT " + offset + ", " + size;
        String sql = "SELECT id, NAME, TYPE, size, create_time FROM photo ORDER BY id DESC LIMIT " + offset + ", " + size;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Photo photo = null;
        List list = new ArrayList();

        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                photo = new Photo();
                photo.setId(Integer.valueOf(rs.getInt(1)));
                photo.setName(rs.getString(2));
                // photo.setImage(rs.getBlob(3));
                // photo.setType(rs.getString(4));
                // photo.setSize(Integer.valueOf(rs.getInt(5)));
                // photo.setCreateTime(rs.getTimestamp(6));
                photo.setType(rs.getString(3));
                photo.setSize(Integer.valueOf(rs.getInt(4)));
                photo.setCreateTime(rs.getTimestamp(5));
                list.add(photo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }

        return list;
    }

    private void close(ResultSet rs, Statement statement, Connection con) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (null != statement) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (null != con) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
