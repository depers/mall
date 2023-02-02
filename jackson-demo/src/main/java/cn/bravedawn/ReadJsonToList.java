package cn.bravedawn;

/**
 * @author : depers
 * @program : jackson-demo
 * @description:
 * @date : Created in 2023/2/1 17:08
 */
public class ReadJsonToList {


    private String json = "[\n" +
            "  {\n" +
            "    \"name\": \".gitignore\",\n" +
            "    \"path\": \".gitignore\",\n" +
            "    \"sha\": \"6d19323ee26946ed98b66ac81abc6abeaa0c4d32\",\n" +
            "    \"size\": 478,\n" +
            "    \"url\": \"https://api.github.com/repos/depers/jasper-db/contents/.gitignore?ref=main\",\n" +
            "    \"html_url\": \"https://github.com/depers/jasper-db/blob/main/.gitignore\",\n" +
            "    \"git_url\": \"https://api.github.com/repos/depers/jasper-db/git/blobs/6d19323ee26946ed98b66ac81abc6abeaa0c4d32\",\n" +
            "    \"download_url\": \"https://raw.githubusercontent.com/depers/jasper-db/main/.gitignore?token=ADZ4M5IQ455MVF6IGS3HJYTD3IMNK\",\n" +
            "    \"type\": \"file\",\n" +
            "    \"_links\": {\n" +
            "      \"self\": \"https://api.github.com/repos/depers/jasper-db/contents/.gitignore?ref=main\",\n" +
            "      \"git\": \"https://api.github.com/repos/depers/jasper-db/git/blobs/6d19323ee26946ed98b66ac81abc6abeaa0c4d32\",\n" +
            "      \"html\": \"https://github.com/depers/jasper-db/blob/main/.gitignore\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"2023\",\n" +
            "    \"path\": \"2023\",\n" +
            "    \"sha\": \"770c076b024482811eba43726762044b0f9fb362\",\n" +
            "    \"size\": 0,\n" +
            "    \"url\": \"https://api.github.com/repos/depers/jasper-db/contents/2023?ref=main\",\n" +
            "    \"html_url\": \"https://github.com/depers/jasper-db/tree/main/2023\",\n" +
            "    \"git_url\": \"https://api.github.com/repos/depers/jasper-db/git/trees/770c076b024482811eba43726762044b0f9fb362\",\n" +
            "    \"download_url\": null,\n" +
            "    \"type\": \"dir\",\n" +
            "    \"_links\": {\n" +
            "      \"self\": \"https://api.github.com/repos/depers/jasper-db/contents/2023?ref=main\",\n" +
            "      \"git\": \"https://api.github.com/repos/depers/jasper-db/git/trees/770c076b024482811eba43726762044b0f9fb362\",\n" +
            "      \"html\": \"https://github.com/depers/jasper-db/tree/main/2023\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"README.md\",\n" +
            "    \"path\": \"README.md\",\n" +
            "    \"sha\": \"6bb4003f508d5301502b58abd4c1c8d70bba810d\",\n" +
            "    \"size\": 12,\n" +
            "    \"url\": \"https://api.github.com/repos/depers/jasper-db/contents/README.md?ref=main\",\n" +
            "    \"html_url\": \"https://github.com/depers/jasper-db/blob/main/README.md\",\n" +
            "    \"git_url\": \"https://api.github.com/repos/depers/jasper-db/git/blobs/6bb4003f508d5301502b58abd4c1c8d70bba810d\",\n" +
            "    \"download_url\": \"https://raw.githubusercontent.com/depers/jasper-db/main/README.md?token=ADZ4M5IU3SPXYCLOJWK4CQ3D3IMNK\",\n" +
            "    \"type\": \"file\",\n" +
            "    \"_links\": {\n" +
            "      \"self\": \"https://api.github.com/repos/depers/jasper-db/contents/README.md?ref=main\",\n" +
            "      \"git\": \"https://api.github.com/repos/depers/jasper-db/git/blobs/6bb4003f508d5301502b58abd4c1c8d70bba810d\",\n" +
            "      \"html\": \"https://github.com/depers/jasper-db/blob/main/README.md\"\n" +
            "    }\n" +
            "  }\n" +
            "]\n";


    public static void main(String[] args) {

    }
}
