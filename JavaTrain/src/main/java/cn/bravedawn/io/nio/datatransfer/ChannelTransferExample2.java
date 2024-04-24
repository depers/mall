package cn.bravedawn.io.nio.datatransfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-25 11:43
 */
public class ChannelTransferExample2 {

    /**
     * 将四个文件合并写入到一个文件中
     */


    public static void main(String[] args) throws IOException {
        //Path of Input files
        String[] iF = new String[]{"D:\\input1.txt", "D:\\input2.txt", "D:\\input3.txt", "D:\\input4.txt"};

        //Path of Output file and contents will be written in this file
        String oF = "D:\\combine_output.txt";
        //Acquired the channel for output file
        FileOutputStream output = new FileOutputStream(new File(oF));
        WritableByteChannel targetChannel = output.getChannel();
        for (int j = 0; j < iF.length; j++) {
            //Get the channel for input files
            FileInputStream input = new FileInputStream(iF[j]);
            FileChannel inputChannel = input.getChannel();

            //The data is tranfer from input channel to output channel
            inputChannel.transferTo(0, inputChannel.size(), targetChannel);

            //close an input channel
            inputChannel.close();
            input.close();
        }
        //close the target channel
        targetChannel.close();
        output.close();
    }
}
