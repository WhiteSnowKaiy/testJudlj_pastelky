import java.util.List;
import java.util.Optional;
import java.util.function.Function;

class Main {
    public static void main(String[] args) {
        ukol1();
        ukol2();
        ukol3();
        ukol4();
        ukol5();
    }
    static void ukol1() {
        System.out.println("-----------ukol1---------------");
        List<Integer> values = List.of(3, 8, 12, 5, 19, 21, 30, 7);

        values.stream().filter(i -> {
            return i % 2 == 1 && i > 10;
        }).forEach(System.out::println);

        long size = values.stream().filter(i -> {
            return i % 2 == 1 && i > 10;
        }).count();
        System.out.println(size);
    }
    public static void ukol2(){
        System.out.println("----------ukol2---------------");
        List<String> words = List.of("java", "stream", "lambda", "api", "filter", "code");

        Object[] wordsToTransform = words.stream().filter(s -> {
            if (s.startsWith("a") || s.startsWith("c")) {
                return true;
            }
            return false;
        }).toArray();

        for (Object w : wordsToTransform){
            System.out.println(w.toString().toUpperCase());
        }
    }

    public static void ukol3(){
        System.out.println("----------ukol3---------------");
        List<String> cities = List.of("Praha", "Brno", "Ostrava", "Plzeň", "Olomouc");

        Optional<String> mesto = cities.stream().filter(w -> {
            return w.length() > 6;
        }).findFirst();
        if (mesto.isPresent()){
            System.out.println("Město: " + mesto.get());
        } else  {
            System.out.println("Žádné město nenalezeno");
        }
    }

    public static void ukol4(){
        System.out.println("----------ukol4---------------");
        List<Integer> values = List.of(2, 3, 5, 7, 11, 13, 17, 19);

        int value = values.stream().mapToInt(Integer::intValue).sum();
        System.out.println(value);

        Function<Integer, String> toText = n -> "Cislo: " + n;
        List<String> cisla = values.stream().map(toText).toList();
        System.out.println(cisla);
    }

    public static void ukol5(){
        System.out.println("----------ukol5---------------");
        List<Student> students = List.of(new Student("Lucie", 82), new Student("Tomáš", 67), new Student("Alena", 91), new Student("David", 47));

        Function<Student, String> toText = student -> "Student: " + student.getName() + ", Body: " + student.getPoints();
        students.stream().filter(i -> {return i.getPoints() >= 70;}).map(toText).forEach(System.out::println);
    }
}