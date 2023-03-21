
package system;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;

public class SystemUtil {
    public SystemUtil() {
    }


    public static String getEnv(String name) {
        return System.getenv(name);
    }


    public static void setEnv(String key, String value) {
        //System.setSecurityManager(new SecurityManager());
        System.setSecurityManager(null);
        try {
            Map<String, String> env = System.getenv();
            Class<?> cl = env.getClass();
            Field field = cl.getDeclaredField("m");
            field.setAccessible(true);
            Map<String, String> writableEnv = (Map) field.get(env);
            writableEnv.put(key, value);
        } catch (Exception var6) {
            throw new IllegalStateException("Failed to set environment variable", var6);
        }
    }

    public static void setEnv(Map<String, String> newenv) {
        try {
            try {
                Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");
                Field theEnvironmentField = processEnvironmentClass.getDeclaredField("theEnvironment");
                theEnvironmentField.setAccessible(true);
                Map<String, String> env = (Map<String, String>) theEnvironmentField.get(null);
                env.putAll(newenv);
                Field theCaseInsensitiveEnvironmentField = processEnvironmentClass.getDeclaredField("theCaseInsensitiveEnvironment");
                theCaseInsensitiveEnvironmentField.setAccessible(true);
                Map<String, String> cienv = (Map<String, String>) theCaseInsensitiveEnvironmentField.get(null);
                cienv.putAll(newenv);
            } catch (NoSuchFieldException | ClassNotFoundException e) {
                Class[] classes = Collections.class.getDeclaredClasses();
                Map<String, String> env = System.getenv();
                for (Class cl : classes) {
                    if ("java.util.Collections$UnmodifiableMap".equals(cl.getName())) {
                        Field field = cl.getDeclaredField("m");
                        field.setAccessible(true);
                        Object obj = field.get(env);
                        Map<String, String> map = (Map<String, String>) obj;
                        map.clear();
                        map.putAll(newenv);
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}