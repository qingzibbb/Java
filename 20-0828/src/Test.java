public class Test {
    public static void main(String[] args) {

    }

    public static Test instance;

    public static Test getInstance(){
        if(instance==null){
            synchronized (Test.class){
                if(instance==null){
                    instance = new Test();
                }
            }
        }
        return instance;
    }

    public String find(String s){
        int max = 0;
        String tmp = "";
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String str = s.substring(i,j+1);
                StringBuilder sb = new StringBuilder(str);
                if(str.equals(sb.reverse().toString())&&str.length()>max){
                    tmp = str;
                    max = str.length();
                }
            }
        }
        return tmp;
    }
}
