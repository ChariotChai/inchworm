package java.others;

import java.lang.reflect.Field;

/**
 * @author chaiyuze
 * @since 2018/12/24
 */
public class ObjectCalculator {

    public static class ObjectInfo {
        private int instanceOccupyMemory;
        private int classOccupyMemory;

        public String info() {
            return "occupy memory = " + instanceOccupyMemory;
        }
    }

    public ObjectInfo calculate(Object object) {
        ObjectInfo info = new ObjectInfo();
        calculateInstance(object, info);
        return info;
    }

    private void calculateInstance(Object object, ObjectInfo info) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field: fields) {
//            if (field.getType())
        }

    }

}
