package homework4;

public class HW4Tester {
	public static void main(String[] args) {
		String html = ("<ol><li> This course is about <b>data structures</b> and their implementation in the <b>Java language.</b></li><p><li>We will discuss Bags, Stacks, Queues, Lists, and Priority Queues</ol><p>In addition, we will discuss the running times of various operations on different data structures.");
		System.out.println(HTMLChecker.validPage(html)); //true
		html = ("<ol><li> This course is about <b>data structures and their implementation in the <b>Java language.</b></li><p><li>We will discuss Bags, Stacks, Queues, Lists, and Priority Queues</ol><p>In addition, we will discuss the running times of various operations on different data structures.");
		System.out.println(HTMLChecker.validPage(html)); //false
		html = ("<li> This course is about <b>data structures</b> and their implementation in the <b>Java language.</b></li><p><li>We will discuss Bags, Stacks, Queues, Lists, and Priority Queues</ol><p>In addition, we will discuss the running times of various operations on different data structures.");
		System.out.println(HTMLChecker.validPage(html)); //false
		html = ("<ol><li> This course is about <b>data structures</b> and their implementation in the <b>Java language.</b><p><li>We will discuss Bags, Stacks, Queues, Lists, and Priority Queues</ol><p>In addition, we will discuss the running times<br> of various operations<p> on different data structures.");
		System.out.println(HTMLChecker.validPage(html)); //true
		html = ("<blockquote><ol><li> This course is about <b>data structures</b> and their implementation in the <b>Java language.</b><p><li>We will discuss Bags, Stacks, Queues, Lists, and Priority Queues</ol><p>In addition, we will discuss the running times<br> of various operations<p> on different data structures.</blockquote>");
		System.out.println(HTMLChecker.validPage(html));//true
		
	
	}
}
 