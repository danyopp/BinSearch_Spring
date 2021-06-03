package com.yopp.spring.BinSearch.BinarySearchImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {


        int[] array = {9,8,3,6,7,2,1,4,5, 44, 38, 58, 58, 58, 383, 12, 50};
        int searchVal = 33;
        //SortAlgorithm algo = new HeapSort();


        //Assign Spring Context to local var
        ApplicationContext springContextVar = SpringApplication.run(Main.class, args);
        //get BinarySearch Bean from local context
        BinarySearch binSearch = springContextVar.getBean(BinarySearch.class);

        int result =  binSearch.search(array, searchVal );
        System.out.println("Result: " + result);
    }

}

/*Tell spring three things:
    What are the beans? = add @Component to the class
    What are the dependencies for a bean? = add @Autowired to class var in component that is dependency
    Where to search for beans - package? = will search in the whole package if we use @ComponentScan
        spring boot automatically uses component scan (@SpringBootApplication)


 */