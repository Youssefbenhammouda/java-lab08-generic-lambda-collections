package challengeSetOperations;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All Tasks", tasks);

        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's Tasks", annsTasks);

        Set<Task> bobsTasks = TaskData.getTasks("Bob");
        sortAndPrint("Bob's Tasks", bobsTasks);

        Set<Task> carolsTasks = TaskData.getTasks("Carol");
        sortAndPrint("Carol's Tasks", carolsTasks);


        sortAndPrint("Full tasks list",getUnion(List.of(tasks,annsTasks,bobsTasks,carolsTasks)));


        sortAndPrint("Tasks assigned to at least one employee",getUnion(List.of(annsTasks, bobsTasks, carolsTasks)));


        sortAndPrint("Tasks that still need to be assigned",getDifference(tasks,getUnion(List.of(annsTasks, bobsTasks, carolsTasks))));


        sortAndPrint("Tasks assigned to multiple employees",getUnion(List.of(getIntersect(annsTasks,bobsTasks),getIntersect(annsTasks,carolsTasks),getIntersect(bobsTasks,carolsTasks))));
    }

    private static void sortAndPrint(String header, Collection<Task> collection) {
        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);
        new TreeSet<>(collection).forEach(System.out::println);
    }


    private static Set<Task> getUnion(List<Set<Task>> sets) {
        Set<Task> union = new HashSet<>();

        for(final var set:sets){
            union.addAll(set);
        }

        return union;
    }


    private static Set<Task> getIntersect(Set<Task> a, Set<Task> b) {
        Set<Task> intersect = new HashSet<>();

        for(final var task:a){
            if(b.contains(task))intersect.add(task);
        }

        return intersect;
    }


    private static Set<Task> getDifference(Set<Task> a, Set<Task> b) {
        Set<Task> minus = new HashSet<>();

        for(final var task:a){
            if(!b.contains(task))minus.add(task);
        }

        return minus;
    }
}
