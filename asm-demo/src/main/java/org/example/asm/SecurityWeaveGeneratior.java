package org.example.asm;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by heqingfu on 2020/2/22.
 */
public class SecurityWeaveGeneratior {

    public static void main(String[] args) throws Exception {
        String className = Account.class.getName();
        ClassReader classReader = new ClassReader(className);
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        AddSecurityCheckClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
        classReader.accept(classAdapter, ClassReader.SKIP_DEBUG);
        byte[] data = cw.toByteArray();
        File file = new File("/Users/heqingfu/coding/hello-world/asm-demo/target/classes/" + className.replaceAll("\\.", "/") + ".class");
        if (file.exists()){
            System.out.println("exists");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(data);
        fileOutputStream.close();
    }

}
