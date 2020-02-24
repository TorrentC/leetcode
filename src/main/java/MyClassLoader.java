import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author torrent
 * @date 20-2-2 下午10:19
 */
public class MyClassLoader extends ClassLoader {

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public MyClassLoader() {
    }

    public String path = "";
    private final String fileExtension = ".class";

    @Override
    protected Class<?> findClass(String name) {
        System.out.println(MyClassLoader.class.hashCode());
        byte[] b = loadClassData(name.replace(".", File.separator));
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) {

        byte[] data = new byte[1024];
        int len;

        try (
                FileInputStream is = new FileInputStream(this.path + File.separator + name + this.fileExtension);
                ByteArrayOutputStream os = new ByteArrayOutputStream()
        ) {

            while ((len = is.read(data)) != -1) {
                os.write(data, 0, len);
            }

            return os.toByteArray();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

