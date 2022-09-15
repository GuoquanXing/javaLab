package com.example.lab.demo;

import java.util.ArrayDeque;
import java.util.Deque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class	, args);

		int[] pushed = {1,2,3,4,5}, popped = {4,5,3,2,1};
		DemoApplication.validateStackSequences(pushed ,popped);

	}

	public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int m = pushed.length, n = popped.length;
        if (m != n) return false;

        Deque<Integer> stack = new ArrayDeque<>();

		for(int left = 0, right = 0; left < m; left++){
			stack.push(pushed[left++]);
			while(!stack.isEmpty() && stack.peek() == popped[right]){
				stack.pop();
				right++;
			}
		}
        return stack.isEmpty();
    }
}
