package com.example.demo.buffer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelTest {

    /**
     * 一.通道（channel）：用于源节点与目标节点的连接。在Java NIO中负责缓冲区数据的传输。Channel本身不存储数据，需要配合缓冲区使用
     *
     * 二.通道的主要实现类
     *      java.nio.channels.Channel接口
     *          |--FileChannel
     *          |--SocketChannel
     *          |--ServerSocketChannel
     *          |--DatagramChannel
     *
     * 三.获取通道
     *      1.Java针对支持通道的类提供了getChannel()方法
     *          本地IO
     *          FileInputStream/FileOutputStream
     *          RandomAccessFile
     *          网络IO
     *          Socket
     *          ServerSocket
     *          DatagrmSocket
     *
     *      2.JDK7中的NIO.2针对各个通道提供了静态方法open()
     *      3.JDK7中的NIO.2的Files工具类得newByteChannel()
     * 四.通道之间的数据传输
     *    transferFrom()
     *    transferTo()
     *
     * 五.分散(Scatter)与聚集(Gatter)
     *    分散读取(Scattering Reads)：将通道中的数据分散到多个缓冲区中
     *    聚集写入(Gattering Writes)：将多个缓冲区中的数据聚集到通道中
     *
     */

    // 通道之间的数据传输（直接缓冲区）
    @Test
    public void test3() {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("src/照片.jpg"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("src/照片copy1.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

            // outChannel.transferTo(inChannel.size(), 0, outChannel);
            outChannel.transferFrom(inChannel, 0, inChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inChannel) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != outChannel) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 使用直接缓冲区完成文件的复制（内存映射文件）
    @Test
    public void test2(){
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("src/照片.jpg"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("src/照片copy1.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

            // 内存映射文件
            MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            // 直接对缓冲区进行数据的读写操作
            byte[] bytes = new byte[inMappedByteBuffer.limit()];
            inMappedByteBuffer.get(bytes);
            outMappedByteBuffer.put(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inChannel) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != outChannel) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 利用通道完成文件的复制（非直接缓冲区）
    @Test
    public void test1() throws Exception{
        FileInputStream fis = new FileInputStream("src/照片.jpg");
        FileOutputStream fos = new FileOutputStream("src/照片copy.jpg");

        //获取通道
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();

        //分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(2048);

        //将通道中的数据存入缓冲区中
        while (fisChannel.read(buffer) != -1){
            buffer.flip(); //切换读取数据的模式
            //将缓冲区中数据写入通道中
            fosChannel.write(buffer);
            buffer.clear(); //清空缓冲区
        }
        fosChannel.close();
        fisChannel.close();
        fos.close();
        fis.close();

    }

}
