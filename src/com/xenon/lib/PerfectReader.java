/*
 * Open-Source License, AcerOne10
 * PerfectReader is a part of Xenon Libraries
 */

package com.xenon.lib;

import java.io.BufferedReader;
import java.io.IOException;

/* 
 * This class provides functionality to use the BufferedReader Class 
 * from java.io.BufferedReader without the 'skip' problem persisting 
 * in the BuffererReader Class. 
 * 
 * <p>
 * Working:
 * <b>cRead() and its overrides<b> :
 * Accepts a character using the BufferedReader class as an ASCII code
 * Checks if its a valid ASCII (code > 30)
 * If not the loop repeats till it has satisfied the condition
 * Converts the returned ASCII to a character
 * Returns the character
 * 
 * <b>iRead() and its overrides<b> :
 * Accepts a character using the BufferedReader class as an ASCII code
 * Checks if its a valid ASCII (code > 30)
 * If not the loop repeats till it has satisfied the condition
 * Returns the ASCII code
 * 
 * <b>sRead() and its overrides<b> :
 * Simple implementation of the readLine() function of BufferedReader class.
 * </p>
 * 
 * @see BufferedReader
 * @see Reader
 * @see InputStreamReader
 * @see java.lang.System#in
 * 
 * @author: AcerOne10
 * @version: 1.0
 * @since: 1.0
 */
public class PerfectReader {
	/*
	 * Private Object-Reference to BufferedReader class
	 */
	private BufferedReader read;
	
	/*
	 * Constructor for PerfectReader class with an object of BufferedRead and allocates memory for
	 * the instance of BufferedReader
	 * 
	 * @param 	read	instance of BufferedReader
	 */
	public PerfectReader(BufferedReader read)
	{
		this.read = read;
	}
	
	/*
	 * Reads a single character from the user 
	 * using the read() function from java.io.BufferedReader
	 * 
	 * @since 1.0
	 * 
	 * @exception 	IOException 	If an I/O error occurs
	 */
	public char cRead() throws IOException
	{
		char ret = ' ';
		int val = read.read();
		boolean isValid = (val>30);
		while(!isValid)
		{
			val=read.read();
			isValid = (val>30);
		}
		byte b = (byte)val;
		ret = (char)b;
		return ret;
	}
	
	/*
	 * Reads 'number' of characters from the user 
	 * and buffers its output to a character array.
	 * 
	 * @since 1.0
	 * 
	 * @param 	number	  The number of characters to be read.
	 * 
	 * @exception	IOException		If an I/O error occurs
	 */
	public char[] cRead(int number) throws IOException
	{
		char[] ret = new char[number];
		int index=0;
		while(number>0)
		{
			int val = read.read();
			boolean isValid = (val>30);
			while(!isValid)
			{
				val=read.read();
				isValid = (val>30);
			}
			byte b = (byte)val;
			char c = (char)b;
			ret[index]=c;
			index++;
			number--;
		}
		return ret;
	}
	
	/*
	 * Reads a single character to a place 'offset' in character array.
	 * 
	 * @param 	c		The character array
	 * @param 	offset 	The place at which the character should be stored.
	 * 
	 * @exception	IOException 				If an I/O error occurs
	 * @exception 	ArrayOutOfBoundsException 	If the specified offset is invalid
	 */
	public void cRead(char[] c,int offset) throws IOException
	{
		cRead(c,offset,1);
	}
	
	/*
	 * Reads a 'number' characters starting from place 'offset' in character array.
	 * 
	 * @param 	c		The character array
	 * @param 	offset 	The place at which the character should be stored.
	 * @param 	number 	The number of characters to be read
	 * 
	 * @exception	IOException 				If an I/O error occurs
	 * @exception 	ArrayOutOfBoundsException 	If the specified offset is invalid
	 */
	public void cRead(char[] c,int offset,int number) throws IOException
	{
		if(c.length<offset || c.length<(offset+number))
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		int index=offset;
		while(number>0)
		{
			int val = read.read();
			boolean isValid = (val>30);
			while(!isValid)
			{
				val=read.read();
				isValid = (val>30);
			}
			byte b = (byte)val;
			char ch = (char)b;
			c[index]=ch;
			index++;
			number--;
		}
	}
	
