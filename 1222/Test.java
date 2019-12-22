import java.util.*;

class Student{
    public String name;
    public String cla;
    public double score;
    public Student(String name,String cla,double score){
        this.name = name;
        this.cla = cla;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cla='" + cla + '\'' +
                ", score=" + score +
                '}';
    }
}
public class Test {
    public static List<Character> func(String str1,String str2){
        List<Character> ret = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            if(str2.contains(str1.charAt(i)+"")!=true){
                ret.add(str1.charAt(i));
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        List<Character> ret = func(str1,str2);
        System.out.println(ret);
    }
    public static void main3(String[] args) {
        List<Student> list = new LinkedList<>();
        list.add(new Student("小赞","1班",99.5));
        list.add(new Student("椰啵","2班",89.5));
        list.add(new Student("王琑","3班",95));
        //pSystem.out.println(list);
        for(Student student : list){
            System.out.println(student);
        }
    }
    public static void main2(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("小赞","肖战");
        map.put("耶啵","王一博");
        map.put("博肖","博君一肖");
        map.put("bxg","百香果");
        System.out.println(map);
        System.out.println(map.size());
        String str = map.getOrDefault("bxg1","巴西龟");
        System.out.println(str);
        System.out.println(map.containsKey("博肖"));
        System.out.println(map.get("小赞"));
        System.out.println(map.containsValue("王一博"));
        System.out.println("======");
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
    public static void main1(String[] args) {
        Collection<String> collection = new ArrayList<>();
        //尾插
        collection.add("bjyx");
        collection.add("szd");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        System.out.println(collection);
        collection.remove("szd");
        System.out.println(collection);
        collection.add("0805");
        collection.add("1005");
        System.out.println(collection);
        Object[] arr = collection.toArray();
        System.out.println(Arrays.toString(arr));
        collection.clear();
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
    }
}
