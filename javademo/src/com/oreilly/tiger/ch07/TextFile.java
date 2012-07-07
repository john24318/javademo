package com.oreilly.tiger.ch07;

import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class allows line-by-line iteration through a text file. The iterator's remove() method throws
 * UnsupportedOperatorException. The iterator wraps and rethrows IOExceptions as IllegalArgumentExceptions.
 */
public class TextFile implements Iterable<String> {

	// Used by the TextFileIterator class below
	final String filename;

	public TextFile(String filename) {
		this.filename = filename;
	}

	// This is the one method of the Iterable interface
	public Iterator<String> iterator() {
		return new TextFileIterator();
	}

	// This non-static member class is the iterator implementation
	class TextFileIterator implements Iterator<String> {

		// The stream we're reading from
		BufferedReader in;

		// Return value of next call to next()
		String nextline;

		public TextFileIterator() {
			// Open the file and read and remember the first line.
			// We peek ahead like this for the benefit of hasNext().
			try {
				in = new BufferedReader(new FileReader(filename));
				nextline = in.readLine();
			} catch (IOException e) {
				throw new IllegalArgumentException(e);
			}
		}

		// If the next line is non-null, then we have a next line
		public boolean hasNext() {
			return nextline != null;
		}

		// Return the next line, but first read the line that follows it.
		public String next() {
			try {
				String result = nextline;

				// If we haven't reached EOF yet
				if (nextline != null) {
					nextline = in.readLine(); // Read another line
					if (nextline == null)
						in.close(); // And close on EOF
				}

				// Return the line we read last time through.
				return result;
			} catch (IOException e) {
				throw new IllegalArgumentException(e);
			}
		}

		// The file is read-only; we don't allow lines to be removed.
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public static void main(String[] args) {
		String filename = "TextFile.java";
		if (args.length > 0)
			filename = args[0];

		for (String line : new TextFile(filename))
			System.out.println(line);
	}
}
