package com.example.lab.demo.datastructure.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayStackTests {

    @Test
	void testArrayStack(){
		ArrayStack<Integer> stack = new ArrayStack<>();
		assertEquals(0, stack.size());
		assertEquals(true, stack.isEmpty());
		
		assertThrows(RuntimeException.class, ()->{stack.peek();});

		stack.push(1);
		assertEquals(1, stack.size());
		assertEquals(false, stack.isEmpty());
		stack.push(2);
		assertEquals(2, stack.size());
		assertEquals(false, stack.isEmpty());
		stack.peek();
		assertEquals(2, stack.size());
		assertEquals(false, stack.isEmpty());
		stack.pop();
		assertEquals(1, stack.size());
		assertEquals(false, stack.isEmpty());
		stack.pop();
		assertEquals(0, stack.size());
		assertEquals(true, stack.isEmpty());
	}
    
}
