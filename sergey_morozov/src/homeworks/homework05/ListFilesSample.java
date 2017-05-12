package homeworks.homework05;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

public class ListFilesSample {

	int countString = 0;
	private int countDirectories = 0;
	private int countFiles = 0;
	
	public ListFilesSample (File f, FileWriter dataFile) {
	
			printListDirectories(f, dataFile);
			printListFiles(f, dataFile);
		
		}
	
	
	public void writeDataInFile (FileWriter dataFile, String s) {
	     try {
				dataFile.append(s);
				dataFile.append('\n');
				countString++;
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}
	
			
	public void printListFiles (File dir, FileWriter fileWriter) {
			
		File[] files = dir.listFiles( (f) -> f.isFile() );
		
		for(File f : files) {
			countFiles++;
			String s = f.getAbsolutePath() + " Size: " + f.length() + " ";
			System.out.println(s);
			writeDataInFile (fileWriter, s);
			
	}
}
	public void printListDirectories (File dir, FileWriter dataFile) {
		
		File[] files = dir.listFiles( (f1) -> f1.isDirectory());
		
		for(File fn : files) {
			countDirectories ++;
			printListDirectories(fn, dataFile);
				
			printListFiles (fn, dataFile);
			String s = fn.getAbsolutePath() + " Summary size: " + getSizeDirectory(fn) + " ";
			System.out.println(s);
			writeDataInFile (dataFile, s);
			}
	
}
	
	public long getSizeDirectory (File dir) {
		long size = 0;
		File[] files = dir.listFiles();
		for (File f : files) {
			if (f.isFile())
				size += f.length();
		else 
			size += getSizeDirectory(f);
	}
		return size;
	}
	
	
	public void printFileExt (File file, String ext) {
		FilenameFilter filter = new FilenameFilter() {			
			@Override
			public boolean accept(File file, String name) {
				//System.out.println("  filtering: " + name);
				return name.endsWith(ext);
			}
		};
		
		File[] filenames = file.listFiles( filter );
			for(File fn : filenames) {
				if (fn.isFile())
			System.out.println(fn);
				else printFileExt (fn, ext);
		}	
	}

	public int getCountString() {
		return countString;
	}

	public void setCountString(int countString) {
		this.countString = countString;
	}
	
	public int getCountDirectories() {
		return countDirectories;
	}

	public void setCountDirectories(int countDirectories) {
		this.countDirectories = countDirectories;
	}

	public int getCountFiles() {
		return countFiles;
	}

	public void setCountFiles(int countFiles) {
		this.countFiles = countFiles;
	}
}
