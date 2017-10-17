import java.io.*;
import java.nio.*;
import java.nio.channels.*;


public class JavaFileCopier {

    public JavaFileCopier() {
    }

    static void copier(String fichier_source, String fichier_dest)throws IOException
    {
        FileInputStream src = new FileInputStream(fichier_source);
        FileOutputStream dest = new FileOutputStream(fichier_dest);

        FileChannel inChannel = src.getChannel();
        FileChannel outChannel = dest.getChannel();

        for (ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
             inChannel.read(buffer) != -1;
             buffer.clear()) {
            buffer.flip();
            while (buffer.hasRemaining()) outChannel.write(buffer);
        }

        inChannel.close();
        outChannel.close();
    }
}

