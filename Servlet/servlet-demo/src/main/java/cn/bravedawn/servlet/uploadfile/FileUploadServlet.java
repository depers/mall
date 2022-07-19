package cn.bravedawn.servlet.uploadfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * @author : depers
 * @program : servlet-demo
 * @date : Created in 2022/7/19 21:53
 */

@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,      // 10 MB
                 maxFileSize = 1024 * 1024 * 50,            // 50 MB
                 maxRequestSize = 1024 * 1024 * 100)        // 100 MB
public class FileUploadServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 这一句代码很重要，不然上传的文件名是乱码
        request.setCharacterEncoding("utf-8");
        String applicationPath = request.getServletContext().getRealPath("");
        // 这里的applicationPath指的就是idea编译输出的目录：E:\demo\Java\idea\mall\Servlet\servlet-demo\out\artifacts\servlet_demo_Web_exploded\
        System.out.println("applicationPath = " + applicationPath);
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory=" + fileSaveDir.getAbsolutePath());

        for (Part part : request.getParts()) {
            String fileName = getFileName(part);
            part.write(uploadFilePath + File.separator + fileName);
        }

        request.setAttribute("message", "File uploaded successfully!");
        getServletContext().getRequestDispatcher("/response.jsp").forward(request, response);
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= " + contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
    }
}
