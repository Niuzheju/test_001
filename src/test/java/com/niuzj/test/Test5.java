package com.niuzj.test;

import org.junit.Test;

import java.io.*;

/**
 * 类加载器
 * 引导类加载器BootStrapClassLoader类加载器加载$JRE_HOME/lib下的jar包
 * 扩展类加载器ExtensionClassLoader,加载$JRE_HOME/lib/ext下的jar包
 * 应用类加载器AppClassLoader,加载当前应用下的classpath路径下的类
 */
public class Test5 {

    /**
     * BootStrap ClassLoader类加载器加载$JRE_HOME/lib下的jar包
     * 包含了rt.jar, charsets.jar, resources.jar等
     */
    @Test
    public void test01() {
        System.out.println(System.getProperty("sun.boot.class.path"));

    }

    /**
     * 扩展类加载器,加载$JRE_HOME/lib/ext下的jar包
     */
    @Test
    public void test02() {
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(this.getClass().getClassLoader().getParent().getParent());
    }

    /**
     * 通过自定义类加载器加载一个class
     * 必须要加载项目中不存在的class,因为项目中的class会被AppClassLoader加载
     */
    @Test
    public void test03() throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("E:\\学习\\test_temp_file");
        Class<?> c = myClassLoader.loadClass("com.niuzj.test.User");
        System.out.println(c);
        System.out.println(c.getClassLoader());
        System.out.println(c.getClassLoader().getParent());
        System.out.println(c.newInstance());

    }


}

class MyClassLoader extends ClassLoader {

    private String classpath;

    public MyClassLoader(String classpath) {
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (name == null || "".equals(name)) {
            return null;
        }
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream out = null;
        try {
            fileInputStream = new FileInputStream(classpath + File.separator + name.replace(".", File.separator) + ".class");
            out = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            int len;
            while ((len = fileInputStream.read(data)) != -1) {
                out.write(data, 0, len);
            }
            byte[] bytes = out.toByteArray();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return super.findClass(name);
    }
}