	/*
	 * Reads a single character as an integer from the user 
	 * using the read() function from java.io.BufferedReader
	 * 
	 * @since 1.0
	 * 
	 * @exception 	IOException 	If an I/O error occurs
	 */
	public int iRead() throws IOException
	{
		int val = read.read();
		boolean isValid = (val>30);
		while(!isValid)
		{
			val=read.read();
			isValid = (val>30);
		}
		return val;
	}
	
	/*
	 * Reads 'number' of characters as integers from the user 
	 * and buffers its output to a integer array.
	 * 
	 * @since 1.0
	 * 
	 * @param 	number	  The number of characters to be read.
	 * 
	 * @exception	IOException		If an I/O error occurs
	 */
	public int[] iRead(int number) throws IOException
	{
		int[] ret = new int[number];
		int index=0;
		while(number>0)
		{
			int val = read.read();
			boolean isValid = (val>30);
			while(!isValid)
			{
				val=read.read();
				isValid = (val>30);
			}
			ret[index]=val;
			index++;
			number--;
		}
		return ret;
	}
	
	/*
	 * Reads a single character as an integer to a place 'offset' in an integer array.
	 * 
	 * @since 1.0
	 * 
	 * @param 	a		The integer array
	 * @param 	offset 	The place at which the character should be stored.
	 * 
	 * @exception	IOException 				If an I/O error occurs
	 * @exception 	ArrayOutOfBoundsException 	If the specified offset is invalid
	 */
	public void iRead(int[] a,int offset) throws IOException
	{
		iRead(a,offset,1);
	}
	
	/*
	 * Reads a 'number' characters as integers starting from place 'offset' in integer array.
	 * 
	 * @since 1.0
	 * 
	 * @param 	c		The integer array
	 * @param 	offset 	The place at which the character should be stored.
	 * @param 	number 	The number of characters to be read
	 * 
	 * @exception	IOException 				If an I/O error occurs
	 * @exception 	ArrayOutOfBoundsException 	If the specified offset is invalid
	 */
	public void iRead(int[] a,int offset,int number) throws IOException
	{
		if(a.length<offset || a.length<(offset+number))
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		int index=offset;
		while(number>0)
		{
			int val = read.read();
			boolean isValid = (val>30);
			while(!isValid)
			{
				val=read.read();
				isValid = (val>30);
			}
			a[index]=val;
			index++;
			number--;
		}
	}
	
	/*
	 * Reads a single line
	 * 
	 * @since 1.0
	 * 
	 * @exception	IOException 	If an I/O error occurs
	 */
	public String sRead() throws IOException
	{
		String s = read.readLine();
		return s;
	}
	
	/*
	 * Reads 'number' of lines
	 * 
	 * @since 1.0
	 * 
	 * @exception	IOException 	If an I/O error occurs
	 */
	public String sRead(int number) throws IOException
	{
		String s = "";
		while(number>0)
		{
			s = read.readLine();
		}
		return s;
	}
	
	/*
	 * Reads a single line and buffers it to place offset in a String array
	 * 
	 * @since 1.0
	 * 
	 * @exception	IOException 	If an I/O error occurs
	 */
	public void sRead(String[] s,int offset) throws IOException
	{
		sRead(s,offset,1);
	}
	
	/*
	 * Reads a 'number' of line and buffers it from a place offset in a String array
	 * 
	 * @since 1.0
	 * 
	 * @exception	IOException 	If an I/O error occurs
	 */
	public void sRead(String[] s,int offset,int number) throws IOException
	{
		if(s.length<offset || s.length<(offset+number))
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		int index=offset;
		while(number>0)
		{
			s[index]=sRead();
			index++;
			number--;
		}
	}
}
 