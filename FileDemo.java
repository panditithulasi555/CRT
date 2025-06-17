import java.io.*;
public class FileDemo
{
	public static void main(String args[])
	{
		try{
			BufferedWriter writer=new BufferedWriter(new FileWriter("students.txt"));
			String line;
			System.out.println("student names:");
			while((line=reader.readLine())!=null)
			{
				System.out.println(line);
			}
			reader.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}	
		