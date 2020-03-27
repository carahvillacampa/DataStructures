/*
 * CSC 300 Sections Spring 2019 - Lytinen
 * 
 * Homework assignment 4:  the validPage method below is passed a String
 * consisting of HTML.  The method examines the contents of the
 * String and determines whether or not the String is valid HTML.
 * If so, the method returns true; otherwise it returns false.
 */
package homework4;
import java.util.Stack;

import homework4.ArrayStack300;
import homework4.Stack300;

public class HTMLChecker {

	private static final String[] END_OPTIONAL = {"p", "li"};
	// hr = horizontal line  br = break (newline)
	private static final String[] NO_END = {"br", "hr"}; 
	String [] END_REQUIRED;
	
	
	public static boolean validPage(String html) {
		Stack<String> startTags = new Stack<String>();

		
		int tagStartPosition = html.indexOf('<');
		boolean isStartTag;
		while (tagStartPosition != -1) {
		
			int tagEndPosition = html.indexOf('>', tagStartPosition+1);
			if (tagEndPosition == -1) return false;

		
			String tag = html.substring(tagStartPosition+1, 
					tagEndPosition); 
			//System.out.println(tag);
			
			if (tag.charAt(0) == '/') {
				tag = tag.substring(1);
				isStartTag = false;
			}
			else {isStartTag = true;}

			if (isStartTag && !noEnd(tag)) { 
				//System.out.println("Pushing: "+ tag);//incomplete isStartTag && noEnd(tag)
				startTags.push(tag);
				
			}
			else if (isStartTag &&noEnd(tag)) {System.out.println(tag);}
			else {
				String poppedTag=" ";
				if(startTags.isEmpty()) return false; 
				
				else {
					
					poppedTag=startTags.pop(); 
					//System.out.println("Popped: "+ tag);
					
					if(poppedTag.compareTo(tag) != 0) { 
						if(endRequired(poppedTag)) {
							return false;
						}
						else if((endOptional(poppedTag))) { 
							while(!startTags.isEmpty()) {
								poppedTag= startTags.pop();
								//System.out.println("End optional: "+ tag);
								if(poppedTag.compareTo(tag) == 0) { 
									return true;
								}
								else if(startTags.isEmpty()) {
									return false;
								}
								
						}
				  }
			}
		}
			
		}
		tagStartPosition = html.indexOf('<', tagEndPosition+1); 
		
		}
		if(startTags.isEmpty() || endOptional(html)) //endOptional(html)
			{return true;}
		
		return false;
		}
	
	
	private static boolean endRequired(String tag) {
		return !endOptional(tag) && !noEnd(tag);
	}

	private static boolean endOptional(String tag) {
		for (String t : END_OPTIONAL)
			if (tag.equals(t)) return true;
		return false;
	}

	private static boolean noEnd(String tag) {
		for (String t : NO_END)
			if (tag.equals(t)) return true;
		return false;
	}

}
