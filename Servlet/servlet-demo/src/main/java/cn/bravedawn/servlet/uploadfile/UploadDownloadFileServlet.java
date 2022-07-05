package cn.bravedawn.servlet.uploadfile;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * @author : depers
 * @program : servlet-demo
 * @date : Created in 2022/7/5 22:01
 */

@WebServlet("/UploadDownloadFileServlet")
public class UploadDownloadFileServlet extends HttpServlet {

    private ServletFileUpload uploader = null;

    @Override
    public void init() throws ServletException {
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
        fileItemFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileItemFactory);
        this.uploader.setHeaderEncoding("UTF-8");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        if (fileName == null || fileName.equals("")) {
            throw new ServletException("File Name can't be null or empty");
        }

        File file = new File(getServletContext().getAttribute("FILES_DIR") + File.separator + fileName);
        getServletContext().log("Download file absolute Path at Server = " + file.getAbsolutePath());
        if (!file.exists()) {
            throw new ServletException("File doesn't exists on server.");
        }

        getServletContext().log("File location on server = " + file.getAbsolutePath());
        ServletContext context = getServletContext();
        InputStream is = new FileInputStream(file);
        String mimeType = context.getMimeType(file.getAbsolutePath());
        response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        ServletOutputStream os = response.getOutputStream();
        byte[] bufferData = new byte[1024];
        int read = 0;
        while((read = is.read(bufferData)) != -1) {
            os.write(bufferData, 0, read);
        }
        os.flush();
        os.close();
        is.close();
        getServletContext().log("File downloaded at client successfully");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!ServletFileUpload.isMultipartContent(request)){
            throw new ServletException("Content type is not multipart/form-data");
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<html><head></head><body>");

        try {
            List<FileItem> fileItemList = uploader.parseRequest(request);
            Iterator<FileItem> fileItemIterator = fileItemList.iterator();
            while (fileItemIterator.hasNext()) {
                FileItem fileItem = fileItemIterator.next();
                String fileName = new String(fileItem.getName().getBytes("ISO8859_1"), "UTF-8");
                
                getServletContext().log("FieldName = " + fileItem.getFieldName());
                getServletContext().log("FileName = " + fileName);
                getServletContext().log("ContextType = " + fileItem.getContentType());
                getServletContext().log("Size in bytes = " + fileItem.getSize());

                File file = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator + fileName);
                getServletContext().log("Absolute Path at Server = " + file.getAbsolutePath());
                fileItem.write(file);

                out.write("File " + fileItem.getName() + " upload successfully.");
                out.write("<br>");
                out.write("<a href=\"UploadDownloadFileServlet?fileName=" + fileName + "\">Download " + fileName + "</a>");
            }
        } catch (FileUploadException e) {
            out.write("Exception in uploading file.");
        } catch (Exception e) {
            out.write("Exception in uploading file.");
        }
        out.write("</body></html>");
    }
}
