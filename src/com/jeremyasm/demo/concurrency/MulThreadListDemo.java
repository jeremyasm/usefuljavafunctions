package com.jeremyasm.demo.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * A demo to illustrate how to split a list to multiple sublists and execute thread on each sublists by using executor
 * @author liyaoxing
 *
 */
public class MulThreadListDemo {

	class PrintRunnable implements Runnable {

		List<Integer> list;

		PrintRunnable(List<Integer> list) {

			this.list = list;
		}

		@Override
		public void run() {
			for (int i = 0; i < list.size(); i++)
				System.out.println(Thread.currentThread().getName() + " - " + list.get(i));

		}

	}

	public static void main(String[] args) {
		
		MulThreadListDemo lt = new MulThreadListDemo();
		
		ExecutorService exec = Executors.newCachedThreadPool();

		// initialize globalList
		List<Integer> globalList = new ArrayList<Integer>();
		for (int i = 0; i < 10000; i++) {
			globalList.add(i);
		}

		// length of each sublist
		int lenOfSubList = 200;
		int lenOfList = globalList.size();

		if (lenOfList <= lenOfSubList) {
			
			System.out.println(globalList); // executor
			
		} else {

			int numOfSubLists = lenOfList / lenOfSubList;

			int cursor = 0;
			for (int i = 0; i < numOfSubLists; i++) {
				List<Integer> innerList = new ArrayList<Integer>();
				innerList.addAll(globalList.subList(cursor, cursor + lenOfSubList));
				exec.execute(lt.new PrintRunnable(innerList));
				cursor = cursor + lenOfSubList;
			}
			// if remainder exists
			if (cursor < lenOfList) {
				List<Integer> innerList = new ArrayList<Integer>();
				innerList.addAll(globalList.subList(cursor, lenOfList));
				exec.execute(lt.new PrintRunnable(innerList));
			}

		}//end else
		
		exec.shutdown();

	}

}
