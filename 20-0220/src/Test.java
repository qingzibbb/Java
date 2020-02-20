public class Test{
	 public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();//期望
        String str2 = scan.nextLine();//实际
        Set<Character> set = new HashSet<>();
        for(Character c:str2.toUpperCase().toCharArray()){
            set.add(c);
        }
        Set<Character> set2 = new HashSet<>();
        for(Character c:str1.toUpperCase().toCharArray()){
            if(!set.contains(c)&&!set2.contains(c)){
                set.add(c);
                System.out.print(c);
            }
        }
        System.out.println();
    }
}